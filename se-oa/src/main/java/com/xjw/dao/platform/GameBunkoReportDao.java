package com.xjw.dao.platform;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.entity.po.platform.GameBunkoReport;

@Repository
public class GameBunkoReportDao extends BaseDaoImpl<GameBunkoReport>{
	//查询NewPt的投注额和输赢额度总额
	public List<GameBunkoReport> selectNewPtByLogiName(Map<String, Object> params){
		return super.getSqlSession().selectList("GameBunkoReport.selectNewPtByLogiName", params);
	}
	
	//查询NewMg的投注额和输赢额度总额
	public List<GameBunkoReport> selectNewMgByLogiName(Map<String, Object> params){
		return super.getSqlSession().selectList("GameBunkoReport.selectNewMgByLogiName", params);
	}
	
	//查询XIN的投注额和输赢额度总额
	public List<GameBunkoReport>  selectXinByLogiName(Map<String, Object> params){
		return super.getSqlSession().selectList("GameBunkoReport.selectXinByLogiName", params);
	}
	
}
