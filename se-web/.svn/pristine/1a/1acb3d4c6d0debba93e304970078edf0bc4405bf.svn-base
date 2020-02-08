package com.xjw.entity.po.pay;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.xjw.common.util.Constant;
import com.xjw.kzenum.pay.LeYingPayTypeEnum;
import com.xjw.utility.MD5Util;

@SuppressWarnings("all")
public class LeYingPay implements Serializable {
	private String version; // 版本
	private String serialID; // 请求序列号
	private String submitTime; // 订单提交时间 20101117020101
	private String failureTime; // 订单失效时间
	private String customerIP; // 客户下单域名及IP 可空
	private String orderDetails; // 订单明细信息
	private String totalAmount; // 订单总金额
	private String type; // 交易类型
	private String buyerMarked; // 付款方乐盈账户号
	private String payType; // 付款方支付方式
	private String orgCode; // 目标资金机构代码
	private String currencyCode; // 交易币种
	private String directFlag; // 是否直连
	private String borrowingMarked; // 资金来源借贷标识
	private String couponFlag; // 优惠券标识
	private String platformID; // 平台商ID
	private String returnUrl; // 商户回调地址
	private String noticeUrl; // 商户通知地址
	private String partnerID; // 商户ID
	private String remark; // 扩展字段
	private String charset; // 编码方式
	private String signType; // 签名类型
	private String signMsg; // 签名字符串
	
	public LeYingPay() {
		this.setVersion(Constant.LeYingParamManage.version);
		this.setType(Constant.LeYingParamManage.type);
		this.setCurrencyCode(Constant.LeYingParamManage.currencyCode);
		this.setCharset(Constant.LeYingParamManage.charset);
		this.setSignType(Constant.LeYingParamManage.signType);
		this.setPartnerID(Constant.LeYingParamManage.partnerID);
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSerialID() {
		return serialID;
	}

	public void setSerialID(String serialID) {
		this.serialID = serialID;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public String getFailureTime() {
		return failureTime;
	}

	public void setFailureTime(String failureTime) {
		this.failureTime = failureTime;
	}

	public String getCustomerIP() {
		return customerIP;
	}

	public void setCustomerIP(String customerIP) {
		this.customerIP = customerIP;
	}

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBuyerMarked() {
		return buyerMarked;
	}

	public void setBuyerMarked(String buyerMarked) {
		this.buyerMarked = buyerMarked;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getDirectFlag() {
		return directFlag;
	}

	public void setDirectFlag(String directFlag) {
		this.directFlag = directFlag;
	}

	public String getBorrowingMarked() {
		return borrowingMarked;
	}

	public void setBorrowingMarked(String borrowingMarked) {
		this.borrowingMarked = borrowingMarked;
	}

	public String getCouponFlag() {
		return couponFlag;
	}

	public void setCouponFlag(String couponFlag) {
		this.couponFlag = couponFlag;
	}

	public String getPlatformID() {
		return platformID;
	}

	public void setPlatformID(String platformID) {
		this.platformID = platformID;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getNoticeUrl() {
		return noticeUrl;
	}

	public void setNoticeUrl(String noticeUrl) {
		this.noticeUrl = noticeUrl;
	}

	public String getPartnerID() {
		return partnerID;
	}

	public void setPartnerID(String partnerID) {
		this.partnerID = partnerID;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getSignMsg() {
		return signMsg;
	}

	public void setSignMsg(String signMsg) {
		this.signMsg = signMsg;
	}
	
	@SuppressWarnings("rawtypes")
	public String toString() {
		StringBuffer sb = new StringBuffer();
		try {
			Class t = this.getClass();
			Field[] fields = t.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				field.setAccessible(true);
				sb.append("{");
				sb.append(field.getName());
				sb.append(":");
				if (field.getType() == Integer.class) {
					sb.append(field.getInt(this));
				} else if (field.getType() == Long.class) {
					sb.append(field.getLong(this));
				} else if (field.getType() == Boolean.class) {
					sb.append(field.getBoolean(this));
				} else if (field.getType() == char.class) {
					sb.append(field.getChar(this));
				} else if (field.getType() == Double.class) {
					sb.append(field.getDouble(this));
				} else if (field.getType() == Float.class) {
					sb.append(field.getFloat(this));
				} else
					sb.append(field.get(this));
				sb.append("}");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	@SuppressWarnings("rawtypes")
	public String toJSON() {
		StringBuffer sb = new StringBuffer();
		try {
			Class t = this.getClass();
			Field[] fields = t.getDeclaredFields();
			sb.append("{");
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				field.setAccessible(true);
				sb.append(i == 0 ? "" : ",");
				sb.append("\"");
				sb.append(field.getName());
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				if (field.getType() == Integer.class) {
					sb.append(field.getInt(this));
				} else if (field.getType() == Long.class) {
					sb.append(field.getLong(this));
				} else if (field.getType() == Boolean.class) {
					sb.append(field.getBoolean(this));
				} else if (field.getType() == char.class) {
					sb.append(field.getChar(this));
				} else if (field.getType() == Double.class) {
					sb.append(field.getDouble(this));
				} else if (field.getType() == Float.class) {
					sb.append(field.getFloat(this));
				} else
					sb.append(field.get(this));
				sb.append("\"");
			}
			sb.append("}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public String getNewSignMsg() {
		StringBuffer sb = new StringBuffer();
		try {
			Class t = this.getClass();
			Field[] fields = t.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				field.setAccessible(true);
				if(field.getName().equals("signMsg"))break;
				sb.append(i==0 ? "" : "&");
				sb.append(field.getName());
				sb.append("=");
				if (field.getType() == Integer.class) {
					sb.append(field.getInt(this));
				} else if (field.getType() == Long.class) {
					sb.append(field.getLong(this));
				} else if (field.getType() == Boolean.class) {
					sb.append(field.getBoolean(this));
				} else if (field.getType() == char.class) {
					sb.append(field.getChar(this));
				} else if (field.getType() == Double.class) {
					sb.append(field.getDouble(this));
				} else if (field.getType() == Float.class) {
					sb.append(field.getFloat(this));
				} else
					sb.append(field.get(this));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
