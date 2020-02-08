package com.xjw.entity.form.pay;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.xjw.common.util.Constant;
import com.xjw.util.GopayUtils;

/**
 * 国付宝返回参数
 */
public class GuoFuBaoRespForm implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 网关版本号 */
	private String version;	
	/** 字符集 */
	private String charset;
	/** 网关语言版本 */
	private String language;
	/** 报文加密方式 */
	private String signType;
	/** 交易代码 */
	private String tranCode;
	/** 商户代码 */
	private String merchantID;
	/** 订单号 */
	private String merOrderNum;
	/** 交易金额 */
	private String tranAmt;
	/** 商户提取佣金金额 */
	private String feeAmt;
	/** 商户前台通知地址 */
	private String frontMerUrl;
	/** 商户后台通知地址 */
	private String backgroundMerUrl;
	/** 订单发起交易时间 */
	private String tranDateTime;
	/** 用户浏览器IP */
	private String tranIP;
	/** 响应码 */
	private String respCode;
	/** 响应结果附加信息 */
	private String msgExt;
	/** 国付宝内部订单号 */
	private String orderId;
	/** 网关发往银行的流水号 */
	private String gopayOutOrderId;
	/** 银行简称 */
	private String bankCode;
	/** 交易完成时 */
	private String tranFinishTime;
	/** 商品名称 */
	private String goodsName;
	/** 商品详情 */
	private String goodsDetail;
	/** 买方名称 */
	private String buyerName;
	/** 买方联系方式 */
	private String buyerContact;
	/** 商户备用信息字段 */
	private String merRemark1;
	/** 商户备用信息字段 */
	private String merRemark2;
	/** 密文串 */
	private String signValue;
	
	/** 参数加密 */
	public String toSign(){
		StringBuilder sb = new StringBuilder();
    	sb.append("version=[").append(version).append("]")
    	.append("tranCode=[").append(tranCode).append("]")
    	.append("merchantID=[").append(merchantID).append("]")
    	.append("merOrderNum=[").append(merOrderNum).append("]")
    	.append("tranAmt=[").append(tranAmt).append("]")
    	.append("feeAmt=[").append(feeAmt).append("]")
    	.append("tranDateTime=[").append(tranDateTime).append("]")
    	.append("frontMerUrl=[]")
    	.append("backgroundMerUrl=[").append(backgroundMerUrl).append("]")
    	.append("orderId=[").append(orderId).append("]")
    	.append("gopayOutOrderId=[").append(gopayOutOrderId).append("]")
    	.append("tranIP=[").append(tranIP).append("]")
    	.append("respCode=[").append(respCode).append("]")
    	.append("gopayServerTime=[]")
    	.append("VerficationCode=[").append(Constant.GuofubaoParamManage.verficationCode).append("]");
    	return GopayUtils.md5(String.valueOf(sb));
	}

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
	
	public static void main(String[] args) {
		GuoFuBaoRespForm form = new GuoFuBaoRespForm();
		form.setVersion("2.1");
		form.setTranCode("8888");
		form.setMerchantID("0000003358");
		form.setMerOrderNum("xxx789xx");
		form.setTranAmt("10.00");
		form.setFeeAmt("5");
		form.setTranDateTime("20121025154955");
		form.setBackgroundMerUrl("http://www.baidu.com");
		form.setOrderId("20121025154988");
		form.setGopayOutOrderId("20121025154988");
		form.setTranIP("127.0.0.1");
		form.setRespCode("0000");
		form.setVersion("12345678");
		
		System.out.println(form.toSign());
	}
}
