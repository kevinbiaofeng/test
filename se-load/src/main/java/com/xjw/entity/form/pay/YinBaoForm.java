package com.xjw.entity.form.pay;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.util.DigestUtils;

public class YinBaoForm implements Serializable{
	private static final long serialVersionUID = 5547994668972644359L;
	
	private String partner;
	private String ordernumber;
	/** 1:支付成功，非1为支付失败 */
	private String orderstatus;
	private String paymoney;
	private String sysnumber;
	private String attach;
	private String sign;
	
	public String md5(){
		String key = "7814d13abf3270cefa17209bd3fced8b";
		
		StringBuilder sb = new StringBuilder();
		sb.append("partner=" 		+ this.partner);
		sb.append("&ordernumber=" 	+ this.ordernumber);
		sb.append("&orderstatus=" 	+ this.orderstatus);
		sb.append("&paymoney=" 		+ this.paymoney);
		sb.append(key);
		
		try {
			return DigestUtils.md5DigestAsHex(sb.toString().getBytes("GB2312"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getPaymoney() {
		return paymoney;
	}

	public void setPaymoney(String paymoney) {
		this.paymoney = paymoney;
	}

	public String getSysnumber() {
		return sysnumber;
	}

	public void setSysnumber(String sysnumber) {
		this.sysnumber = sysnumber;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}
