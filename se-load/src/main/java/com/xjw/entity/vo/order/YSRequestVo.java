package com.xjw.entity.vo.order;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class YSRequestVo {
	private final static String MERCHANT_ID = "2000009005";
	private final static String SIGN_KEY = "af65db63b3e548419284a60704100437";
	
	private String merchantId;
	private Integer payType;
	private String goodsName;
	private String billNo;
	private String amount;
	private String orderDate;
	private String notifyUrl;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	public static YSRequestVo init(){
		YSRequestVo vo = new YSRequestVo();
		vo.setMerchantId(MERCHANT_ID);
		vo.setGoodsName("商品");
		return vo;
	}
	
	public String getSign(){
		return DigestUtils.md5Hex(this.billNo + this.amount + this.orderDate + SIGN_KEY).toLowerCase();
	}
	
	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
}
