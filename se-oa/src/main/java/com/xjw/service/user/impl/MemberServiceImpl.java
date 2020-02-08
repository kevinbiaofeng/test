package com.xjw.service.user.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.xjw.base.dao.impl.BaseDaoImpl;
import com.xjw.base.service.impl.BaseServiceImpl;
import com.xjw.common.util.Constant;
import com.xjw.dao.user.MemberDao;
import com.xjw.entity.Page;
import com.xjw.entity.po.Email;
import com.xjw.entity.po.log.UserOperationLog;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.po.user.Member;
import com.xjw.entity.vo.user.MemberAmountVo;
import com.xjw.kzenum.log.UserOperationLogTypeEnum;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.kzenum.user.MemberVIPTypeEnum;
import com.xjw.service.log.UserOperationLogService;
import com.xjw.service.mail.MailService;
import com.xjw.service.sys.UserService;
import com.xjw.service.user.MemberService;
import com.xjw.util.PwdRandom;
import com.xjw.utility.BizException;
import com.xjw.utility.EncryptUtil;
import com.xjw.utility.StringUtil;

@Service
public class MemberServiceImpl extends BaseServiceImpl<Member> implements MemberService{
	@Resource
	private MemberDao memberDao;
	@Resource
	private UserService userService;
	@Resource
	private MailService mailService;
	@Resource
	private UserOperationLogService userOperationLogService;
	
	private static final String n = "<br/>";
	
	private static final String userNameTxt = "<b>真实姓名：</b>";
	private static final String statusTxt = "<b>会员状态：</b>";
	private static final String emailTxt = "<b>邮箱：</b>";
	private static final String phoneTxt = "<b>联系电话：</b>";
	private static final String vipTypeTxt = "<b>会员类别：</b>";
//	private static final String sexTxt = "<b>性别：</b>";
	private static final String birthdayTxt = "<b>生日：</b>";
	private static final String qqTxt = "<b>QQ：</b>";
	
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	@Resource
//    private SequenceService sequenceService;

	public void saveMember(User user, Member member) throws BizException{
	}

	public void updateMember(User user, Member member) throws BizException{
		StringBuffer oldField = new StringBuffer();
		StringBuffer newField = new StringBuffer();
		
		User oldUser = userService.selectById(user.getId());
		
		//用户状态字段
		Integer status = user.getStatus();
		if(status != null && status != oldUser.getStatus()){
			oldField.append(oldField.length() > 0 ? n : "").append(statusTxt).append(StatusEnum.getEnumByCode(StatusEnum.class, String.valueOf(oldUser.getStatus())).getName());
			newField.append(newField.length() > 0 ? n : "").append(statusTxt).append(StatusEnum.getEnumByCode(StatusEnum.class, String.valueOf(status)).getName());
		}
		oldUser.setStatus(status);
		userService.update(oldUser);
		
		Member oldMember = this.selectById(user.getId());
		
		String userName = member.getUserName();
		String oldUserName = EncryptUtil.decode(Constant.DateEncryptManage.NAME_PWD, oldMember.getName());
		if(StringUtil.isNotBlank(userName) && !userName.equals(oldUserName)){
			oldField.append(oldField.length() > 0 ? n : "").append(userNameTxt).append(oldUserName);
			newField.append(newField.length() > 0 ? n : "").append(userNameTxt).append(userName);
		}
		oldMember.setName(EncryptUtil.encode(Constant.DateEncryptManage.NAME_PWD, userName));
		
		//Email字段
		String email = member.getEmail();
		String oldEmail = EncryptUtil.decode(Constant.DateEncryptManage.EMAIL_PWD, oldMember.getEmail());
		if(StringUtil.isNotBlank(email) && !email.equals(oldEmail)){
			oldField.append(oldField.length() > 0 ? n : "").append(emailTxt).append(oldEmail);
			newField.append(newField.length() > 0 ? n : "").append(emailTxt).append(email);
		}
		
		if(StringUtil.isNotBlank(email))
			oldMember.setEmail(EncryptUtil.encode(Constant.DateEncryptManage.EMAIL_PWD, email));
		
		Date birthday = member.getBirthday();
		if(birthday != null && birthday.compareTo(oldMember.getBirthday()) != 0){
			oldField.append(oldField.length() > 0 ? n : "").append(birthdayTxt).append(format.format(oldMember.getBirthday()));
			newField.append(oldField.length() > 0 ? n : "").append(birthdayTxt).append(format.format(birthday));
		}
		
		oldMember.setBirthday(birthday);
		
		String phone = member.getPhone();
		String oldPhone = EncryptUtil.decode(Constant.DateEncryptManage.PHONE_PWD, oldMember.getPhone());
		if(StringUtil.isNotBlank(phone) && !phone.equals(oldPhone)){
			oldField.append(oldField.length() > 0 ? n : "").append(phoneTxt).append(oldPhone);
			newField.append(newField.length() > 0 ? n : "").append(phoneTxt).append(phone);
		}
		oldMember.setPhone(EncryptUtil.encode(Constant.DateEncryptManage.PHONE_PWD, phone));
		
		
		String qq = member.getQq();
		String oldQQ = EncryptUtil.decode(Constant.DateEncryptManage.QQ_PWD, oldMember.getQq());
		if(StringUtil.isNotBlank(qq) && !qq.equals(oldQQ)){
			oldField.append(oldField.length() > 0 ? n : "").append(qqTxt).append(oldQQ);
			newField.append(newField.length() > 0 ? n : "").append(qqTxt).append(qq);
		}
		oldMember.setQq(EncryptUtil.encode(Constant.DateEncryptManage.QQ_PWD, member.getQq()));
		
//		Integer sex = member.getSex();
//		if(sex != null && sex != oldMember.getSex()){
//			oldField.append(oldField.length() > 0 ? n : "").append(sexTxt).append(SexTypeEnum.getEnumByCode(SexTypeEnum.class, String.valueOf(oldMember.getSex())).getName());
//			newField.append(newField.length() > 0 ? n : "").append(sexTxt).append(SexTypeEnum.getEnumByCode(SexTypeEnum.class, String.valueOf(sex)).getName());
//		}
//		oldMember.setSex(sex);
		
		Integer vipType = member.getVipType();
		if(vipType != null && vipType != oldMember.getVipType()){
			oldField.append(oldField.length() > 0 ? n : "").append(vipTypeTxt).append(MemberVIPTypeEnum.getEnumByCode(MemberVIPTypeEnum.class, String.valueOf(oldMember.getVipType())).getName());
			newField.append(newField.length() > 0 ? n : "").append(vipTypeTxt).append(MemberVIPTypeEnum.getEnumByCode(MemberVIPTypeEnum.class, String.valueOf(vipType)).getName());
		}
		oldMember.setVipType(vipType);
		
//		oldMember.setPhone(EncryptUtil.decode(Constant.DateEncryptManage.PHONE_PWD, oldMember.getPhone()));
//		oldMember.setEmail(EncryptUtil.decode(Constant.DateEncryptManage.EMAIL_PWD, oldMember.getEmail()));
//		oldMember.setQq(EncryptUtil.decode(Constant.DateEncryptManage.QQ_PWD, oldMember.getQq()));
		
		this.update(oldMember);
		
		//添加操作日志
		if(StringUtil.isNotBlank(String.valueOf(newField)) && newField.length() > 0){
			UserOperationLog userOperationLog = new UserOperationLog();
			userOperationLog.setUserId(oldUser.getId());
			userOperationLog.setLoginName(oldUser.getLoginName());
			userOperationLog.setOldData(String.valueOf(oldField));
			userOperationLog.setNewData(String.valueOf(newField));
			userOperationLog.setType(Integer.valueOf(UserOperationLogTypeEnum.USER_INFO_EDIT.getCode()));
			userOperationLogService.save(userOperationLog);
		}
		
	}
	
	public Member findMemberByUserId(String userId){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("userId", userId);
		return this.selectOne(condition);
	}
	
	public Member findMemberByLoginName(String loginName) {
		if(StringUtils.isBlank(loginName)){
			return null;
		}
		
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("loginName", loginName);
		return this.selectOne(condition);
	}
	
	public void updateMemberPwd(String userId) throws Exception{
		Member member = this.findMemberByUserId(userId);
		String pwd = PwdRandom.getRandomString(8);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", userId);
		try {
			params.put("pwd", EncryptUtil.encode(Constant.DateEncryptManage.PWD_PWD, pwd));
		} catch (Exception e) {
			e.printStackTrace();
		}
		userService.update(params);
		Email email = new Email();
		email.setTo(EncryptUtil.decode(Constant.DateEncryptManage.EMAIL_PWD, member.getEmail()));
		email.setSubject("天下国际重置登陆密码通知！");
		StringBuilder content = new StringBuilder();
		content.append("<b>尊敬的会员：</b>")
		  .append("<br/><br/>")
		  .append("&nbsp;&nbsp;&nbsp;&nbsp;您好！<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;您的随机登陆密码是&nbsp;<font color='blue'>").append(pwd).append("</font>，为了保障您的账号资金安全，请登陆后尽快修改登陆密码。感谢您对天下国际一直以来的支持。")
		  .append("<br/><br/>")
		  .append("&nbsp;&nbsp;&nbsp;&nbsp;若您有任何疑问，欢迎您随时咨询24小时在线<a href=\"http://f18op.livechatvalue.com/chat/chatClient/chatbox.jsp?companyID=555588&configID=56527&jid=6920374955\">客服人员</a>，祝您游戏愉快！<br>")
		  .append("<br>")
		  .append("天下国际管理");
		email.setContent(String.valueOf(content));
		mailService.sendMailByAsync(email);
	}
	
	public Page<MemberAmountVo> queryMemberAmountVoPage(Map<String, Object> params, Integer pageNo, Integer pageSize){
		long totalCount = memberDao.getSqlSession().selectOne("MemberAmountVo.selectAllCount", params);
		
		Page<MemberAmountVo> page = new Page<MemberAmountVo>();
		page.setTotalCount(totalCount);
		
		if(pageNo != null){
			page.setPageNo(pageNo);
		}
		if(pageSize != null){
			page.setPageSize(pageSize);
		}
		
		params.put("begin", page.getBegin());
	    params.put("pageSize", page.getPageSize());
	    List<MemberAmountVo> dataList = this.baseDao().getSqlSession().selectList("MemberAmountVo.selectAll", params);
	    page.setDataList(dataList);
		return page;
	}
	
	public int selectCountByAgent(Map<String, Object> params) {
		return memberDao.selectCountByAgent(params);
	}
	
	public Member selectAgentById(Long userId){
		return memberDao.selectAgentById(userId);
	}
	
	@Override
	public Class<Member> getClazz() {
		return Member.class;
	}

	@Override
	public BaseDaoImpl<Member> baseDao() {
		return memberDao;
	}
}
