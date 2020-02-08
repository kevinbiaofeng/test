package com.xjw.dao.platform;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.cathectic.NewMgGame;
import com.xjw.entity.po.cathectic.NewPtGame;
import com.xjw.entity.po.platform.Cathectic;

@Repository
public class CathecticDao extends BaseDaoImpl<Cathectic> {

	public List<NewPtGame> selectSumAmountByNewPt(Map<String, Object> params) {
		return super.getSqlSession().selectList("Cathectic.selectSumAmountByNewPt", params);
	}

	public List<NewMgGame> selectSumAmountByNewMg(Map<String, Object> params) {
		return super.getSqlSession().selectList("Cathectic.selectSumAmountByNewMg", params);
	}

}
