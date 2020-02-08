package com.xjw.service.user;

import com.xjw.base.service.BaseServcie;
import com.xjw.entity.po.user.Member;
import com.xjw.entity.po.user.User;
import com.xjw.entity.vo.user.UserVo;
import com.xjw.utility.BizException;

public interface MemberService extends BaseServcie<Member> {
	/**
	 * 创建新用户
	 * @param userVo
	 * @param ip
	 * @throws BizException
	 */
	public User createMember(UserVo userVo, String ip) throws BizException;
	
	/**
	 * 解密用户信息
	 * @param userVo
	 * @param ip
	 * @throws BizException
	 */
	public Member decodeMember(Member member);
	
	/**
	 * 通过用户id获取用户详细信息
	 * @param userVo
	 * @param ip
	 * @throws BizException
	 */
	public Member getMemberByUserId(Long userId);
	
	/**
	 * 重置密码
	 * @param userId
	 * @throws BizException
	 */
	public void updateMemberPwd(Long userId) throws BizException;
}
