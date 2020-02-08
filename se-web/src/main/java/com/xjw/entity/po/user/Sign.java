package com.xjw.entity.po.user;

import com.xjw.base.entity.BasePo;
import com.xjw.utility.DateUtil;

/**
 * 会员签到
 */
public class Sign extends BasePo {
	private static final long serialVersionUID = -1409956443200408748L;

	/** 用户ID */
	private Long userId;
	/** 连续签到天数 */
	private Integer continueCount;
	/** 添加积分 */
	private Integer integral;

	/** 查询后设置当前字段 */
	private Integer year;
	private Integer month;
	private Integer day;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getContinueCount() {
		return continueCount;
	}

	public void setContinueCount(Integer continueCount) {
		this.continueCount = continueCount;
	}

	public Integer getYear() {
		return DateUtil.getFormatTime(this.getCreateTime(), "yyyy");
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return DateUtil.getFormatTime(this.getCreateTime(), "MM");
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getDay() {
		return DateUtil.getFormatTime(this.getCreateTime(), "dd");
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
}
