package com.xjw.util;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

public class POIUtil {
	/**
	 * 边框
	 * @param wb
	 * @return
	 */
	public static CellStyle createStyleCell(Workbook wb) {
		CellStyle cellStyle = wb.createCellStyle();
		// 设置一个单元格边框颜色
//		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
//		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
//		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
//		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		// 设置一个单元格边框颜色
		cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		return cellStyle;
	}

	/**
	 * 设置文字在单元格里面的位置 CellStyle.ALIGN_CENTER CellStyle.VERTICAL_CENTER
	 * @param cellStyle
	 * @param halign
	 * @param valign
	 * @return
	 */
	public static CellStyle setCellStyleAlignment(CellStyle cellStyle, short halign, short valign) {
		// 设置上下
//		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		// 设置左右
//		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		return cellStyle;
	}

	/**
	 * 格式化单元格 如#,##0.00,m/d/yy去HSSFDataFormat或XSSFDataFormat里面找
	 * @param cellStyle
	 * @param fmt
	 * @return
	 */
	public static CellStyle setCellFormat(CreationHelper helper, CellStyle cellStyle, String fmt) {
		// 还可以用其它方法创建format
		cellStyle.setDataFormat(helper.createDataFormat().getFormat(fmt));
		return cellStyle;
	}

	/**
	 * 前景和背景填充的着色
	 * @param cellStyle
	 * @param bg IndexedColors.ORANGE.getIndex();
	 * @param fg IndexedColors.ORANGE.getIndex();
	 * @param fp CellStyle.SOLID_FOREGROUND
	 * @return
	 */
	public static CellStyle setFillBackgroundColors(CellStyle cellStyle, short bg, short fg, short fp) {
		cellStyle.setFillForegroundColor(fg);
//		cellStyle.setFillPattern(fp);
		return cellStyle;
	}

	/**
	 * 设置字体
	 * @param wb
	 * @return
	 */
	public static Font createFonts(Workbook wb) {
		// 创建Font对象
		Font font = wb.createFont();
		// 设置字体
		font.setFontName("黑体");
		// 着色
		font.setColor(HSSFColor.BLUE.index);
		// 斜体
		font.setItalic(true);
		// 字体大小
		font.setFontHeight((short) 300);
		return font;
	}
}
