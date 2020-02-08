package com.xjw.service.user;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.user.FundAdjustActivityCount;
import com.xjw.entity.po.user.MemberMoneyChange;

@Service
public interface MemberMoneyChangeService extends BaseServcie<MemberMoneyChange> {
	public String saveMoneyChangeAndUpdateAccount(MemberMoneyChange memberMoneyChange) throws Exception;
	
	/** 查询代理的下属会员存款总额 */
	public BigDecimal selectAmountByAgent(Map<String, Object> params);
	
	/** 查询资金调整活动总金额 */
	public List<FundAdjustActivityCount> selectHDAmount(Map<String, Object> params);
	
	/** 查询资金调整返水总金额 */
	public BigDecimal selectFSAmount(Map<String, Object> params);
	
	/** 查询资金调整特殊奖金总金额 */
	public BigDecimal selectTSJJAmount(Map<String, Object> params);
	
	/** 查询资金调整其它总金额 */
	public BigDecimal selectQTAmount(Map<String, Object> params);
}
