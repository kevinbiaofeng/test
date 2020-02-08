package com.xjw.service.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xjw.service.media.VideoService;
import com.xjw.utility.BizException;
/**
 *	更新1-3部电影状态为 显示
 */
@Component
public class UpdateVideoShowTask{
	private static Logger logger = LoggerFactory.getLogger(UpdateVideoShowTask.class);
	
	@Autowired
	private VideoService videoService;
	
	public void run()  {
		try {
			videoService.updateShow();
		} catch (BizException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

}
