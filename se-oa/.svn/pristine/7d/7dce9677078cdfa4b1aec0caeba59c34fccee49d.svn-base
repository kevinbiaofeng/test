package com.xjw.service.user;

import java.util.Map;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.Page;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.user.Member;
import com.xjw.entity.vo.user.MemberAmountVo;
import com.xjw.utility.BizException;

public interface MemberService extends BaseServcie<Member> {
	public void saveMember(User user, Member member) throws BizException;
	/**
	 * 后台修改会员资料功能，并且带有修改记录日志
	 * @param user
	 * @param member
	 * @throws BizException
	 */
	public void updateMember(User user, Member member) throws BizException;
	
	public Member findMemberByUserId(String userId);
	
	public Member findMemberByLoginName(String loginName);
	
	/**
	 * 找回密码功能
	 * @param userId
	 * @param pwd
	 * @throws BizException
	 */
	public void updateMemberPwd(String userId) throws Exception;
	
	/**
	 *  查询会员近期金额
	 */
	public Page<MemberAmountVo> queryMemberAmountVoPage(Map<String, Object> params, Integer pageNo, Integer pageSize);
	
	/** 查询代理的下线用户数量  */
	public int selectCountByAgent(Map<String, Object> params);
	
	/** 查询代理 */
	public Member selectAgentById(Long userId);
	
}
