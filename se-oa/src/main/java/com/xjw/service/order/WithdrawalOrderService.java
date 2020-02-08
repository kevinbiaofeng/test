package com.xjw.service.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.form.order.WithdrawalOrderForm;
import com.xjw.entity.po.order.WithdrawalOrder;
import com.xjw.entity.po.order.WithdrawalTimeCount;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.vo.order.DrawalCount;
import com.xjw.entity.vo.order.WithdrawalOrderVo;
import com.xjw.utility.BizException;

@Service
public interface WithdrawalOrderService extends BaseServcie<WithdrawalOrder>{
	
	/**
	 * 创建提款订单
	 * @param withdrawalOrder
	 * @throws BizException
	 */
	public WithdrawalOrder createWithdrawalOrder(WithdrawalOrderVo withdrawalOrderVo) throws Exception;
	
	
	/**
	 * 审核成功 添加审核人  添加财务消息提醒
	 */
	public void updateExamineSucc(User user, WithdrawalOrderForm withdrawalOrderForm) throws BizException;
	
	/**
	 * 审核失败 添加订单备注  并增加金额到用户主账户
	 */
	public void updateExamineFail(WithdrawalOrderForm withdrawalOrderForm) throws BizException;
	
	/** 审核同意 */
	public void updateByAuditSuccess(Long id) throws BizException;
	
	/** 审核拒绝 */
	public void updateByAuditFail(Long id, String remark) throws BizException;
	
	/** 查询代理的下属会员存款总额 */
	public BigDecimal selectAmountByAgent(Map<String, Object> params);
	
	/** 查询时间段内，提款订单超过5分钟审核的单据  **/
	public List<WithdrawalTimeCount> getWithdrawalOrderListByTime(Map<String, Object> params);
	
	/**根据当前用户查询提款记录是否有成功过的记录 **/
	public List<DrawalCount> getDrawalCount(Map<String, Object> params);
	
}
