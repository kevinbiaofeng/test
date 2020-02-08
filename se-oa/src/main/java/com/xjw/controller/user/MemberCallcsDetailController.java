package com.xjw.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.entity.po.user.MemberCallcsDetail;
import com.xjw.kzenum.user.MemberCallcsDetailCallcsTypeEnum;
import com.xjw.service.sys.UserService;
import com.xjw.service.user.MemberCallcsDetailService;
import com.xjw.service.user.MemberRemarkService;
import com.xjw.utility.BizException;
import com.xjw.utility.StringUtil;

/**
 * 电销通话记录
 * @author KevinZ
 */
@Controller
@RequestMapping("/member/callcs/")
public class MemberCallcsDetailController extends BaseController{
  private static Logger logger= LoggerFactory.getLogger(MemberCallcsDetailController.class.getName());
  @Resource
  private MemberCallcsDetailService memberCallcsDetailService;
  @Resource
  private MemberRemarkService memberRemarkService;
  @Resource
  private UserService userService;
  
  @RequestMapping("/save")
  @ResponseBody
  public String save(@RequestParam("id") String id, @RequestParam("userId") Long userId,  @RequestParam("remark") String remark, 
		  @RequestParam("callcsStatus") Integer callcsStatus, @RequestParam("callcsType") Integer callcsType, Model model) throws BizException {
	  JSONObject jsonObj = new JSONObject();
	  Map <String, Object> params = new HashMap<String, Object>();
	  params.put("remark", remark);
	  params.put("userId", userId);
	  params.put("callcsStatus", callcsStatus);
	  params.put("callcsType", callcsType);
	try{
		if(StringUtil.isNotBlank(id)){
			params.put("id", id);
			memberCallcsDetailService.update(params);
		}else{
			MemberCallcsDetail memberCallcsDetail = new MemberCallcsDetail();
			memberCallcsDetail.setUserId(userId);
			memberCallcsDetail.setRemark(remark);
			memberCallcsDetail.setCallcsStatus(callcsStatus);
			memberCallcsDetail.setCallcsType(callcsType);
			memberCallcsDetailService.save(memberCallcsDetail);
		}
		//添加电销回访记录 至 用户备注
//		MemberRemark memberRemark = new MemberRemark();
//		memberRemark.setUserId(userId);
//		memberRemark.setTitleType(Integer.valueOf(RemarkTitleTypeEnum.DX.getCode()));
//		memberRemark.setStatus(Integer.valueOf(MemberRemarkStatusEnum.DEFAULT.getCode()));
//		memberRemark.setRemark(MemberCallcsDetailCallcsTypeEnum.getNameByCode(MemberCallcsDetailCallcsTypeEnum.class, String.valueOf(callcsType)) + "\n" + remark);
//		memberRemarkService.save(memberRemark);
		
		if(String.valueOf(callcsType).equals(MemberCallcsDetailCallcsTypeEnum.CLOSE_MEMBER.getCode())){
			//状态等于3  关闭该用户
			if(userId < 0){
	    		return "0";
	    	}
	    	List<Long> ids = new ArrayList<Long>();
	    	ids.add(userId);
	    	userService.delete(ids);
		}
		jsonObj.put("code", "1");
	}catch(Exception e){
		logger.error(e.getMessage(), e);
		logger.error("---fill---:" + e.fillInStackTrace());
		logger.error("---msg---:"+ e.getMessage());
		logger.error("---e---:" + e.toString());
		jsonObj.put("code", "0");
	}
	
	return String.valueOf(jsonObj);
  }
}
