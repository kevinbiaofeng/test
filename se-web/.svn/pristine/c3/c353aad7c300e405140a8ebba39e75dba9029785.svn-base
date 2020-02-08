package com.xjw.controller.order;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xjw.common.util.Constant;
import com.xjw.controller.BaseController;
import com.xjw.entity.form.order.DepositOrderForm;
import com.xjw.entity.po.order.DepositOrder;
import com.xjw.entity.po.pay.GuofubaoPay;
import com.xjw.entity.po.pay.LeYingPay;
import com.xjw.entity.po.sys.PayConfig;
import com.xjw.entity.po.user.User;
import com.xjw.entity.vo.order.YSRequestVo;
import com.xjw.kzenum.order.TradeModeEnum;
import com.xjw.kzenum.pay.LeYingPayTypeEnum;
import com.xjw.kzenum.sys.YesORNoEnum;
import com.xjw.service.order.DepositOrderService;
import com.xjw.service.sys.PayConfigService;
import com.xjw.util.GopayUtils;
import com.xjw.util.SessionManager;
import com.xjw.util.th.AppConstants;
import com.xjw.util.th.KeyValue;
import com.xjw.util.th.KeyValues;
import com.xjw.utility.ContextPropsLoad;
import com.xjw.utility.DESEncrypt;
import com.xjw.utility.DateUtil;
import com.xjw.utility.HttpClientUtils;
import com.xjw.utility.IpUtil;
import com.xjw.utility.MD5Util;

@Controller
@RequestMapping("/deposit/")
public class DepositController extends BaseController{
	  private static Logger logger = LoggerFactory.getLogger(DepositController.class.getName());
	  @Resource
	  private DepositOrderService depositOrderService;
	  
	  @Autowired
	  private PayConfigService payConfigService;
	  
	  @RequestMapping("/index")
	  public String index(Model model){
		  model.addAttribute("ORDER_TAB", "充值");
		  return "/xjw/order/order-index";
	  }
	  
	  @RequestMapping("/load")
	  public String load(Model model, HttpServletRequest request){
		  //查询支付配置
		  Map<String, Object> params = new HashMap<String, Object>();
		  params.put("status", YesORNoEnum.YES.getCode());
		  List<PayConfig> payConfigList = payConfigService.selectAll(params);
		  
		  Map<String, PayConfig> payConfigMap = new HashMap<String, PayConfig>();
		  for(PayConfig payConfig : payConfigList){
			  payConfigMap.put(payConfig.getTradeMode().toString(), payConfig);
		  }
		  
		  model.addAttribute("payConfigMap", payConfigMap);
		  setToken(request);
		  return "/xjw/order/deposit";
	  }
	  
	  /** 
       * 跳转到充值页面
       */
      @RequestMapping(value = "/redirect")
      public synchronized String redirect(DepositOrderForm form, Model model, HttpServletRequest request){
          boolean isToken = isTokenTrue(request, request.getParameter("tk"));
          if(!isToken){
        	  model.addAttribute("errorCode", "您不能重复提交充值订单");
          }else{
        	  model.addAttribute("form", form);
	          User user = SessionManager.getUserSession(request);
	          
	          try {
	        	  DepositOrder order = depositOrderService.createOrder(user.getId(), form);
	        	  
	        	  if(TradeModeEnum.YS_ONLINE.getCode().equals(form.getTradeMode().toString())){
	                  YSRequestVo vo = YSRequestVo.init();
	                  vo.setPayType(1);
	                  vo.setBillNo(order.getOrderNo());
	                  vo.setOrderDate(DateFormatUtils.format(order.getCreateTime(), "yyyyMMddHHmmss"));
	                  vo.setAmount(order.getTradeAmount().toString());
	                  vo.setNotifyUrl(this.getBasePath() +"/pay/ys/callback");
	                  model.addAttribute("vo", vo);
	        	  }
	          } catch (Exception e) {
	              logger.error(e.getMessage(), e);
	              model.addAttribute("errorCode", "连接支付系统失败，请与客服联系");
	          }
          }
          
          return "xjw/order/deposit-redirect";
      }
      
	  
	  @RequestMapping(value = "/createOrder")
	  @ResponseBody
	  public synchronized String createOrder(DepositOrderForm depositOrderForm, HttpServletRequest request, HttpServletResponse response){
		  JSONObject json = new JSONObject();
		  boolean isToken = isTokenTrue(request, request.getParameter("tk"));
		  if(!isToken){
			//重复提交
			return null;
		  }
		  try {
			  depositOrderForm.setIp(IpUtil.getIpAddr(request));
			  User user = SessionManager.getUserSession(request);
			  if(depositOrderForm.getTradeMode() == 1){ //银行转账
				  depositOrderService.createTransferBankOrder(depositOrderForm, user.getId(), TradeModeEnum.ONLINE_BANKING_PAYMENT.getCode());
			  }
			  
			  json.put("code", "1");
		  } catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", "0");
		  }
		  return json.toString();
	  }
	  
	  /**
	   * 第三方支付接口
	   * @param depositOrderForm
	   * @param request
	   * @return
	   */
	  @RequestMapping(value = "/thirdPartyOrder")
	  @ResponseBody
	  public synchronized String thirdPartyOrder(DepositOrderForm depositOrderForm, HttpServletRequest request){
		  JSONObject json = new JSONObject();
		  
		  boolean isToken = isTokenTrue(request, request.getParameter("tk"));
		  if(!isToken){
			  json.put("code", "0");
			  json.put("msg", "您的点击过于频繁");
		  }
		  
		  try {
			  String ip = IpUtil.getIpAddr(request);
			  Long createTime = System.currentTimeMillis();
			  depositOrderForm.setIp(ip);
			  depositOrderForm.setCreateTime(createTime);
			  
			  DepositOrder depositOrder = null;
			  User user = SessionManager.getUserSession(request);
			  if(depositOrderForm.getTradeMode() == Integer.valueOf(TradeModeEnum.ONLINE_GUOFUBAO.getCode())){
				  //国付宝支付
				  depositOrder = depositOrderService.createTransferBankOrder(depositOrderForm, user.getId(), TradeModeEnum.ONLINE_GUOFUBAO.getCode());
				  if(depositOrder != null){
					  json = this.setGFBParams(json, depositOrder, ip, user);
				  }else{
					  json.put("code", "0");
				  }
			  }else if(depositOrderForm.getTradeMode() == Integer.valueOf(TradeModeEnum.TH_WECHAT.getCode())){
				  //通汇微信支付
				  depositOrder = depositOrderService.createTransferBankOrder(depositOrderForm, user.getId(), TradeModeEnum.TH_WECHAT.getCode());
				  if(depositOrder != null){
					  json = this.setTHWechatParams(json, depositOrder, ip, user, "14040423", "02f775802e374fb89defe5bb83e7db79");
				  }else{
					  json.put("code", "0");
				  }
			  }else if(depositOrderForm.getTradeMode() == Integer.valueOf(TradeModeEnum.YB_ALIPAY.getCode())){	
				  //银宝-支付宝
				  depositOrder = depositOrderService.createTransferBankOrder(depositOrderForm, user.getId(), TradeModeEnum.YB_ALIPAY.getCode());
				  if(depositOrder != null){
					  json = this.setYBParams(depositOrder);
				  }else{
					  json.put("code", "0");
				  }
			  }else if(depositOrderForm.getTradeMode() == Integer.valueOf(TradeModeEnum.YB_WECHAT.getCode())){	
				  //银宝-微信
				  depositOrder = depositOrderService.createTransferBankOrder(depositOrderForm, user.getId(), TradeModeEnum.YB_WECHAT.getCode());
				  if(depositOrder != null){
					  json = this.setYBParams(depositOrder);
				  }else{
					  json.put("code", "0");
				  }
			  }else if(depositOrderForm.getTradeMode() == Integer.valueOf(TradeModeEnum.TH_WECHAT_5000.getCode())){
				  //通汇微信支付
				  depositOrder = depositOrderService.createTransferBankOrder(depositOrderForm, user.getId(), TradeModeEnum.TH_WECHAT_5000.getCode());
				  if(depositOrder != null){
					  json = this.setTHWechatParams(json, depositOrder, ip, user, "13665428", "38e3466b176b464bb22b8cf525418583");
				  }else{
					  json.put("code", "0");
				  }
			  }else if(depositOrderForm.getTradeMode() == Integer.valueOf(TradeModeEnum.LY_ONLINE_PAY_PROXY.getCode())){
				  //乐盈在线支付
				  depositOrder = depositOrderService.createTransferBankOrder(depositOrderForm, user.getId(), TradeModeEnum.LY_ONLINE_PAY_PROXY.getCode());
				  if(depositOrder != null){
					  json = this.setLYParams(depositOrder, request);
				  }else{
					  json.put("code", "0");
				  }
			  }else if(depositOrderForm.getTradeMode() == Integer.valueOf(TradeModeEnum.SHB_WECHAT.getCode())){
				  //速汇宝-微信支付
				  depositOrder = depositOrderService.createTransferBankOrder(depositOrderForm, user.getId(), TradeModeEnum.SHB_WECHAT.getCode());
				  if(depositOrder != null){
					  json = this.setShbScanParams(depositOrder, ip, user);
				  }else{
					  json.put("code", "0");
				  }
			  }
		  } catch (Exception e) {
			logger.error(e.getMessage(), e);
			json.put("code", "0");
		  }
		  
		  return String.valueOf(json);
	  }
	  
	  
	  private static final String pkey = ContextPropsLoad.getValByKey("PARTNER.PUBKEY");
	  /**
	   * 设置乐盈-在线支付参数 
	   * @throws Exception 
	   */
	  private JSONObject setLYParams(DepositOrder depositOrder, HttpServletRequest request) throws Exception{
		  //设置订单需要提交参数对象
		  LeYingPay leYingPay = new LeYingPay();
		  leYingPay.setSerialID(depositOrder.getOrderNo());
		  leYingPay.setSubmitTime(DateUtil.format(depositOrder.getCreateTime(), "yyyyMMddHHmmss"));
		  leYingPay.setFailureTime(DateUtil.addMins(depositOrder.getCreateTime(), "yyyyMMddHHmmss", 30));
		  leYingPay.setCustomerIP("");
		  StringBuilder orderDetails = new StringBuilder();
		  //商品信息
		  orderDetails.append(depositOrder.getOrderNo()).append(",")
		  .append(String.valueOf(depositOrder.getTradeAmount().multiply(new BigDecimal(100)))).append(",")
		  .append("福州茶具").append(",")
		  .append("厂家直销").append(",").append("1");
		  leYingPay.setOrderDetails(String.valueOf(orderDetails));
		  leYingPay.setTotalAmount(String.valueOf(depositOrder.getTradeAmount().multiply(new BigDecimal(100))));
		  leYingPay.setBuyerMarked("");
		  leYingPay.setPayType(LeYingPayTypeEnum.BANK_B2C.getCode());
		  leYingPay.setOrgCode(request.getParameter("depositBank"));
		  leYingPay.setCurrencyCode("1");
		  leYingPay.setDirectFlag("1");
		  leYingPay.setBorrowingMarked("0");
		  leYingPay.setCouponFlag("0");
		  leYingPay.setPlatformID("");
		  leYingPay.setReturnUrl(this.getBasePath());
		  leYingPay.setNoticeUrl(this.getBasePath()+"/pay/ly/callback");
		  leYingPay.setRemark("");
		  orderDetails.setLength(0);
		  leYingPay.setSignMsg(MD5Util.md5Encode(String.valueOf(orderDetails.append(leYingPay.getNewSignMsg()).append("&pkey=").append(pkey))));
		  JSONObject json = JSON.parseObject(leYingPay.toJSON());
		  return json;
	  }
	  
	  /**
	   * 设置银宝-支付宝参数 
	   * @throws Exception 
	   */
	  @SuppressWarnings("static-access")
	  private JSONObject setYBParams(DepositOrder depositOrder) throws Exception{
		  JSONObject json = new JSONObject();
		  //加密需要的参数
		  String jsonObj = "{\"tradeMode\":\"" + depositOrder.getTradeMode() + "\" ,\"tradeAmount\":\"" + depositOrder.getTradeAmount()  + "\",\"orderNo\": \"" + depositOrder.getOrderNo() + "\"}";
		  DESEncrypt desEncrypt = new DESEncrypt("Tkwss320j");
		  String params = desEncrypt.encrypt(jsonObj);
		  //支付有回调不用返回状态
		  json.put("params", URLEncoder.encode(URLEncoder.encode(params, "UTF-8"), "UTF-8"));
		  json.put("token", URLEncoder.encode(URLEncoder.encode(MD5Util.md5Encode(params + "EKIIS322e3o4*3232444ll2e11"), "UTF-8"), "UTF-8"));
		  return json;
	  }
	  
	  /**
	   * 设置通汇微信参数
	   */
	  private JSONObject setTHWechatParams(JSONObject json, DepositOrder depositOrder, String ip, User user, String merchantCode, String signReq){
		  	KeyValues kvs = new KeyValues();
		  	kvs.add(new KeyValue(AppConstants.INPUT_CHARSET, "UTF-8"));
		  	kvs.add(new KeyValue(AppConstants.NOTIFY_URL, this.getBasePath()+"/pay/th/callback"));
		  	kvs.add(new KeyValue(AppConstants.PAY_TYPE, "1"));	
		  	kvs.add(new KeyValue(AppConstants.BANK_CODE, "WEIXIN"));
		  	kvs.add(new KeyValue(AppConstants.MERCHANT_CODE, merchantCode));
		  	kvs.add(new KeyValue(AppConstants.ORDER_NO, depositOrder.getOrderNo()));
		  	kvs.add(new KeyValue(AppConstants.ORDER_AMOUNT, String.valueOf(depositOrder.getTradeAmount())));
		  	kvs.add(new KeyValue(AppConstants.ORDER_TIME, DateUtil.format(depositOrder.getCreateTime(), "yyyy-MM-dd HH:mm:ss")));
		  	kvs.add(new KeyValue(AppConstants.REQ_REFERER, this.getBasePath()));
		  	kvs.add(new KeyValue(AppConstants.CUSTOMER_IP, ip));
		  	kvs.add(new KeyValue(AppConstants.RETURN_PARAMS, depositOrder.getTradeMode().toString()));
		  	String sign = kvs.sign(signReq, "UTF-8");
		  	json.put("input_charset", "UTF-8");
		  	json.put("notify_url", this.getBasePath() + "/pay/th/callback");//服务器异步通知地址
		  	json.put("return_url", "");//页面同步跳转通知地址 支付成功后，通过页面跳转的方式跳转到商户指定的网站页面
		  	json.put("pay_type", "1");
		  	json.put("bank_code", "WEIXIN");
		  	json.put("merchant_code", merchantCode); //商户号
		  	json.put("order_no", depositOrder.getOrderNo());	//商户编号   订单号
		  	json.put("order_amount", depositOrder.getTradeAmount());
		  	json.put("order_time", DateUtil.format(depositOrder.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
		  	json.put("product_name", ""); //商品名称
		  	json.put("product_num", "");  //商户数量
		  	json.put("req_referer", this.getBasePath());	//来路域名
		  	json.put("customer_ip", ip);//消费者IP
		  	json.put("customer_phone", ""); //消费者的联系电话
		  	json.put("receive_address", "");//收货人的地址
		  	json.put("return_params", depositOrder.getTradeMode()); //回传参数
		  	json.put("sign", sign);//签名
		  	return json;
	  }
	  
	  /**
	   * 设置国付宝参数
	   */
	  private JSONObject setGFBParams(JSONObject json, DepositOrder depositOrder, String ip, User user){
		  json.put("version", Constant.GuofubaoParamManage.version);
		  json.put("charset", Constant.GuofubaoParamManage.charset);
		  json.put("language", Constant.GuofubaoParamManage.language);
		  json.put("signType", Constant.GuofubaoParamManage.signType);
		  json.put("tranCode", Constant.GuofubaoParamManage.tranCode);
		  json.put("merchantID", Constant.GuofubaoParamManage.merchantID); //商户代码
		  json.put("merOrderNum", depositOrder.getOrderNo());	//订单号
		  json.put("tranAmt", String.valueOf(depositOrder.getTradeAmount()));
		  json.put("feeAmt", "");
		  json.put("currencyType", Constant.GuofubaoParamManage.currencyType);
		  json.put("frontMerUrl", "");  //商户前台通知地址
		  json.put("backgroundMerUrl", this.getBasePath() +"/pay/callback");	//商户后台通知地址
		  String tranDateTime = DateUtil.format(new Date(System.currentTimeMillis()), "yyyyMMddHHmmss");
		  json.put("tranDateTime", tranDateTime);
		  json.put("virCardNoIn", Constant.GuofubaoParamManage.account); //国付宝账户号
		  json.put("tranIP", ip);
		  json.put("isRepeatSubmit", Constant.GuofubaoParamManage.isRepeatSubmit);
		  json.put("goodsName", "");//商品名称
		  json.put("goodsDetail", "");//商品详情
		  json.put("buyerName", user.getLoginName());
		  json.put("buyerContact", "");
		  json.put("merRemark1", "");
		  json.put("merRemark2", "");
		  GuofubaoPay gfb = new GuofubaoPay();
		  gfb.setMerOrderNum(depositOrder.getOrderNo());
		  gfb.setTranAmt(String.valueOf(depositOrder.getTradeAmount()));
		  gfb.setFeeAmt("");
		  gfb.setTranDateTime(tranDateTime);
		  gfb.setFrontMerUrl("");
		  gfb.setBackgroundMerUrl(this.getBasePath() +"/pay/callback");
		  gfb.setOrderId("");
		  gfb.setGopayOutOrderId("");
		  gfb.setTranIP(ip);
		  gfb.setRespCode("");
		  gfb.setGopayServerTime("");
		  json.put("signValue", GopayUtils.setSign(gfb, Constant.GuofubaoParamManage.signType));
		  return json;
	  }
	  
	  /**
	   * 设置速汇宝-微信支付
	   */
	  private JSONObject setShbScanParams(DepositOrder depositOrder, String ip, User user) throws Exception{
		  JSONObject jsonParams = new JSONObject();
		  jsonParams.put("clientIp", ip);
		  jsonParams.put("orderNo", depositOrder.getOrderNo());
		  jsonParams.put("orderTime", DateFormatUtils.format(depositOrder.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
		  jsonParams.put("orderAmount", depositOrder.getTradeAmount());
		  
		  DESEncrypt desEncrypt = new DESEncrypt("Tkwss320j");
		  String params = desEncrypt.encrypt(jsonParams.toJSONString());
		  
		  Map<String, String> map = new HashMap<>();
		  map.put("params", URLEncoder.encode(URLEncoder.encode(params, "UTF-8"), "UTF-8"));
		  map.put("token", URLEncoder.encode(URLEncoder.encode(MD5Util.md5Encode(params + "EKIIS322e3o4*3232444ll2e11"), "UTF-8"), "UTF-8"));
		  
		  String reqUrl = "http://pay.nennai.top/pay/shb/wechat";
		  String result = HttpClientUtils.post(reqUrl, map);
		  logger.info("result:" + result);
		  return JSON.parseObject(result);
	  }
}
