package com.xjw.service.user;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.user.Agent;

@Service
public interface AgentService extends BaseServcie<Agent>{
		public void saveAgent(User user, Agent agent) throws Exception;
		public void updateAgent(User user, Agent agent) throws Exception;
	
		/**
		 * 验证推广代码是否存在
		 * @return
		 */
		public Agent checkPromotionCode(String promotionCode);
		
		/** 验证代理网址是否存在 **/
		public Agent checkPromotionUrl(String promotionUrl);
}
