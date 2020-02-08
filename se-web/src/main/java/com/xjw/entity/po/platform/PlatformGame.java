package com.xjw.entity.po.platform;

import com.xjw.base.entity.BasePo;

/**
 * 平台游戏
 */
public class PlatformGame extends BasePo {
    private static final long serialVersionUID = -4456336383772970362L;

    /** 中文名 */
    private String zhName;
    /** 英文名 */
    private String enName;
    /** flash游戏代码 */
    private String flashCode;
    /** flash游戏显示标记 1:是 2:否 */
    private Integer flashFlag;
    /** h5游戏代码 */
    private String h5Code;
    /** h5游戏显示 标记 1:是 2:否 */
    private Integer h5Flag;
    /** 图片路径 */
    private String imagePath;
    /** 平台类型 */
    private Integer platformType;
    /** 游戏类型 */
    private Integer gameType;
    /** 游戏标签 */
    private String gameLabel;
    /** 新款游戏 1:是 2:否 */
    private Integer newFlag;
    /** 热门游戏 1:是 2:否 */
    private Integer hotFlag;
    /** 备注 */
    private String remark;

    public String getZhName() {
        return zhName;
    }

    public void setZhName(String zhName) {
        this.zhName = zhName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getFlashCode() {
        return flashCode;
    }

    public void setFlashCode(String flashCode) {
        this.flashCode = flashCode;
    }

    public Integer getFlashFlag() {
        return flashFlag;
    }

    public void setFlashFlag(Integer flashFlag) {
        this.flashFlag = flashFlag;
    }

    public String getH5Code() {
        return h5Code;
    }

    public void setH5Code(String h5Code) {
        this.h5Code = h5Code;
    }

    public Integer getH5Flag() {
        return h5Flag;
    }

    public void setH5Flag(Integer h5Flag) {
        this.h5Flag = h5Flag;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getPlatformType() {
        return platformType;
    }

    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }

    public String getGameLabel() {
        return gameLabel;
    }

    public void setGameLabel(String gameLabel) {
        this.gameLabel = gameLabel;
    }

    public Integer getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(Integer newFlag) {
        this.newFlag = newFlag;
    }

    public Integer getHotFlag() {
        return hotFlag;
    }

    public void setHotFlag(Integer hotFlag) {
        this.hotFlag = hotFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
