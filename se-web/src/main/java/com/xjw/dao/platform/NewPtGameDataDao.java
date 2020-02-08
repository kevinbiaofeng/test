package com.xjw.dao.platform;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.platform.NewPtGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;

@Repository
public class NewPtGameDataDao extends BaseDaoImpl<NewPtGameData>{
	
	public GameDataSumVo selectAllSum(Map<String, Object> params){
		return super.getSqlSession().selectOne("NewPtGameData.selectAllSum", params);
	}
}