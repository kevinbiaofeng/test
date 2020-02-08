package com.xjw.entity.po.pay;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.xjw.common.util.Constant;

public class GuofubaoPay implements Serializable {
	private static final long serialVersionUID = 1L;
	private String version;
	private String tranCode;
	private String merchantID;
	private String merOrderNum;
	private String tranAmt;
	private String feeAmt;
	private String tranDateTime;
	private String frontMerUrl;
	private String backgroundMerUrl;
	
	private String orderId;
	private String gopayOutOrderId;
	private String tranIP;
	private String respCode;
	private String gopayServerTime;
	private String VerficationCode;

	public GuofubaoPay (){
		this.setVersion(Constant.GuofubaoParamManage.version);
		this.setTranCode(Constant.GuofubaoParamManage.tranCode);
		this.setMerchantID(Constant.GuofubaoParamManage.merchantID);
		this.setVerficationCode(Constant.GuofubaoParamManage.verficationCode);
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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

	public String getGopayServerTime() {
		return gopayServerTime;
	}

	public void setGopayServerTime(String gopayServerTime) {
		this.gopayServerTime = gopayServerTime;
	}

	public String getVerficationCode() {
		return VerficationCode;
	}

	public void setVerficationCode(String verficationCode) {
		VerficationCode = verficationCode;
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
}
