package com.xjw.entity.po.pay;

import java.io.UnsupportedEncodingException;

import org.springframework.util.DigestUtils;

/**
 * 银宝支付
 */
public class YinBaoPay {
	
	private String partner;
	private String banktype;
	private String paymoney;
	private String ordernumber;
	private String callbackurl;
	private String hrefbackurl;
	private String attach;
	
	public String md5(String key, String charset){
		StringBuilder sb = new StringBuilder();
		sb.append("partner=" 		+ this.partner);
		sb.append("&banktype=" 		+ this.banktype);
		sb.append("&paymoney=" 		+ this.paymoney);
		sb.append("&ordernumber=" 	+ this.ordernumber);
		sb.append("&callbackurl=" 	+ this.callbackurl);
		sb.append(key);
		
		try {
			return DigestUtils.md5DigestAsHex(sb.toString().getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getBanktype() {
		return banktype;
	}

	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}

	public String getPaymoney() {
		return paymoney;
	}

	public void setPaymoney(String paymoney) {
		this.paymoney = paymoney;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getCallbackurl() {
		return callbackurl;
	}

	public void setCallbackurl(String callbackurl) {
		this.callbackurl = callbackurl;
	}

	public String getHrefbackurl() {
		return hrefbackurl;
	}

	public void setHrefbackurl(String hrefbackurl) {
		this.hrefbackurl = hrefbackurl;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		YinBaoPay pay = new YinBaoPay();
		pay.setPartner("10000");
		pay.setBanktype("ICBC");
		pay.setPaymoney("100.00");
		pay.setOrdernumber("1234567890");
		pay.setCallbackurl("http://www.mydomain.com/backAction");
		pay.setHrefbackurl("http://www.mydomain.com/notifyAction");
		pay.setAttach("jrapi");
		
		System.out.println(pay.md5("4272fafab8869dbd292d959b7542530c", "GB2312"));
	}
}
