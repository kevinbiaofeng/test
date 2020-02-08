package com.xjw.service.user.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.dao.user.SignDao;
import com.xjw.entity.po.user.Member;
import com.xjw.entity.po.user.Sign;
import com.xjw.service.user.MemberService;
import com.xjw.service.user.SignService;
import com.xjw.service.user.UserAccountIntegralService;
import com.xjw.utility.BizException;
import com.xjw.utility.DateUtil;

@Service
public class SignServiceImpl extends BaseServiceImpl<Sign> implements SignService {
	
	@Autowired
	private SignDao signDao;
	@Autowired
	private MemberService memberService;
	@Autowired
	private UserAccountIntegralService userAccountIntegralService;
	
	public String modifySignToday(Long userId) throws BizException{
		Map<String, Object> condition = new HashMap<String, Object>();
		//查询今天
		condition.put("userId", userId);
		condition.put("today", "1");
		Sign todaySign = this.selectOne(condition);
		if(todaySign != null){ //今天已存在数据返回状态码 306 今天已签到
			return "306";
		}else{
			//查询昨天
			condition.clear();
			condition.put("userId", userId);
			condition.put("yesterday", "1");
			Sign yesdaySign = this.selectOne(condition);
			Integer integral = null;
			if(yesdaySign != null){  //昨天存在签到数据  获取连续签到天数
				Integer yesterCount = yesdaySign.getContinueCount();
				Sign s = new Sign();
				s.setContinueCount(yesterCount+1);
				integral = this.statIntegral(yesterCount);
				s.setIntegral(integral);
				s.setUserId(userId);
				this.save(s);
				
				//每次签到30天 VIP级别 +1
				if(yesterCount%30 == 0){
					Member member = memberService.selectById(userId);
					if(member.getVipType() < 5){
						Map<String, Object> params = new HashMap<String, Object>();
						params.put("userId", userId);
						params.put("vipType", member.getVipType()+1);
						memberService.update(params);
					}
				}
			}else{  //昨天不存在签到记录  签到天数  积分  +1
				integral = 1;
				Sign s = new Sign();
				s.setContinueCount(1);
				s.setIntegral(1);
				s.setUserId(userId);
				this.save(s);
			}
			//修改总积分
			if(integral != null){
				userAccountIntegralService.addIntegral(userId, integral);
			}
			return "999";  //成功 返回状态码 999
		}
	}
	
	/**
	 * 签到积分 制度
	 * @return
    */
	private Integer statIntegral(Integer dayCount){
		if(10 >= dayCount){
			//签到大于10天  积分 +1
			return 1;
		}else if(20 >= dayCount){
			//签到大于20天  积分 +2
			return 2;
		}else {
			//签到大于30天  积分 +3 会员级别 +1
			return 3;
		}
	}
	
	@Override
	public BaseDaoImpl<Sign> baseDao() {
		return signDao;
	}

	@Override
	public Class<Sign> getClazz() {
		return Sign.class;
	}
	
	public static void main(String[] args) {
		System.out.println(new Date().getTime());
		
	}
}
