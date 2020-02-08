package com.xjw.dao.sys;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xjw.entity.po.user.Agent;
import com.xjw.entity.po.user.Member;
import com.xjw.service.user.AgentService;
import com.xjw.service.user.MemberService;

@Controller
@RequestMapping("/exp")
public class ExpController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private AgentService agentService;

	@RequestMapping("member")
	@ResponseBody
	public String member(@RequestParam(value="beginTime", required=false) String beginTime, 
						@RequestParam(value="endTime", required=false) String endTime){
		if(StringUtils.isBlank(beginTime) && StringUtils.isBlank(endTime)){
			Calendar time = Calendar.getInstance();
			time.add(Calendar.DATE, -3);
			beginTime = DateFormatUtils.format(time, "yyyy-MM-dd");
		}
		
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(beginTime)){
			beginTime = beginTime + " 00:00:00";
			params.put("beginTime", beginTime);
		}
		if(StringUtils.isNotBlank(endTime)){
			endTime = endTime + " 23:59:59";
			params.put("endTime", endTime);
		}
		
		List<Member> memberList = memberService.selectAll(params);
		for(Member m : memberList) {
			memberService.decodeMember(m);
		}
		
		return JSONArray.toJSONString(memberList, SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("agent")
	@ResponseBody
	public String agent(@RequestParam(value="pageNo", defaultValue="1") Integer pageNo, 
			@RequestParam(value="pageSize", required=false) Integer pageSize){
		Map<String, Object> params = new HashMap<String, Object>();
		if(null != pageSize){
			params.put("begin", pageNo);
			params.put("pageSize", pageSize);
		}
		
		List<Agent> agentList = agentService.selectAll(params);
		return JSONArray.toJSONString(agentList, SerializerFeature.WriteDateUseDateFormat);
	}
}
