package com.xjw.dao.platform;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.platform.NewMgGameData;
import com.xjw.entity.vo.data.SummaryBetVo;

@Repository
public class NewMgGameDataDao extends BaseDaoImpl<NewMgGameData>{
	public List<NewMgGameData> selectSumAll(Map<String, Object> condition){
		return this.getSqlSession().selectList("NewMgGameData.selectSumAll", condition);
	}
	
	public SummaryBetVo selectSumByDate(Map<String, Object> condition){
		return this.getSqlSession().selectOne("NewMgGameData.selectSumByDate", condition);
	}
}
