package com.xjw.controller.order;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.order.DepositOrderForm;
import com.xjw.entity.po.order.DepositOrder;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.vo.order.DepositOrderVo;
import com.xjw.kzenum.RestServiceErrorEnum;
import com.xjw.kzenum.order.OperationTypeEnum;
import com.xjw.kzenum.order.TradeModeEnum;
import com.xjw.kzenum.sys.StatusEnum;
import com.xjw.service.order.DepositOrderService;
import com.xjw.service.sys.FinalResourcesValuesService;
import com.xjw.service.sys.RoleService;
import com.xjw.service.sys.UserService;
import com.xjw.util.JSONDataValidator;
import com.xjw.util.SequenceBuilder;
import com.xjw.util.SequenceBuilder.SequenceType;
import com.xjw.utility.BizException;
import com.xjw.utility.ContextPropsLoad;
import com.xjw.utility.DateUtil;
import com.xjw.utility.SHAUtil;
import com.xjw.utility.StringUtil;

/**
 * 存款
 */
@Controller
@RequestMapping("/order/deposit/")
public class DepositOrderController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(DepositOrderController.class);
	@Resource
	private DepositOrderService depositOrderService;
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	
	@Resource
	private FinalResourcesValuesService finalResourcesValuesService;
	
	private static final String addPage = "/order/deposit/skipAdd";
	private static final String editPage = "/order/deposit/skipEdit";
	private static final String listPage = "/order/deposit/list";

	/**
	 * 银行转账Rest接口
	 * 
	 * @param params
	 * @param response
	 */
	@RequestMapping(value = "/createBankTransferAccounts.json", method = RequestMethod.POST, headers = "Content-Type=application/json")
	@ResponseBody
	public String createBankTransferAccounts(@RequestBody DepositOrderVo vo, HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		try {
			String key = ContextPropsLoad.getValByKey("DEPOSIT.KEY");
			String token = SHAUtil.shaEncode(vo.getUserId() + key + vo.getBankType());
			jsonObj = JSONDataValidator.JSONDataTokenVali(token, vo.getToken(), jsonObj);
			String code = String.valueOf(jsonObj.get("code"));
			if (code.equals("1")) {
				DepositOrder depositOrder = depositOrderService.createBankTransferAccounts(vo);
				jsonObj.put("data", depositOrder);
				return jsonObj.toString();
			} else {
				return jsonObj.toString();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
			jsonObj.put("code", "0");
			jsonObj.put("data", RestServiceErrorEnum.FORMAT.getName());
			return jsonObj.toString();
		}
	}

	/**
	 * 第三方转账Rest接口
	 * 
	 * @param params
	 * @param response
	 */
	@RequestMapping(value = "/createThirdPartyAccounts.json", method = RequestMethod.POST, headers = "Content-Type=application/json")
	@ResponseBody
	public String createThirdPartyAccounts(@RequestBody DepositOrderVo vo,
			HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		try {
			String key = ContextPropsLoad.getValByKey("DEPOSIT.KEY");
			String token = SHAUtil.shaEncode(vo.getUserId() + key
					+ vo.getUserId());
			jsonObj = JSONDataValidator.JSONDataTokenVali(token, vo.getToken(),
					jsonObj);
			String code = String.valueOf(jsonObj.get("code"));
			if (code.equals("1")) {
				DepositOrder depositOrder = depositOrderService
						.createThirdPartyAccounts(vo);
				jsonObj.put("data", depositOrder);
				return jsonObj.toString();
			} else {
				return jsonObj.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonObj.put("code", "0");
			jsonObj.put("data", RestServiceErrorEnum.FORMAT.getName());
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
			return jsonObj.toString();
		}
	}

	/**
	 * 第三方支付响应接口
	 * 
	 * @param request
	 * @param response
	 * @param orderNumber
	 * @param token
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{orderNo}/{token}/thirdPartyResponse.json")
	@ResponseBody
	public String thirdPartyResponse(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("orderNo") String orderNo,
			@PathVariable("token") String token) {
		JSONObject jsonObj = new JSONObject();
		try {
			String key = ContextPropsLoad.getValByKey("WITHDRAWAL.KEY");
			String getToken = SHAUtil.shaEncode(key + orderNo + orderNo);
			jsonObj = JSONDataValidator.JSONDataTokenVali(token, getToken, jsonObj);
			String code = String.valueOf(jsonObj.get("code"));
			if (code.equals("1")) {
				depositOrderService.thirdPartyResponse(orderNo);
				jsonObj.put("data", "Success");
				return jsonObj.toString();
			} else {
				return jsonObj.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
			jsonObj.put("code", "0");
			jsonObj.put("data", RestServiceErrorEnum.FORMAT.getName());
			return jsonObj.toString();
		}
	}

	@RequestMapping("/list")
	public String list(Model model, DepositOrderForm depositOrderForm, HttpServletRequest request) {
		User user = super.getCurrentUser();
		
		try {
			Map<String, Object> conditionParam = new HashMap<String, Object>();
//			conditionParam.put("notInParentIds", AloneConstant.AGENT_USER_ID_LIST);
			
			String keywords = depositOrderForm.getKeywords();
			if (keywords != null && StringUtil.isNotBlank(keywords)) {
				conditionParam.put("keywords", keywords);
			}
			String orderNo = depositOrderForm.getOrderNo();
			if (orderNo != null && StringUtil.isNotBlank(orderNo)) {
				conditionParam.put("orderNo", orderNo);
			}
			String tradeMode = depositOrderForm.getTradeMode();
			if (tradeMode != null && StringUtil.isNotBlank(tradeMode)) {
				conditionParam.put("tradeMode", tradeMode);
			}
			String beginTime = depositOrderForm.getBeginTime();
			if (beginTime != null && StringUtil.isNotBlank(beginTime)) {
				conditionParam.put("beginTime", beginTime);
			}

			String endTime = depositOrderForm.getEndTime();
			if (endTime != null && StringUtil.isNotBlank(endTime)) {
				conditionParam.put("endTime", endTime);
			}

			//客服只能看支付宝和微信的
//			if(UserTypeAllEnum.KF.getCode().equals(String.valueOf(user.getType()))){
//				List<Integer> tradeModeList = new ArrayList<Integer>();
//				tradeModeList.add(Integer.valueOf(TradeModeEnum.ONLINE_PAYMENT.getCode()));
//				tradeModeList.add(Integer.valueOf(TradeModeEnum.TH_WECHAT.getCode()));
//				tradeModeList.add(Integer.valueOf(TradeModeEnum.YB_WECHAT.getCode()));
//				tradeModeList.add(Integer.valueOf(TradeModeEnum.YB_ALIPAY.getCode()));
//				tradeModeList.add(Integer.valueOf(TradeModeEnum.SHB_WECHAT.getCode()));
//				tradeModeList.add(Integer.valueOf(TradeModeEnum.YS_ONLINE.getCode()));
//				conditionParam.put("tradeModeList", tradeModeList);
//			}
			
			conditionParam.put("statusList", StringUtil.getListFromStr("1"));
			Page<DepositOrder> page = depositOrderService.getPage(conditionParam, depositOrderForm.getPageNo(), depositOrderForm.getPageSize());
			model.addAttribute("page", page);
			model.addAttribute("form", depositOrderForm);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
		}
		return "xjw/order/deposit/list";
	}

	@RequestMapping("/historyList")
	public String historyList(Model model, DepositOrderForm depositOrderForm, HttpServletRequest request) {
		if(StringUtil.isBlank(depositOrderForm.getBeginTime()) && StringUtil.isBlank(depositOrderForm.getEndTime()) ){
			Date date = new Date();
			depositOrderForm.setBeginTime(DateFormatUtils.format(DateUtil.getOneDayBefore(date), "yyyy-MM-dd HH:mm:ss"));
			depositOrderForm.setEndTime(DateFormatUtils.format(date,"yyyy-MM-dd HH:mm:ss"));
		}
		
		Map<String, Object> conditionParam = new HashMap<String, Object>();
		
		String keywords = depositOrderForm.getKeywords();
		if (keywords != null && StringUtil.isNotBlank(keywords)) {
			conditionParam.put("keywords", keywords);
		}
		String orderNo = depositOrderForm.getOrderNo();
		if (orderNo != null && StringUtil.isNotBlank(orderNo)) {
			conditionParam.put("orderNo", orderNo);
		}
		
		String beginTime = depositOrderForm.getBeginTime();
		if (beginTime != null && StringUtil.isNotBlank(beginTime)) {
			conditionParam.put("beginTime", beginTime);
		}
		String endTime = depositOrderForm.getEndTime();
		if (endTime != null && StringUtil.isNotBlank(endTime)) {
			conditionParam.put("endTime", endTime);
		}
		String tradeMode = depositOrderForm.getTradeMode();
		if (tradeMode != null && StringUtil.isNotBlank(tradeMode)) {
			conditionParam.put("tradeMode", tradeMode);
		}
		String status = depositOrderForm.getStatus();
		if (status != null && StringUtil.isNotBlank(status)) {
			conditionParam.put("statusList", StringUtil.getListFromStr(status));
		} else {
			conditionParam.put("statusList", StringUtil.getListFromStr("2,3"));
		}
		String updateUserName = depositOrderForm.getUpdateUserName();//操作人
		if (updateUserName != null && StringUtil.isNotBlank(updateUserName)) {
			conditionParam.put("updateUserName", updateUserName);
		}
		String operationType = depositOrderForm.getOperationType();//
		if (operationType != null && StringUtil.isNotBlank(operationType)) {
			conditionParam.put("operationType", operationType);
		}
			
		try {
			//查询客 服部人操作人员
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("statusList", StringUtil.getListFromStr(StatusEnum.DEFAULT.getCode() + "," + StatusEnum.LOCK.getCode()));
			params.put("deptId", "60");//客服部
			Page<User> pageUser = userService.getPage(params, depositOrderForm.getPageNo(), depositOrderForm.getPageSize());
	        model.addAttribute("list", pageUser);
			
	        Page<DepositOrder> page = depositOrderService.getPage(conditionParam, depositOrderForm.getPageNo(),depositOrderForm.getPageSize());
			
			model.addAttribute("page", page);
			model.addAttribute("form", depositOrderForm);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
		}
		return "xjw/order/deposit/historyList";
	}

	@RequestMapping("/showDepositOrderPanel")
	public String showDepositOrderPanel(Model model,
			DepositOrderForm depositOrderForm, HttpServletResponse response) {
		try {
			DepositOrder depositOrder = depositOrderService.selectById(Long.valueOf(depositOrderForm.getId()));
			model.addAttribute("dto", depositOrder);
			model.addAttribute("from", depositOrderForm);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "xjw/order/deposit/depositOrderPanel";
	}

	/**
	 * 审核成功、失败调用
	 * 
	 * @param model
	 * @param depositOrderForm
	 * @param response
	 */
	@RequestMapping("/updateStatus")
	public void updateStatus(Model model, DepositOrderForm depositOrderForm,
			HttpServletResponse response) {
		try {
			depositOrderService.updateOrderExamine(depositOrderForm);
			this.write("1", response);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
		}
	}

	/**
	 * 导出存款记录
	 * 
	 * @param depositOrderForm
	 * @param request
	 */
	@RequestMapping("/downExcel")
	public void downExcel(DepositOrderForm depositOrderForm, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> conditionParam = new HashMap<String, Object>();
//		conditionParam.put("notInParentIds", AloneConstant.AGENT_USER_ID_LIST);
		
		String keywords = depositOrderForm.getKeywords();
		if (keywords != null && StringUtil.isNotBlank(keywords)) {
			conditionParam.put("keywords", keywords);
		}
		String orderNo = depositOrderForm.getOrderNo();
		if (orderNo != null && StringUtil.isNotBlank(orderNo)) {
			conditionParam.put("orderNo", orderNo);
		}
		String beginTime = depositOrderForm.getBeginTime();
		if (beginTime != null && StringUtil.isNotBlank(beginTime)) {
			conditionParam.put("beginTime", beginTime);
		}
		String endTime = depositOrderForm.getEndTime();
		if (endTime != null && StringUtil.isNotBlank(endTime)) {
			conditionParam.put("endTime", endTime);
		}
		String tradeMode = depositOrderForm.getTradeMode();
		if (tradeMode != null && StringUtil.isNotBlank(tradeMode)) {
			conditionParam.put("tradeMode", tradeMode);
		}
		String status = depositOrderForm.getStatus();
		if (status != null && StringUtil.isNotBlank(status)) {
			conditionParam.put("statusList", StringUtil.getListFromStr(status));
		} else {
			conditionParam.put("statusList", StringUtil.getListFromStr("2,3"));
		}

		List<DepositOrder> list = depositOrderService.selectAll(conditionParam);
		
		if(list != null && list.size() > 0){
			try {
				response.setContentType("application/binary;charset=ISO8859_1");
				// 生成提示信息，
				response.setContentType("application/vnd.ms-excel");
				String codedFileName = null;
				OutputStream fOut = null;
				// 进行转码，使其支持中文文件名
				codedFileName = "存款订单报表";
				codedFileName = new String(codedFileName.getBytes("gbk"), "iso-8859-1");
				response.setHeader("content-disposition", "attachment;filename=" + codedFileName + DateUtil.format(new Date(), "yyyy-MM-dd") + ".xls");
				//设置TAB名称
				HSSFWorkbook wb = new HSSFWorkbook();
				HSSFSheet sheet = wb.createSheet("存款记录");
				sheet.setDefaultRowHeight((short) (2 * 256)); //设置默认行高，表示2个字符的高度
				sheet.setDefaultColumnWidth(22);
				
				HSSFCellStyle style = wb.createCellStyle();
				HSSFFont font = wb.createFont();
				font.setFontName("Arial");
				font.setFontHeightInPoints((short) 16); //设置字体大小
//				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//				style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //创建一个居中格式
//				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
//				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
//				style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
//				style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
				style.setFont(font);
				HSSFRow row = sheet.createRow((int) 0);
				HSSFCell cell = row.createCell(0);
				CellRangeAddress cra = new CellRangeAddress(0, 0, 0, 11);
				sheet.addMergedRegion(cra);
				cell.setCellValue("存款记录");
				cell.setCellStyle(style);
				for (int i = 1; i < 12; i++) {
					cell = row.createCell(i);
					cell.setCellValue("");
					cell.setCellStyle(style);
				}
				
				HSSFFont font2 = wb.createFont();
				font2.setFontName("Arial");
				font2.setFontHeightInPoints((short) 13);
//				font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				
				HSSFCellStyle style1 = wb.createCellStyle();
//				style1.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框  
//				style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框  
//				style1.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框  
//				style1.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框  
				style1.setFont(font2);
				
				HSSFRow row1 = sheet.createRow((int) 1);
				HSSFCell cell1 = row1.createCell(0);
				CellRangeAddress cra1 = new CellRangeAddress(1, 1, 0, 11);
				sheet.addMergedRegion(cra1);
				if(beginTime != null && StringUtil.isNotBlank(beginTime) && endTime != null && StringUtil.isNotBlank(endTime)){
					cell1.setCellValue("导出时间：" + beginTime + "—" + endTime);
//					style1.setAlignment(HSSFCellStyle.ALIGN_LEFT);
					cell1.setCellStyle(style1);
				}
				for (int i = 1; i < 12; i++) {
					cell1 = row1.createCell(i);
					cell1.setCellValue("");
					cell1.setCellStyle(style);
				}

				HSSFCellStyle style2 = wb.createCellStyle();
//				style2.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框  
//				style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框  
//				style2.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框  
//				style2.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框  
//				style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);   
				style2.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);

				style2.setFont(font2);
				
				HSSFRow row2 = sheet.createRow((int) 2);
				HSSFCell cell2 = row2.createCell(0);
				cell2.setCellValue("存款编号");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(1);
				cell2.setCellValue("会员账号");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(2);
				cell2.setCellValue("存款金额");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(3);
				cell2.setCellValue("存款的方法");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(4);
				cell2.setCellValue("存入的银行");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(5);
				cell2.setCellValue("账户姓名");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(6);
				cell2.setCellValue("存入的银行账号");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(7);
				cell2.setCellValue("存款时间");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(8);
				cell2.setCellValue("完成时间");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(9);
				cell2.setCellValue("结果");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(10);
				cell2.setCellValue("操作类型");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(11);
				cell2.setCellValue("操作人");
				cell2.setCellStyle(style2);
				
				Map<String, Object> map = finalResourcesValuesService.getMapForList("USER_BANK_TYPE");
				HSSFFont font3 = wb.createFont();
				font3.setFontName("Arial");
				font3.setFontHeightInPoints((short) 12);
				HSSFCellStyle style3 = wb.createCellStyle();
//				style3.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框  
//				style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框  
//				style3.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框  
//				style3.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框  
				style3.setFont(font3);
				for (int i = 0; i < list.size(); i++) {
					HSSFRow row3 = sheet.createRow((int) i + 3);
					DepositOrder depositOrder = list.get(i);
					// 设置单元格值
					HSSFCell hssfCell = row3.createCell(0);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(depositOrder.getOrderNo());
					
					hssfCell = row3.createCell(1);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(depositOrder.getLoginName());
					
					hssfCell = row3.createCell(2);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(depositOrder.getTradeAmount().doubleValue());
					
					hssfCell = row3.createCell(3);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(TradeModeEnum.getEnumByCode(TradeModeEnum.class, String.valueOf(depositOrder.getTradeMode())).getName());
					
					hssfCell = row3.createCell(4);
					hssfCell.setCellStyle(style3);
					
					if(depositOrder.getToBankType() != null){
						hssfCell.setCellValue(String.valueOf(map.get(String.valueOf(depositOrder.getToBankType()))));
					}else{
						hssfCell.setCellValue("");
					}
					
					hssfCell = row3.createCell(5);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(depositOrder.getToBankAccount());
					
					
					String toBankCard = depositOrder.getToBankCard();
					hssfCell = row3.createCell(6);
					hssfCell.setCellStyle(style3);
					if(StringUtil.isNotBlank(toBankCard))
						hssfCell.setCellValue(toBankCard.equals("tiantianlee123@gmail.com") ? "6212262008016966740" : toBankCard);
					else
						hssfCell.setCellValue(toBankCard);
					
					hssfCell = row3.createCell(7);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(depositOrder.getCreateTime()));
					
					hssfCell = row3.createCell(8);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(depositOrder.getUpdateTime()));
					
					hssfCell = row3.createCell(9);
					hssfCell.setCellStyle(style3);
					if (depositOrder.getStatus() == 2) {
						hssfCell.setCellValue("成功");
					} else {
						hssfCell.setCellValue("失败");
					}
					
					hssfCell = row3.createCell(10);
					hssfCell.setCellStyle(style3);
					if (depositOrder.getOperationType() == null) {
						hssfCell.setCellValue("");
					} else {
						hssfCell.setCellValue(OperationTypeEnum.getEnumByCode(OperationTypeEnum.class, String.valueOf(depositOrder.getOperationType())).getName());
					}
					
					hssfCell = row3.createCell(11);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(depositOrder.getUpdateUserName());
				}
				fOut = response.getOutputStream();
				wb.write(fOut);
				fOut.flush();
				fOut.close();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				logger.error("---fill---:" + e.fillInStackTrace());
				logger.error("---msg---:" + e.getMessage());
				logger.error("---e---:" + e.toString());
			}
		}
	}

	@RequestMapping("/dowmloadExcel")
	public void dowmloadExcel(Model model, DepositOrderForm depositOrderForm,
			HttpServletResponse response) {
		try {
			response.setContentType("application/binary;charset=ISO8859_1");
			// 生成提示信息，
			response.setContentType("application/vnd.ms-excel");
			String codedFileName = null;
			OutputStream fOut = null;
			// 进行转码，使其支持中文文件名
			codedFileName = "中文";
			codedFileName = new String(codedFileName.getBytes("gbk"), "iso-8859-1");
			response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
			// 产生工作簿对象
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 产生工作表对象
			HSSFSheet sheet = workbook.createSheet();
			for (int i = 0; i <= 20; i++) {
				HSSFRow row = sheet.createRow((int) i);// 创建一行
				HSSFCell cell = row.createCell((int) 0);// 创建一列
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue("测试成功" + i);
			}
			fOut = response.getOutputStream();
			workbook.write(fOut);
			fOut.flush();
			fOut.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
		}
	}
	
	@RequestMapping("/skipAdd")
	public String skipAdd(Model model) {
		model.addAttribute("op", "add");
		
		return "xjw/order/deposit/depositDetail";
	}
	
	@RequestMapping("/skipEdit")
	public String skipEdit(Model model, DepositOrder depositOrder) {
		model.addAttribute("op", "edit");
		model.addAttribute("dto", depositOrderService.selectById(Long.valueOf(depositOrder.getId())));
		
		return "xjw/order/deposit/depositDetail";
	}
	
	@RequestMapping("/save")
	public void save(DepositOrder depositOrder, Model model, HttpServletResponse response) {
		try {
//			System.out.println(depositOrder.getLoginName() + "," + depositOrder.getOrderNo()
//					 + "," + depositOrder.getFromBankAccount() + "," + depositOrder.getTradeAmount()
//					 + "," + depositOrder.getTradeMode());
			
			String orderNo = SequenceBuilder.next(SequenceType.DP);
			depositOrder.setOrderNo(orderNo);
			
			if(depositOrder.getId() == null){
				depositOrder = depositOrderService.save(depositOrder);
				if(null != depositOrder.getId()){
					this.writerSuccessJSONDataById("新增成功", addPage, null, listPage, null);
				}
			}/*else{
				depositOrderService.update(depositOrder);
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("id", depositOrder.getId());
				this.writerSuccessJSONDataById("编辑成功", null, editPage, listPage, param);
			}*/
		} catch (Exception e) {
			writerJSONData("failure", "操作失败", null, listPage);
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
		}
	}
	
	
}