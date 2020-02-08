package com.xjw.dao.data;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.data.SummaryDay;

@Repository
public class SummaryDayDao extends BaseDaoImpl<SummaryDay>{
	/**
	 * 根据创建时间，查询当天的所有统计数据
	 * @param params
	 * @return SummaryDay
	 */
	public SummaryDay selectSummaryDay(Map<String, Object> params){
		return this.getSqlSession().selectOne("SummaryDay.selectByDayTime", params);
	}
}
