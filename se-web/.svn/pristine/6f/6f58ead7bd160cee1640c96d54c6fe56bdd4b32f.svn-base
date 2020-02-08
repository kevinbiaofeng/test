package com.xjw.dao.platform;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.platform.SBGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;

@Repository
public class SBGameDataDao extends BaseDaoImpl<SBGameData>{

	public GameDataSumVo selectAllSum(Map<String, Object> params){
		return super.getSqlSession().selectOne("SBGameData.selectAllSum", params);
	}
}
