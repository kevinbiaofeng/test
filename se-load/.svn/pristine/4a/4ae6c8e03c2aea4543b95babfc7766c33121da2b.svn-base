package com.xjw.controller.platform;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.platform.GameRecordForm;
import com.xjw.entity.po.platform.AGGameData;
import com.xjw.entity.po.platform.FishGameData;
import com.xjw.entity.po.platform.MGGameData;
import com.xjw.entity.po.platform.NewMgGameData;
import com.xjw.entity.po.platform.NewPtGameData;
import com.xjw.entity.po.platform.PTGameData;
import com.xjw.entity.po.platform.QPGameData;
import com.xjw.entity.po.platform.SBGameData;
import com.xjw.entity.po.platform.XinGameData;
import com.xjw.entity.po.user.User;
import com.xjw.entity.vo.platform.GameDataSumVo;
import com.xjw.service.platform.AGGameDataService;
import com.xjw.service.platform.FishGameDataService;
import com.xjw.service.platform.MGGameDataService;
import com.xjw.service.platform.NewMgGameDataService;
import com.xjw.service.platform.NewPtGameDataService;
import com.xjw.service.platform.PTGameDataService;
import com.xjw.service.platform.QPGameDataService;
import com.xjw.service.platform.SBGameDataService;
import com.xjw.service.platform.XinGameDataService;
import com.xjw.util.SessionManager;
import com.xjw.utility.DateUtil;

/**
 * 投注记录 
 */
@Controller
@RequestMapping("/platform/betrecord")
public class BetRecordController extends BaseController{
	  private static Logger logger = LoggerFactory.getLogger(BetRecordController.class.getName());
	  
	  @Resource
		private AGGameDataService agGameDataService;
		@Resource
		private PTGameDataService ptGameDataService;
		@Resource
		private NewPtGameDataService newPtGameDataService;
		@Resource
		private MGGameDataService mgGameDataService;
		@Autowired
		private NewMgGameDataService newMgGameDataService;
		@Resource
		private XinGameDataService xinGameDataService;
		@Resource
		private FishGameDataService fishGameDataService;
		@Resource
		private QPGameDataService qpGameDataService;
		@Resource
		private SBGameDataService sbGameDataService;
	  
	  @RequestMapping("")
	  public String index(){
		  return "/xjw/platform/betrecord-index";
	  }
	  
	  /**
		 * AG游戏数据
		 */
	  @RequestMapping("/page/ag")
	  public String ag(GameRecordForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model, HttpServletRequest request){
		  User user = SessionManager.getUserSession(request);
		  pageNo = (null == pageNo ? 1 : pageNo);
		
		  Map<String, Object> params = new HashMap<String, Object>();
		  params.put("userId", user.getId());
		  params.put("platformType", form.getPlatformType());
		  String gameCode = form.getGameCode();
		  if(StringUtils.isNotEmpty(gameCode)){
			  params.put("gameCode", gameCode);
		  }
		  String beginTime = form.getBeginTime();
		  Date date = new Date();
		  if(StringUtils.isNotEmpty(beginTime)){
			  params.put("localBeginTime", beginTime);
		  }else{
			  params.put("localBeginTime", DateUtil.addDays(DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd", -1));
		  }
		  
		  String endTime = form.getEndTime();
		  if(StringUtils.isNotEmpty(endTime)){
			  params.put("localEndTime", endTime);
		  }else{
			  params.put("localEndTime", DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"));
		  }
		
		  try{
			  Page<AGGameData> page = agGameDataService.getPage(params, pageNo, pageSize);
			  model.addAttribute("page", page);
			
			  GameDataSumVo sumVo = agGameDataService.selectAllSum(params);
			  model.addAttribute("sumVo", sumVo);
		  }catch(Exception e){
			  logger.error(e.getMessage(), e);
		  }
		
		  model.addAttribute("form", form);
		  this.setBeforeAndEndTimeList(model);
		  return "/xjw/platform/betrecord-ag";
	  }
		
		
		/**
		 * PT游戏数据
		 */
		@RequestMapping("/page/pt")
		public String pt(GameRecordForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model, HttpServletRequest request){
			User user = SessionManager.getUserSession(request);
			pageNo = (null == pageNo ? 1 : pageNo);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", user.getId());
			params.put("gameCategory", form.getPlatformType()); //真人游戏
			String gameCode = form.getGameCode();
			if(StringUtils.isNotEmpty(gameCode)){
				params.put("gameCode", gameCode);
			}
			String beginTime = form.getBeginTime();
			Date date = new Date();
			if(StringUtils.isNotEmpty(beginTime)){
				params.put("localBeginTime", beginTime);
			}else{
				params.put("localBeginTime", DateUtil.addDays(DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd", -1));
			}
			
			String endTime = form.getEndTime();
			if(StringUtils.isNotEmpty(endTime)){
				params.put("localEndTime", endTime);
			}else{
				params.put("localEndTime", DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"));
			}
			
			try{
				Page<PTGameData> page = ptGameDataService.getPage(params, pageNo, pageSize);
				model.addAttribute("page", page);
				
				GameDataSumVo sumVo = ptGameDataService.selectAllSum(params);
				model.addAttribute("sumVo", sumVo);
			}catch(Exception e){
				logger.error(e.getMessage(), e);
			}
			
			model.addAttribute("form", form);
			this.setBeforeAndEndTimeList(model);
			return "/xjw/platform/betrecord-pt";
		}
		
		
		/**
		 * MG游戏数据
		 */
		@RequestMapping("/page/mg")
		public String mg(GameRecordForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model, HttpServletRequest request){
			User user = SessionManager.getUserSession(request);
			pageNo = (null == pageNo ? 1 : pageNo);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", user.getId());
			params.put("gameCategory", form.getPlatformType()); //真人游戏
			String billNo = form.getBillNo();
			if(StringUtils.isNotEmpty(billNo)){
				params.put("billNo", billNo);
			}
			String beginTime = form.getBeginTime();
			Date date = new Date();
			if(StringUtils.isNotEmpty(beginTime)){
				params.put("localBeginTime", beginTime);
			}else{
				params.put("localBeginTime", DateUtil.addDays(DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd", -1));
			}
			
			String endTime = form.getEndTime();
			if(StringUtils.isNotEmpty(endTime)){
				params.put("localEndTime", endTime);
			}else{
				params.put("localEndTime", DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"));
			}
			
			try{
				Page<MGGameData> page = mgGameDataService.getPage(params, pageNo, pageSize);
				model.addAttribute("page", page);
				
				GameDataSumVo sumVo = mgGameDataService.selectAllSum(params);
				model.addAttribute("sumVo", sumVo);
			}catch(Exception e){
				logger.error(e.getMessage(), e);
			}
			
			model.addAttribute("form", form);
			this.setBeforeAndEndTimeList(model);
			return "/xjw/platform/betrecord-mg";
		}
		
		/**
		 * XIN游戏数据
		 */
		@RequestMapping("/page/xin")
		public String xin(GameRecordForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model, HttpServletRequest request){
			User user = SessionManager.getUserSession(request);
			pageNo = (null == pageNo ? 1 : pageNo);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", user.getId());
			String billNo = form.getBillNo();
			if(StringUtils.isNotEmpty(billNo)){
				params.put("billNo", billNo);
			}
			String beginTime = form.getBeginTime();
			Date date = new Date();
			if(StringUtils.isNotEmpty(beginTime)){
				params.put("localBeginTime", beginTime);
			}else{
				params.put("localBeginTime", DateUtil.addDays(DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd", -1));
			}
			
			String endTime = form.getEndTime();
			if(StringUtils.isNotEmpty(endTime)){
				params.put("localEndTime", endTime);
			}else{
				params.put("localEndTime", DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"));
			}
			
			try{
				Page<XinGameData> page = xinGameDataService.getPage(params, pageNo, pageSize);
				model.addAttribute("page", page);
				
				GameDataSumVo sumVo = xinGameDataService.selectAllSum(params);
				model.addAttribute("sumVo", sumVo);
			}catch(Exception e){
				logger.error(e.getMessage(), e);
			}
			
			model.addAttribute("form", form);
			this.setBeforeAndEndTimeList(model);
			return "/xjw/platform/betrecord-xin";
		}
		
		/**
		 * 捕鱼王游戏数据
		 */
		@RequestMapping("/page/fish")
		public String fish(GameRecordForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model, HttpServletRequest request){
			User user = SessionManager.getUserSession(request);
			pageNo = (null == pageNo ? 1 : pageNo);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", user.getId());
			String billNo = form.getBillNo();
			if(StringUtils.isNotEmpty(billNo)){
				params.put("sceneId", billNo);
			}
			String beginTime = form.getBeginTime();
			Date date = new Date();
			if(StringUtils.isNotEmpty(beginTime)){
//				params.put("localBeginTime", beginTime);
			}else{
//				params.put("localBeginTime", DateUtil.addDays(DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd", -1));
			}
			
			String endTime = form.getEndTime();
			if(StringUtils.isNotEmpty(endTime)){
				params.put("localEndTime", endTime);
			}else{
				params.put("localEndTime", DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"));
			}
			
			try{
				Page<FishGameData> page = fishGameDataService.getPage(params, pageNo, pageSize);
				model.addAttribute("page", page);
				
				GameDataSumVo sumVo = fishGameDataService.selectAllSum(params);
				model.addAttribute("sumVo", sumVo);
			}catch(Exception e){
				logger.error(e.getMessage(), e);
			}
			
			model.addAttribute("form", form);
			this.setBeforeAndEndTimeList(model);
			return "/xjw/platform/betrecord-fish";
		}
		
		
		/**
		 * 棋牌游戏数据
		 */
		@RequestMapping("/page/qp")
		public String qp(GameRecordForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model, HttpServletRequest request){
			User user = SessionManager.getUserSession(request);
			pageNo = (null == pageNo ? 1 : pageNo);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", user.getId());
			String billNo = form.getBillNo();
			if(StringUtils.isNotEmpty(billNo)){
				params.put("billNo", billNo);
			}
			String beginTime = form.getBeginTime();
			Date date = new Date();
			if(StringUtils.isNotEmpty(beginTime)){
				params.put("localBeginTime", beginTime);
			}else{
				params.put("localBeginTime", DateUtil.addDays(DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd", -1));
			}
			
			String endTime = form.getEndTime();
			if(StringUtils.isNotEmpty(endTime)){
				params.put("localEndTime", endTime);
			}else{
				params.put("localEndTime", DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"));
			}
			
			try{
				Page<QPGameData> page = qpGameDataService.getPage(params, pageNo, pageSize);
				model.addAttribute("page", page);
				
				GameDataSumVo sumVo = qpGameDataService.selectAllSum(params);
				model.addAttribute("sumVo", sumVo);
			}catch(Exception e){
				logger.error(e.getMessage(), e);
			}
			
			model.addAttribute("form", form);
			this.setBeforeAndEndTimeList(model);
			return "/xjw/platform/betrecord-qp";
		}
		
		/**
		 * 沙巴游戏数据
		 */
		@RequestMapping("/page/sb")
		public String sb(GameRecordForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model, HttpServletRequest request){
			User user = SessionManager.getUserSession(request);
			pageNo = (null == pageNo ? 1 : pageNo);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", user.getId());
			String billNo = form.getBillNo();
			if(StringUtils.isNotEmpty(billNo)){
				params.put("billNo", billNo);
			}
			String beginTime = form.getBeginTime();
			Date date = new Date();
			if(StringUtils.isNotEmpty(beginTime)){
				params.put("localBeginTime", beginTime);
			}else{
				params.put("localBeginTime", DateUtil.addDays(DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd", -1));
			}
			
			String endTime = form.getEndTime();
			if(StringUtils.isNotEmpty(endTime)){
				params.put("localEndTime", endTime);
			}else{
				params.put("localEndTime", DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"));
			}
			
			try{
				Page<SBGameData> page = sbGameDataService.getPage(params, pageNo, pageSize);
				model.addAttribute("page", page);
				
				GameDataSumVo sumVo = sbGameDataService.selectAllSum(params);
				model.addAttribute("sumVo", sumVo);
			}catch(Exception e){
				logger.error(e.getMessage(), e);
			}
			
			model.addAttribute("form", form);
			this.setBeforeAndEndTimeList(model);
			return "/xjw/platform/betrecord-sb";
		}
		
		/**
		 * NewMg游戏数据
		 */
		@RequestMapping("/page/newmg")
		public String newmg(GameRecordForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model, HttpServletRequest request){
			User user = SessionManager.getUserSession(request);
			pageNo = (null == pageNo ? 1 : pageNo);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", user.getId());
			
			String billNo = form.getBillNo();
			if(StringUtils.isNotEmpty(billNo)){
				params.put("billNo", billNo);
			}
			String beginTime = form.getBeginTime();
			Date date = new Date();
			if(StringUtils.isNotEmpty(beginTime)){
				params.put("beginLocalTime", beginTime);
			}else{
				params.put("beginLocalTime", DateUtil.addDays(DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd", -1));
			}
			
			String endTime = form.getEndTime();
			if(StringUtils.isNotEmpty(endTime)){
				params.put("endLocalTime", endTime);
			}else{
				params.put("endLocalTime", DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"));
			}
			
			try{
				Page<NewMgGameData> page = newMgGameDataService.getPage(params, pageNo, pageSize);
				model.addAttribute("page", page);
				
				GameDataSumVo sumVo = newMgGameDataService.selectAllSum(params);
				model.addAttribute("sumVo", sumVo);
			}catch(Exception e){
				logger.error(e.getMessage(), e);
			}
			
			model.addAttribute("form", form);
			this.setBeforeAndEndTimeList(model);
			return "/xjw/platform/betrecord-newmg";
		}
		
		/**
		 * NewPt游戏数据
		 */
		@RequestMapping("/page/newpt")
		public String newpt(GameRecordForm form, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, Model model, HttpServletRequest request){
			User user = SessionManager.getUserSession(request);
			pageNo = (null == pageNo ? 1 : pageNo);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", user.getId());
			
			String billNo = form.getBillNo();
			if(StringUtils.isNotEmpty(billNo)){
				params.put("billNo", billNo);
			}
			String beginTime = form.getBeginTime();
			Date date = new Date();
			if(StringUtils.isNotEmpty(beginTime)){
				params.put("beginLocalTime", beginTime);
			}else{
				params.put("beginLocalTime", DateUtil.addDays(DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd", -1));
			}
			
			String endTime = form.getEndTime();
			if(StringUtils.isNotEmpty(endTime)){
				params.put("endLocalTime", endTime);
			}else{
				params.put("endLocalTime", DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"));
			}
			
			try{
				Page<NewPtGameData> page = newPtGameDataService.getPage(params, pageNo, pageSize);
				model.addAttribute("page", page);
				
				GameDataSumVo sumVo = newPtGameDataService.selectAllSum(params);
				model.addAttribute("sumVo", sumVo);
			}catch(Exception e){
				logger.error(e.getMessage(), e);
			}
			
			model.addAttribute("form", form);
			this.setBeforeAndEndTimeList(model);
			return "/xjw/platform/betrecord-newpt";
		}
		
		private void setBeforeAndEndTimeList(Model model){
			Date date = new Date();
			String nowTime = DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
			List<String> timeList = new ArrayList<String>();
			timeList.add(DateUtil.format(date, "yyyy-MM-dd"));
			timeList.add(DateUtil.addDays(nowTime, "yyyy-MM-dd", -1));
			timeList.add(DateUtil.addDays(nowTime, "yyyy-MM-dd", -2));
			timeList.add(DateUtil.addDays(nowTime, "yyyy-MM-dd", -3));
			timeList.add(DateUtil.addDays(nowTime, "yyyy-MM-dd", -4));
			timeList.add(DateUtil.addDays(nowTime, "yyyy-MM-dd", -5));
			timeList.add(DateUtil.addDays(nowTime, "yyyy-MM-dd", -6));
			timeList.add(DateUtil.addDays(nowTime, "yyyy-MM-dd", -7));
			model.addAttribute("timeList", timeList);
		}
}
