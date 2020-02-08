package com.xjw.entity.vo.order;

import java.io.Serializable;
import java.math.BigDecimal;

public class WithdrawalOrderVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String token;
	private Integer bankType;
	private String province;
	private String city;
	private String address;
	private Long userId;
	private String cardNo;
	private BigDecimal amount;
	private String ipAddress;
	private String isDefaultBankCardInfo; // 银行卡是否默认

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getBankType() {
		return bankType;
	}

	public void setBankType(Integer bankType) {
		this.bankType = bankType;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getIsDefaultBankCardInfo() {
		return isDefaultBankCardInfo;
	}

	public void setIsDefaultBankCardInfo(String isDefaultBankCardInfo) {
		this.isDefaultBankCardInfo = isDefaultBankCardInfo;
	}

//	private Long userId;
//	private String cardNo;
//	private BigDecimal amount;
//	private String isDefaultBankCardInfo; // 银行卡是否默认
	public static void main(String[] args) {
//		WithdrawalOrderVo withdrawalOrderVo= new WithdrawalOrderVo();
//		withdrawalOrderVo.setToken("WC441lDR2e34l" + withdrawalOrderVo.getUserId() + "WC441lDR2e34l");
//		withdrawalOrderVo.setBankType(2);
//		withdrawalOrderVo.setProvince("湖南省");
//		withdrawalOrderVo.setCity("岳阳市");
//		withdrawalOrderVo.setAddress("岳阳楼区9999街道");
//		withdrawalOrderVo.setUserId(233L);
//		withdrawalOrderVo.setCardNo("99999999999999999");
//		withdrawalOrderVo.setAmount(new BigDecimal(99999));
//		withdrawalOrderVo.setIsDefaultBankCardInfo("1");
//		
//		System.out.println(JsonObjectConvertUtil.beanToJson(withdrawalOrderVo));
	}
}
