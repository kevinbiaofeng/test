package com.xjw.dao.platform;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.platform.FishGameData;
import com.xjw.entity.vo.platform.GameDataSumVo;

@Repository
public class FishGameDataDao extends BaseDaoImpl<FishGameData>{

	public GameDataSumVo selectAllSum(Map<String, Object> params){
		return super.getSqlSession().selectOne("FishGameData.selectAllSum", params);
	}
}
