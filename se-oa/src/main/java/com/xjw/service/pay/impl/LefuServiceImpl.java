package com.xjw.service.pay.impl;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xjw.service.pay.LefuService;
import com.xjw.utility.HttpURLConnectionUtils;
import com.xjw.utility.Security;


@Service
public class LefuServiceImpl implements LefuService {
	private static Logger logger = LoggerFactory.getLogger(LefuServiceImpl.class.getName());
	private static final String merchantCode = "1000000515"; // 商户编号
	private static final String md5Key = "bab5d0e5-f169-46d2-baa4-5338981565b6";
	private static final String url = "https://payment.kklpay.com/query/queryOrder.do";

	public String updatelefuSearchRest(String orderNo) throws Exception {
		final String[] signFields = { "merchantCode", "outOrderId" };
		JSONObject json = new JSONObject();
		json.put("merchantCode", merchantCode);
		json.put("outOrderId", orderNo);
		String sign = Security.countSignMd5(md5Key, signFields, json);
		json.put("sign", sign);
		
		JSONObject pak = new JSONObject();
		pak.put("project_id", "test");
		pak.put("param", json);
		
		String retStr = HttpURLConnectionUtils.sendHttpRequest(url, pak.toString());
		JSONObject retJson = JSONObject.parseObject(retStr);
		if (retJson!=null && "00".equals(retJson.get("code"))) {
			String[] signFields1 = {"merchantCode","outOrderId","amount","replyCode"};
			JSONObject data = retJson.getJSONObject("data");
			boolean bool = Security.verifySignMd5(md5Key, signFields1, data);
			String replyCode = data.getString("replyCode");
			if (bool) {
				// 验签通过-表示查询交易成功
				return replyCode;
			}else {
				return null;
			}
		} else {
			logger.error("查询交易失败code=" + retJson.get("code") + ";msg=" + retJson.get("msg") + ";outOrderId=" + orderNo);
		}
		return null;
	}

	public static void main(String[] args) {
		LefuServiceImpl a = new LefuServiceImpl();
		try {
			a.updatelefuSearchRest("DP20151105000000106");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
