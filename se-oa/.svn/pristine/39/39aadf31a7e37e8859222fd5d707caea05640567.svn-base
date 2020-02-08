package com.xjw.controller.order;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xjw.controller.BaseController;
import com.xjw.entity.Page;
import com.xjw.entity.form.order.WithdrawalOrderForm;
import com.xjw.entity.po.order.WithdrawalOrder;
import com.xjw.entity.po.sys.User;
import com.xjw.entity.vo.order.DrawalCount;
import com.xjw.entity.vo.order.WithdrawalOrderVo;
import com.xjw.kzenum.RestServiceErrorEnum;
import com.xjw.service.order.WithdrawalOrderService;
import com.xjw.service.sys.FinalResourcesValuesService;
import com.xjw.util.JSONDataValidator;
import com.xjw.util.SessionManager;
import com.xjw.utility.BizException;
import com.xjw.utility.ContextPropsLoad;
import com.xjw.utility.DateUtil;
import com.xjw.utility.SHAUtil;
import com.xjw.utility.StringUtil;

/**
 * 提款
 */
@Controller
@RequestMapping("/order/withdraw/")
public class WithdrawalOrderController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(WithdrawalOrderController.class);
	
	@Resource
	private WithdrawalOrderService withdrawalOrderService;
	@Resource
	private FinalResourcesValuesService finalResourcesValuesService;

	/**
	 * 提款接口
	 * 
	 * @param params
	 * @param response
	 */
	@RequestMapping(value = "/createWithdrawalOrder.json", method = RequestMethod.POST, headers = "Content-Type=application/json")
	@ResponseBody
	public String createWithdrawalOrder(@RequestBody WithdrawalOrderVo withdrawalOrderVo, HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		try {
			String key = ContextPropsLoad.getValByKey("WITHDRAWAL.KEY");
			String token = SHAUtil.shaEncode(key
					+ withdrawalOrderVo.getUserId() + key);
			jsonObj = JSONDataValidator.JSONDataTokenVali(token,
					withdrawalOrderVo.getToken(), jsonObj);
			String code = String.valueOf(jsonObj.get("code"));
			if (code.equals("1")) {
				withdrawalOrderService.createWithdrawalOrder(withdrawalOrderVo);
				jsonObj.put("data", "create success!");
				return jsonObj.toString();
			} else {
				return jsonObj.toString();
			}
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
			jsonObj.put("code", "0");
			jsonObj.put("data",
					RestServiceErrorEnum.INSUFFICIENT_FUNDS.getName());
			return jsonObj.toString();
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

	@RequestMapping("/list")
	public String list(Model model, WithdrawalOrderForm withdrawalOrderForm,
			HttpServletRequest request) {
		try {
			Map<String, Object> conditionParam = new HashMap<String, Object>();
//			conditionParam.put("notInParentIds", AloneConstant.AGENT_USER_ID_LIST);
			
			String keywords = withdrawalOrderForm.getKeywords();
			if (keywords != null && StringUtil.isNotBlank(keywords)) {
				conditionParam.put("keywords", keywords);
			}
			String orderNo = withdrawalOrderForm.getOrderNo();
			if (orderNo != null && StringUtil.isNotBlank(orderNo)) {
				conditionParam.put("orderNo", orderNo);
			}
			String beginTime = withdrawalOrderForm.getBeginTime();
			if (beginTime != null && StringUtil.isNotBlank(beginTime)) {
				conditionParam.put("beginTime", beginTime);
			}
			String endTime = withdrawalOrderForm.getEndTime();
			if (endTime != null && StringUtil.isNotBlank(endTime)) {
				conditionParam.put("endTime", endTime);
			}
			conditionParam.put("statusList", StringUtil.getListFromStr("1"));
			Page<WithdrawalOrder> page = withdrawalOrderService.getPage(
					conditionParam, withdrawalOrderForm.getPageNo(), withdrawalOrderForm.getPageSize());
			
			List<WithdrawalOrder> list = page.getDataList();
			if(null != list &&  0 != list.size() ){
				List<Long> listuserId = new ArrayList<Long>();
				for (WithdrawalOrder withdrawalOrder : list) {
					listuserId.add(withdrawalOrder.getUserId());
				}
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("userIds", listuserId);
				List<DrawalCount> listDrawalCount = withdrawalOrderService.getDrawalCount(param);
				Map<Long,Object> userMap = new HashMap<Long,Object>();
				for (DrawalCount drawalCount : listDrawalCount) {
					userMap.put(drawalCount.getUserId(), drawalCount.getCount());
				}
				for (WithdrawalOrder withdrawalOrder : list) {
					Object count = userMap.get(withdrawalOrder.getUserId());
					if( null != count){
						withdrawalOrder.setDrawalCount(new Long(count.toString()));
					}else{
						withdrawalOrder.setDrawalCount(0L);
					}
				}
			}
			model.addAttribute("page", page);
			model.addAttribute("form", withdrawalOrderForm);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
		}
		return "xjw/order/withdraw/list";
	}

	@RequestMapping("/historyList")
	public String historyList(Model model, WithdrawalOrderForm withdrawalOrderForm) {
		if(StringUtil.isBlank(withdrawalOrderForm.getBeginTime()) && StringUtil.isBlank(withdrawalOrderForm.getEndTime()) ){
			Date date = new Date();
			withdrawalOrderForm.setBeginTime(DateFormatUtils.format(DateUtil.getOneDayBefore(date), "yyyy-MM-dd HH:mm:ss"));
			withdrawalOrderForm.setEndTime(DateFormatUtils.format(date,"yyyy-MM-dd HH:mm:ss"));
		}
		
		Map<String, Object> conditionParam = new HashMap<String, Object>();
		
		String keywords = withdrawalOrderForm.getKeywords();
		if (keywords != null && StringUtil.isNotBlank(keywords)) {
			conditionParam.put("keywords", keywords);
		}
		String orderNo = withdrawalOrderForm.getOrderNo();
		if (orderNo != null && StringUtil.isNotBlank(orderNo)) {
			conditionParam.put("orderNo", orderNo);
		}
		String beginTime = withdrawalOrderForm.getBeginTime();
		if (beginTime != null && StringUtil.isNotBlank(beginTime)) {
			conditionParam.put("beginTime", beginTime);
		}
		String endTime = withdrawalOrderForm.getEndTime();
		if (endTime != null && StringUtil.isNotBlank(endTime)) {
			conditionParam.put("endTime", endTime);
		}
		String status = withdrawalOrderForm.getStatus();
		if (status != null && StringUtil.isNotBlank(status)) {
			conditionParam.put("statusList", StringUtil.getListFromStr(status));
		} else {
			conditionParam.put("statusList", StringUtil.getListFromStr("2,3"));
		}
			
		try {	
			Page<WithdrawalOrder> page = withdrawalOrderService.getPage(conditionParam, withdrawalOrderForm.getPageNo(), withdrawalOrderForm.getPageSize());
			
			model.addAttribute("page", page);
			model.addAttribute("form", withdrawalOrderForm);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
		}
		return "xjw/order/withdraw/historyList";
	}

	@RequestMapping("/showDepositOrderPanel")
	public String showDepositOrderPanel(Model model,
			WithdrawalOrderForm withdrawalOrderForm, HttpServletRequest request) {
		try {
			User user = SessionManager.getUserSession(request);
			WithdrawalOrder withdrawalOrder = withdrawalOrderService
					.selectById(Long.valueOf(withdrawalOrderForm.getId()));
			model.addAttribute("dto", withdrawalOrder);
			model.addAttribute("form", withdrawalOrderForm);
			model.addAttribute("userType", user.getType());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
		}
		return "xjw/order/withdraw/withdrawOrderPanel";
	}
	
	/**
	 * 审核成功
	 * 
	 * @param model
	 */
	@RequestMapping("/fkExamineSuccess")
	@ResponseBody
	public String fkExamineSuccess(Model model,
			WithdrawalOrderForm withdrawalOrderForm, HttpServletRequest request) {
		try {
			User user = SessionManager.getUserSession(request);
			withdrawalOrderService.updateExamineSucc(user, withdrawalOrderForm);
			return "1";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
			return "0";
		}
		// return "redirect:" + listPage;
	}

	/**
	 * 审核失败
	 * 
	 * @param model
	 */
	@RequestMapping("/fkExamineFail")
	@ResponseBody
	public String fkExamineFail(WithdrawalOrderForm withdrawalOrderForm,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = SessionManager.getUserSession(request);
			withdrawalOrderForm.setUserType(String.valueOf(user.getType()));
			withdrawalOrderService.updateExamineFail(withdrawalOrderForm);
			return "1";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
			return "0";
		}
	}

	/**
	 * 导出提款记录
	 * 
	 * @param withdrawalOrderForm
	 * @param request
	 */
	@RequestMapping("/downExcel")
	public void downExcel(WithdrawalOrderForm withdrawalOrderForm, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> conditionParam = new HashMap<String, Object>();
//		conditionParam.put("notInParentIds", AloneConstant.AGENT_USER_ID_LIST);
		
		String keywords = withdrawalOrderForm.getKeywords();
		if (keywords != null && StringUtil.isNotBlank(keywords)) {
			conditionParam.put("keywords", keywords);
		}
		String orderNo = withdrawalOrderForm.getOrderNo();
		if (orderNo != null && StringUtil.isNotBlank(orderNo)) {
			conditionParam.put("orderNo", orderNo);
		}
		String beginTime = withdrawalOrderForm.getBeginTime();
		if (beginTime != null && StringUtil.isNotBlank(beginTime)) {
			conditionParam.put("beginTime", beginTime);
		}
		String endTime = withdrawalOrderForm.getEndTime();
		if (endTime != null && StringUtil.isNotBlank(endTime)) {
			conditionParam.put("endTime", endTime);
		}
		String status = withdrawalOrderForm.getStatus();
		if (status != null && StringUtil.isNotBlank(status)) {
			conditionParam.put("statusList",
					StringUtil.getListFromStr(status));
		} else {
			conditionParam.put("statusList",
					StringUtil.getListFromStr("2,3"));
		}
		List<WithdrawalOrder> list = withdrawalOrderService.selectAll(conditionParam);
		if(list != null && list.size() > 0){
			try {
				response.setContentType("application/binary;charset=ISO8859_1");
				// 生成提示信息，
				response.setContentType("application/vnd.ms-excel");
				String codedFileName = null;
				OutputStream fOut = null;
				// 进行转码，使其支持中文文件名
				codedFileName = "提款订单报表";
				codedFileName = new String(codedFileName.getBytes("gbk"), "iso-8859-1");
				response.setHeader("content-disposition", "attachment;filename=" + codedFileName + DateUtil.format(new Date(), "yyyy-MM-dd") + ".xls");
				//设置TAB名称
				HSSFWorkbook wb = new HSSFWorkbook();
				HSSFSheet sheet = wb.createSheet("提款记录");
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
				cell.setCellValue("提款记录");
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
				cell2.setCellValue("提款编号");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(1);
				cell2.setCellValue("会员账号");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(2);
				cell2.setCellValue("提款银行");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(3);
				cell2.setCellValue("提款金额");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(4);
				cell2.setCellValue("手续费");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(5);
				cell2.setCellValue("提款银行卡号");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(6);
				cell2.setCellValue("提交订单的时间");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(7);
				cell2.setCellValue("风控操作时间");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(8);
				cell2.setCellValue("财务操作时间");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(9);
				cell2.setCellValue("结果");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(10);
				cell2.setCellValue("操作人（风控）");
				cell2.setCellStyle(style2);
				cell2 = row2.createCell(11);
				cell2.setCellValue("操作人（财务）");
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
					WithdrawalOrder withdrawalOrder = list.get(i);
					// 设置单元格值
					HSSFCell hssfCell = row3.createCell(0);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(withdrawalOrder.getOrderNo());
					
					hssfCell = row3.createCell(1);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(withdrawalOrder.getLoginName());
					
					hssfCell = row3.createCell(2);
					hssfCell.setCellStyle(style3);
					if(withdrawalOrder.getToBankType()!=null){
						hssfCell.setCellValue(String.valueOf(map.get(String.valueOf(withdrawalOrder.getToBankType()))));
					}else{
						hssfCell.setCellValue("");
					}
					
					hssfCell = row3.createCell(3);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(withdrawalOrder.getTradeAmount().doubleValue());
					
					hssfCell = row3.createCell(4);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(withdrawalOrder.getPoundage() != null ? withdrawalOrder.getPoundage().doubleValue() : 0);
					
					hssfCell = row3.createCell(5);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(withdrawalOrder.getFromBankCard());
					
					hssfCell = row3.createCell(6);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(withdrawalOrder.getCreateTime()));
					
					hssfCell = row3.createCell(7);
					hssfCell.setCellStyle(style3);
					if(withdrawalOrder.getRiskTime()!=null){
						hssfCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(withdrawalOrder.getRiskTime()));
					}else{
						hssfCell.setCellValue("");
					}
					
					
					hssfCell = row3.createCell(8);
					hssfCell.setCellStyle(style3);
					if(withdrawalOrder.getFinanceTime()!=null){
						hssfCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(withdrawalOrder.getFinanceTime()));
					}else{
						hssfCell.setCellValue("");
					}
					
					hssfCell = row3.createCell(9);
					hssfCell.setCellStyle(style3);
					if (withdrawalOrder.getStatus() == 2) {
						hssfCell.setCellValue("成功");
					} else {
						hssfCell.setCellValue("失败");
					}
					
					hssfCell = row3.createCell(10);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(withdrawalOrder.getRiskUserName());
					
					hssfCell = row3.createCell(11);
					hssfCell.setCellStyle(style3);
					hssfCell.setCellValue(withdrawalOrder.getFinanceUserName());
					
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
	
	/**
	 * 查询提款复制的数据
	 * @param model
	 * @param withdrawalOrderForm
	 * @param request
	 */
	@RequestMapping("/showDepositOrderCopy")
	public String showDepositOrderCopy(Model model,
			WithdrawalOrderForm withdrawalOrderForm, HttpServletRequest request) {
		try {
			WithdrawalOrder withdrawalOrder = withdrawalOrderService
					.selectById(Long.valueOf(withdrawalOrderForm.getId()));
			model.addAttribute("dto", withdrawalOrder);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			logger.error("---fill---:" + e.fillInStackTrace());
			logger.error("---msg---:" + e.getMessage());
			logger.error("---e---:" + e.toString());
		}
		return "xjw/order/withdraw/withdrawOrderCopy";
	}
	
}