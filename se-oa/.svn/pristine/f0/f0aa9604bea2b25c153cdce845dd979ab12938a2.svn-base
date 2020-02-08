package com.xjw.service.data.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.data.SummaryDayDao;
import com.xjw.dao.order.DepositOrderDao;
import com.xjw.dao.order.WithdrawalOrderDao;
import com.xjw.dao.platform.NewMgGameDataDao;
import com.xjw.dao.platform.NewPTGameDataDao;
import com.xjw.dao.user.MemberDao;
import com.xjw.dao.user.MemberMoneyChangeDao;
import com.xjw.entity.po.data.SummaryDay;
import com.xjw.entity.vo.data.SummaryBetVo;
import com.xjw.entity.vo.data.SummaryDepositVo;
import com.xjw.service.data.SummaryDayService;
import com.xjw.utility.BizException;

@Service
public class SummaryDayServiceImpl extends BaseServiceImpl<SummaryDay> implements SummaryDayService {
	private static Logger logger = LoggerFactory.getLogger(SummaryDayServiceImpl.class.getName());
	@Autowired
	private SummaryDayDao summaryDayDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private DepositOrderDao depositOrderDao;
	@Autowired
	private WithdrawalOrderDao withdrawalOrderDao;
	@Autowired
	private MemberMoneyChangeDao memberMoneyChangeDao;
	@Autowired
	private NewPTGameDataDao newPTGameDataDao;
	@Autowired
	private NewMgGameDataDao newMGGameDataDao;
	
	public void save(Date dayTime) throws BizException{
		String queryString = DateFormatUtils.format(dayTime, "yyyy-MM-dd");
		
		String beginTime = queryString + " 00:00:00";
		String endTime = queryString + " 23:59:59";
		Calendar nowTime = Calendar.getInstance();
		
		//会员总数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("beginTime", beginTime);
		params.put("endTime", endTime);
		
		Long userCount = memberDao.selectAllCount("Member.selectAllCount", params);
		
		BigDecimal depositAmount = depositOrderDao.selectSumAmount(params);
		BigDecimal withdrawalAmount = withdrawalOrderDao.selectSumAmount(params);
		BigDecimal promotionAmount = memberMoneyChangeDao.selectSumAmount(params);
		
		SummaryBetVo newPtBetVo = newPTGameDataDao.selectSumByDate(params);
		SummaryBetVo newMgBetVo = newMGGameDataDao.selectSumByDate(params);
		
		List<SummaryDepositVo> depositVoList = depositOrderDao.selectSumAmountGroupByTradeMode(params);
		JSONObject depositExt = new JSONObject();
		for(SummaryDepositVo depositVo : depositVoList){
			depositExt.put(depositVo.getTradeMode().toString(), depositVo.getTradeAmount());
		}
		
		SummaryDay summaryDay = new SummaryDay();
		summaryDay.setUserCount(userCount.intValue());
		summaryDay.setDepositAmount(depositAmount);
		summaryDay.setWithdrawalAmount(withdrawalAmount);
		summaryDay.setPromotionAmount(promotionAmount);
		
		summaryDay.setNewPtBetAmount(newPtBetVo.getBetAmount());
		summaryDay.setNewPtNetAmount(newPtBetVo.getNetAmount().subtract(newPtBetVo.getBetAmount()));
		
		summaryDay.setNewMgBetAmount(newMgBetVo.getBetAmount());
		summaryDay.setNewMgNetAmount(newMgBetVo.getNetAmount().subtract(newMgBetVo.getBetAmount()));
		
		summaryDay.setDayTime(dayTime);
		summaryDay.setDepositExt(JSONObject.toJSONString(depositExt));
		summaryDay.setCreateTime(nowTime.getTime());
		summaryDayDao.save("SummaryDay.save", summaryDay);
	}
	
	@Override
	public BaseDaoImpl<SummaryDay> baseDao() {
		return summaryDayDao;
	}

	@Override
	public Class<SummaryDay> getClazz() {
		return SummaryDay.class;
	}
}
