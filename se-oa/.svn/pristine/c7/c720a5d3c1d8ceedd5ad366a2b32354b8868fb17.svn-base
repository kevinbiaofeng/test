package com.xjw.dao.platform;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.platform.NewPtGameData;
import com.xjw.entity.vo.data.SummaryBetVo;

@Repository
public class NewPTGameDataDao extends BaseDaoImpl<NewPtGameData>{
	public List<NewPtGameData> selectSumAll(Map<String, Object> condition){
		return this.getSqlSession().selectList("NewPtGameData.selectSumAll", condition);
	}
	
	public SummaryBetVo selectSumByDate(Map<String, Object> condition){
		return this.getSqlSession().selectOne("NewPtGameData.selectSumByDate", condition);
	}
}
