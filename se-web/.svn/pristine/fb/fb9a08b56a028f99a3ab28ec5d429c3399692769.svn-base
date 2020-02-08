package com.xjw.entity.po.activity;

import java.math.BigDecimal;
import java.util.Date;

import com.xjw.base.entity.BasePo;
import com.xjw.utility.DateUtil;
import com.xjw.utility.DateUtil.IntevalType;

public class Activity extends BasePo {

	private static final long serialVersionUID = 1L;

	private String name;
	private String title;
	private BigDecimal moneyUp;
	private BigDecimal moneyDown;
	private BigDecimal dividendPercent;
	private BigDecimal dividendUp;
	private Integer count;
	private Integer multiple;
	private Date startTime;
	private Date endTime;
	private String discountCode;
	private Integer memberStart;
	private Integer memberEnd;
	private String pictureUrl;
	private String explains;
	private String remark;
	/** 活动类别 {@link ActivityTypeEnum} */
	private Integer type;
	/** 活动类型 线上活动 或 线下活动 线上活动1 线下活动2 {@link ActivityTypeEnum} */
	private Integer comeFrom;

	public boolean getStartBefore() {
		return startTime.getTime() > new Date().getTime();
	}

	/** 离活动结束还有几天 */
	public long getEndDays() {
		return DateUtil.getInterval(endTime, IntevalType.DAY);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getMoneyUp() {
		return moneyUp;
	}

	public void setMoneyUp(BigDecimal moneyUp) {
		this.moneyUp = moneyUp;
	}

	public BigDecimal getMoneyDown() {
		return moneyDown;
	}

	public void setMoneyDown(BigDecimal moneyDown) {
		this.moneyDown = moneyDown;
	}

	public BigDecimal getDividendPercent() {
		return dividendPercent;
	}

	public void setDividendPercent(BigDecimal dividendPercent) {
		this.dividendPercent = dividendPercent;
	}

	public BigDecimal getDividendUp() {
		return dividendUp;
	}

	public void setDividendUp(BigDecimal dividendUp) {
		this.dividendUp = dividendUp;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getMultiple() {
		return multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public Integer getMemberStart() {
		return memberStart;
	}

	public void setMemberStart(Integer memberStart) {
		this.memberStart = memberStart;
	}

	public Integer getMemberEnd() {
		return memberEnd;
	}

	public void setMemberEnd(Integer memberEnd) {
		this.memberEnd = memberEnd;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getExplains() {
		return explains;
	}

	public void setExplains(String explains) {
		this.explains = explains;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getComeFrom() {
		return comeFrom;
	}

	public void setComeFrom(Integer comeFrom) {
		this.comeFrom = comeFrom;
	}

}