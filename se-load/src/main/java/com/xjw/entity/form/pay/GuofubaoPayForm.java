package com.xjw.entity.form.pay;

import java.io.Serializable;

public class GuofubaoPayForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private String version;
	private String charset;
	private String language;
	private String signType;
	private String tranCode;
	private String merchantID;
	private String merOrderNum;
	private String tranAmt;
	private String feeAmt;
	private String tranDateTime;
	private String frontMerUrl;
	private String backgroundMerUrl;
	private String tranIP;
	private String respCode;
	private String msgExt;
	private String orderId;
	private String gopayOutOrderId;
	private String bankCode;
	private String tranFinishTime;
	private String goodsName;
	private String goodsDetail;
	private String buyerName;
	private String buyerContact;
	private String merRemark1;
	private String merRemark2;
	private String signValue;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getTranCode() {
		return tranCode;
	}

	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}

	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public String getMerOrderNum() {
		return merOrderNum;
	}

	public void setMerOrderNum(String merOrderNum) {
		this.merOrderNum = merOrderNum;
	}

	public String getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(String tranAmt) {
		this.tranAmt = tranAmt;
	}

	public String getFeeAmt() {
		return feeAmt;
	}

	public void setFeeAmt(String feeAmt) {
		this.feeAmt = feeAmt;
	}

	public String getTranDateTime() {
		return tranDateTime;
	}

	public void setTranDateTime(String tranDateTime) {
		this.tranDateTime = tranDateTime;
	}

	public String getFrontMerUrl() {
		return frontMerUrl;
	}

	public void setFrontMerUrl(String frontMerUrl) {
		this.frontMerUrl = frontMerUrl;
	}

	public String getBackgroundMerUrl() {
		return backgroundMerUrl;
	}

	public void setBackgroundMerUrl(String backgroundMerUrl) {
		this.backgroundMerUrl = backgroundMerUrl;
	}

	public String getTranIP() {
		return tranIP;
	}

	public void setTranIP(String tranIP) {
		this.tranIP = tranIP;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getMsgExt() {
		return msgExt;
	}

	public void setMsgExt(String msgExt) {
		this.msgExt = msgExt;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getGopayOutOrderId() {
		return gopayOutOrderId;
	}

	public void setGopayOutOrderId(String gopayOutOrderId) {
		this.gopayOutOrderId = gopayOutOrderId;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getTranFinishTime() {
		return tranFinishTime;
	}

	public void setTranFinishTime(String tranFinishTime) {
		this.tranFinishTime = tranFinishTime;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsDetail() {
		return goodsDetail;
	}

	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerContact() {
		return buyerContact;
	}

	public void setBuyerContact(String buyerContact) {
		this.buyerContact = buyerContact;
	}

	public String getMerRemark1() {
		return merRemark1;
	}

	public void setMerRemark1(String merRemark1) {
		this.merRemark1 = merRemark1;
	}

	public String getMerRemark2() {
		return merRemark2;
	}

	public void setMerRemark2(String merRemark2) {
		this.merRemark2 = merRemark2;
	}

	public String getSignValue() {
		return signValue;
	}

	public void setSignValue(String signValue) {
		this.signValue = signValue;
	}
}
