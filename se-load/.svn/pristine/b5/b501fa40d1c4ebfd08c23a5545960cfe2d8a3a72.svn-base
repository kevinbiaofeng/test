package com.xjw.controller.media;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjw.common.result.ModelResult;
import com.xjw.controller.BaseController;
import com.xjw.entity.po.media.Favorite;
import com.xjw.entity.po.user.User;
import com.xjw.service.media.FavoriteService;
import com.xjw.service.media.VideoService;
import com.xjw.util.SessionManager;

@Controller
@RequestMapping("/favorite/")
public class FavoriteController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(FavoriteController.class);
	
	@Autowired
	private FavoriteService favoriteService;
	@Autowired
	private VideoService videoService;
	
	@RequestMapping("add")
	@ResponseBody
	public ModelResult<Integer> add(String code, HttpServletRequest request) {
		User user = SessionManager.getUserSession(request);
		
		if(StringUtils.isBlank(code)){
			return new ModelResult<>().withError("200", "请选择需要收藏的视频");
		}
		
		if(null == favoriteService.queryOne(user.getId(), code)){
			Favorite favorite = new Favorite();
			favorite.setUserId(user.getId());
			favorite.setVideoCode(code);
			
			try{
				favoriteService.save(favorite);
				videoService.updateFavoriteCount(code, 1);
				
			}catch(Exception e) {
				logger.error(e.getMessage(), e);
				return new ModelResult<>().withError("-1", "系统繁忙，请稍后再试");
			}
		}
		
		return new ModelResult<>().withSuccess();
	}
	
	@RequestMapping("remove")
	@ResponseBody
	public ModelResult<Integer> remove(String code, HttpServletRequest request) {
		User user = SessionManager.getUserSession(request);
		
		Map<String, Object> params = new HashMap<>();
		params.put("userId", user.getId());
		params.put("videoCode", code);
		try{
			Favorite favorite = favoriteService.queryOne(user.getId(), code);
			if(null != favorite) {
				favoriteService.deleteOne(params);
				videoService.updateFavoriteCount(code, -1);
			}
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
			return new ModelResult<>().withError("-1", "系统繁忙，请稍后再试");
		}
		
		return new ModelResult<>().withSuccess();
	}
}
