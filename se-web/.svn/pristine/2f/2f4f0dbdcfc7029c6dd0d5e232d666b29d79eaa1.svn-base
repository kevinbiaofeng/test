package com.xjw.entity.form.pay;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.xjw.kzenum.order.TradeModeEnum;
import com.xjw.util.th.AppConstants;
import com.xjw.util.th.KeyValue;
import com.xjw.util.th.KeyValues;

public class TongHuiWechatForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private String merchant_code;
	private String notify_type;
	private String sign;
	private String order_no;
	private String order_amount;
	private String order_time;
	private String return_params;
	private String trade_no;
	private String trade_time;
	private String trade_status;

	public String getMerchant_code() {
		return merchant_code;
	}

	public void setMerchant_code(String merchant_code) {
		this.merchant_code = merchant_code;
	}

	public String getNotify_type() {
		return notify_type;
	}

	public void setNotify_type(String notify_type) {
		this.notify_type = notify_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(String order_amount) {
		this.order_amount = order_amount;
	}

	public String getOrder_time() {
		return order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	public String getReturn_params() {
		return return_params;
	}

	public void setReturn_params(String return_params) {
		this.return_params = return_params;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getTrade_time() {
		return trade_time;
	}

	public void setTrade_time(String trade_time) {
		this.trade_time = trade_time;
	}

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
	
	
	/** 参数加密 */
	public String toSign(){
		KeyValues kvs = new KeyValues();
        kvs.add(new KeyValue(AppConstants.MERCHANT_CODE, merchant_code));
        kvs.add(new KeyValue(AppConstants.NOTIFY_TYPE, notify_type));
        kvs.add(new KeyValue(AppConstants.ORDER_NO, order_no));
        kvs.add(new KeyValue(AppConstants.ORDER_AMOUNT, order_amount));
        kvs.add(new KeyValue(AppConstants.ORDER_TIME, order_time));
        kvs.add(new KeyValue(AppConstants.RETURN_PARAMS, return_params));
        kvs.add(new KeyValue(AppConstants.TRADE_NO, trade_no));
        kvs.add(new KeyValue(AppConstants.TRADE_TIME, trade_time));
        kvs.add(new KeyValue(AppConstants.TRADE_STATUS, trade_status));
        String oldSign = return_params.equals(TradeModeEnum.TH_WECHAT.getCode()) ? "02f775802e374fb89defe5bb83e7db79" : "38e3466b176b464bb22b8cf525418583";
        String thizSign = kvs.sign(oldSign, "UTF-8");
    	return thizSign;
	}
	/**
	 * 通汇微信返回支付信息：[{serialVersionUID:1}{merchant_code:13665428}{notify_type:back_notify}{sign:79d04115ebd53389913c698f7ae468d4}{order_no:DP201702167675960}
	 * {order_amount:1.0}{order_time:2017-02-16 03:37:56}{return_params:}{trade_no:3063654435556477}{trade_time:2017-02-16 03:39:17}{trade_status:success}]
2017-02-16 03:38:21,320 INFO c.x.s.o.i.DepositOrderServiceImpl [http-15001-2] 
		通汇微信返回支付信息异常：签名不正确[39d7d40a24b2d4f465eab6ddf8cbe0e4][79d04115ebd53389913c698f7ae468d4]
		
		
		//老的sign：79a8459fecfd11e695b544a842133fcb   新的：38e3466b176b464bb22b8cf525418583
		
		通汇微信返回支付信息：[{serialVersionUID:1}{merchant_code:13665428}{notify_type:back_notify}{sign:8cfffef2e7e5ccaa2c31122473340a69}
		{order_no:DP20170216491132609}{order_amount:1.0}{order_time:2017-02-16 04:02:29}{return_params:}
		{trade_no:3063654437028796}{trade_time:2017-02-16 04:03:49}{trade_status:success}]
2017-02-16 04:02:44,164 INFO c.x.s.o.i.DepositOrderServiceImpl [http-15001-2] 通汇微信返回支付信息异常：签名不正确[6179a26ec55105fb6b270fa20581bade][8cfffef2e7e5ccaa2c31122473340a69]

	 */
	public static void main(String[] args) {
		TongHuiWechatForm form = new TongHuiWechatForm();
		form.setMerchant_code("13665428");
		form.setNotify_type("back_notify");
		form.setSign("8cfffef2e7e5ccaa2c31122473340a69");
		form.setOrder_no("DP20170216491132609");
		form.setOrder_amount("1.0");
		form.setOrder_time("2017-02-16 04:02:29");
		form.setReturn_params("");
		form.setTrade_no("3063654436468637");
		form.setTrade_time("2017-02-16 04:03:49");
		form.setTrade_status("success");
		System.out.println(form.getSign() + "==" + form.toSign()); //c2826ca89bdd08ca37b2a9eb41df1ba3
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
