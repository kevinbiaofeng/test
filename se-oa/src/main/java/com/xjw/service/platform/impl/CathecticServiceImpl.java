package com.xjw.service.platform.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.platform.CathecticDao;
import com.xjw.entity.po.cathectic.NewMgGame;
import com.xjw.entity.po.cathectic.NewPtGame;
import com.xjw.entity.po.platform.Cathectic;
import com.xjw.entity.po.platform.UserRebate;
import com.xjw.entity.po.sys.User;
import com.xjw.service.platform.CathecticService;
import com.xjw.service.sys.UserService;

@Service
public class CathecticServiceImpl extends BaseServiceImpl<Cathectic> implements CathecticService {
	@Resource
	private CathecticDao cathecticDao;
	@Resource
	private UserService userService;
	
	/**
	 * 今日投注总额
	 */
//	public BigDecimal selectSumBetAmount(Map<String, Object> params) {
//		BigDecimal aggjBetAmount = cathecticDao.selectSumBetAmountByAggj(params);
//		BigDecimal agjsBetAmount = cathecticDao.selectSumBetAmountByAgjs(params);
//		BigDecimal ptBetAmount = cathecticDao.selectSumBetAmountByPt(params);
//		BigDecimal mgBetAmount = cathecticDao.selectSumBetAmountByMg(params);
//		BigDecimal xinBetAmount = cathecticDao.selectSumBetAmountByXin(params);
//		BigDecimal fishBetAmount = cathecticDao.selectSumBetAmountByFish(params);
//		BigDecimal sbBetAmount = cathecticDao.selectSumBetAmountBySb(params);
//		BigDecimal qpBetAmount = cathecticDao.selectSumBetAmountByQp(params);
//		BigDecimal ttgBetAmount = cathecticDao.selectSumBetAmountByTtg(params);
//		BigDecimal endoBetAmount = cathecticDao.selectSumBetAmountByEndo(params);
//
//		BigDecimal sumBetAmount = aggjBetAmount.add(agjsBetAmount).add(ptBetAmount).add(mgBetAmount).add(xinBetAmount)
//				.add(fishBetAmount).add(sbBetAmount).add(qpBetAmount).add(ttgBetAmount).add(endoBetAmount);
//
//		return sumBetAmount;
//	}
	
	@Override
	public Class<Cathectic> getClazz() {
		return Cathectic.class;
	}

	@Override
	public BaseDaoImpl<Cathectic> baseDao() {
		return cathecticDao;
	}
	
	/**
	 * 会员返水查询
	 */
	public List<UserRebate> selectSumAmount(Map<String, Object> params) {
		List<Long> listUser = new ArrayList<Long>();//userId
		Map<String, UserRebate> mapcath = new HashMap<String,UserRebate>();
		

		List<NewPtGame> newPtAmount = cathecticDao.selectSumAmountByNewPt(params);
		for (NewPtGame newPtGame : newPtAmount) {
			UserRebate cath = null;
			if( mapcath.containsKey(newPtGame.getUserId().toString()) ){
				cath = mapcath.get(newPtGame.getUserId().toString());
			}else{
				listUser.add(newPtGame.getUserId());
				cath = new UserRebate();
				cath.setId(newPtGame.getUserId());
				cath.setUserId(newPtGame.getUserId());
				cath.setPlayerName(newPtGame.getPlayerName());
			}
			cath.setNewPtBetAmount(newPtGame.getNewPtBetAmount());
			cath.setNewPtNetAmount(newPtGame.getNewPtNetAmount());
			mapcath.put(newPtGame.getUserId().toString(), cath);
		}
		
		List<NewMgGame> newMgAmount = cathecticDao.selectSumAmountByNewMg(params);
		for (NewMgGame newMgGame : newMgAmount) {
			UserRebate cath = null;
			if( mapcath.containsKey(newMgGame.getUserId().toString()) ){
				cath = mapcath.get(newMgGame.getUserId().toString());
			}else{
				listUser.add(newMgGame.getUserId());
				cath = new UserRebate();
				cath.setId(newMgGame.getUserId());
				cath.setUserId(newMgGame.getUserId());
				cath.setPlayerName(newMgGame.getPlayerName());
			}
			cath.setNewMgBetAmount(newMgGame.getNewMgBetAmount());
			cath.setNewMgNetAmount(newMgGame.getNewMgNetAmount());
			mapcath.put(newMgGame.getUserId().toString(), cath);
		}
		
		List<UserRebate> listCathectic = new ArrayList<UserRebate>();
		if(null != listUser && listUser.size() > 0){
			Map<String, Object> userparams = new HashMap<String,Object>();
			userparams.put("ids", listUser);
			List<User> userLists = userService.getUserListByUserId(userparams);
			Map<Long , String> userList = new HashMap<Long , String>();
			for (User user : userLists) {
				userList.put(user.getId(), user.getLoginName());
			}
			for (Long cathectic : listUser) {
				UserRebate cath = mapcath.get(cathectic.toString());
				cath.setLoginName(userList.get(cathectic));
				listCathectic.add(cath);
			}
		}
		
		return listCathectic;
	}

}
