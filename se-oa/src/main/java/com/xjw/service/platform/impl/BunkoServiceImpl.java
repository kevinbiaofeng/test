package com.xjw.service.platform.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.BunkoDao;
import com.xjw.dao.user.MemberDao;
import com.xjw.entity.po.platform.Bunko;
import com.xjw.entity.po.user.Member;
import com.xjw.service.platform.BunkoService;

@Service
public class BunkoServiceImpl extends BaseServiceImpl<Bunko> implements BunkoService {

	@Autowired
	private BunkoDao bunkoDao;

	@Autowired
	private MemberDao memberDao;

	public Bunko selectByAgent(Map<String, Object> params) {
		Member member = memberDao.selectAgentById((Long) params.get("parentId"));

		Bunko bunko = new Bunko();
		bunko.setId(member.getId());
		bunko.setLoginName(member.getLoginName());
		bunko.setAggjAmount(bunkoDao.selectSumNetAmountByAggj(params));
		bunko.setAgjsAmount(bunkoDao.selectSumNetAmountByAgjs(params));
		bunko.setPtAmount(bunkoDao.selectSumNetAmountByPt(params));
		bunko.setMgAmount(bunkoDao.selectSumNetAmountByMg(params));
		bunko.setTtgAmount(bunkoDao.selectSumNetAmountByTtg(params));
		bunko.setEndoAmount(bunkoDao.selectSumNetAmountByEndo(params));
		bunko.setXinAmount(bunkoDao.selectSumNetAmountByXin(params));
		bunko.setQpAmount(bunkoDao.selectSumNetAmountByQp(params));
		bunko.setSbAmount(bunkoDao.selectSumNetAmountBySb(params));
		bunko.setFishAmount(bunkoDao.selectSumNetAmountByFish(params));
		return bunko;
	}

	@Override
	public Class<Bunko> getClazz() {
		return Bunko.class;
	}

	@Override
	public BaseDaoImpl<Bunko> baseDao() {
		return bunkoDao;
	}
}
