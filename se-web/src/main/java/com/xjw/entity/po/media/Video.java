package com.xjw.entity.po.media;

import org.apache.commons.lang3.StringUtils;

import com.spreada.utils.chinese.ZHConverter;
import com.xjw.base.entity.BasePo;
import com.xjw.kzenum.media.VideoTypeEnum;
import com.xjw.kzenum.sys.YesORNoEnum;

/**
 * 视频
 */
public class Video extends BasePo {
	private static final long serialVersionUID = 1948543892161729652L;

	/** 编号 */
	private String code;
	/** 原名 */
	private String originalName;
	/** 图片路径 */
	private String imagePath;
	/** 视频路径 */
	private String path;
	/** 扩展名 */
	private String extension;
	/** 大小(K) */
	private Long size;
	/** 时长(秒) */
	private Integer length;
	/** 标题 */
	private String title;
	/** 类型 {@link VideoTypeEnum} */
	private Integer type;
	/** 主演 */
	private String star;
	/** 关键字 */
	private String keyword;
	/** 收藏总数 */
	private Integer favoriteCount;
	/** 点击次数 */
	private Integer clickCount;
	/** VIP视频 {@link YesORNoEnum} */
	private Integer vipFlag;
	/** 显示状态 {@link YesORNoEnum} */
	private Integer status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getTitle() {
		return ZHConverter.convert(title, ZHConverter.TRADITIONAL);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getKeyword() {
		if(StringUtils.isNotBlank(keyword)) {
			ZHConverter.convert(keyword, ZHConverter.TRADITIONAL);
		}
		
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public Integer getClickCount() {
		return clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	public Integer getVipFlag() {
		return vipFlag;
	}

	public void setVipFlag(Integer vipFlag) {
		this.vipFlag = vipFlag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
