package com.xjw.cache;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners;
import com.google.common.cache.RemovalNotification;
import com.xjw.service.media.VideoService;
import com.xjw.utility.BizException;

@Component
@EnableScheduling
public class VideoClickCache {
	private Logger logger = LoggerFactory.getLogger(VideoClickCache.class);

	@Autowired
	private VideoService videoService;

	private LoadingCache<String, Integer> cache = CacheBuilder.newBuilder().maximumSize(1024)
			.expireAfterWrite(1, TimeUnit.MINUTES)
			.removalListener(RemovalListeners.asynchronous(new RemovalListener<String, Integer>() {
				@Override
				public void onRemoval(RemovalNotification<String, Integer> notification) {
					if (RemovalCause.EXPIRED.equals(notification.getCause()) && notification.getValue() > 0) {
						try {
							videoService.updateClickCount(notification.getKey(), notification.getValue());
						} catch (BizException e) {
							logger.error(e.getMessage(), e);
						}
					}
				}
			}, Executors.newSingleThreadExecutor())).build(new CacheLoader<String, Integer>() {
				public Integer load(String code) {
					return 0;
				}
			});

	public Integer increment(String code) {
		if (StringUtils.isNotBlank(code)) {
			int clickCount = cache.getUnchecked(code) + 1;
			cache.put(code, clickCount);

			return clickCount;
		}

		return 0;
	}
	
	@Scheduled(cron = "0 0/1 *  * * ? ") 
	public void cleanUp() {
		cache.cleanUp();
	}
}
