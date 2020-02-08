package com.xjw.entity.po.platform;

import com.xjw.base.entity.BasePo;

public class UserPlatformAccount extends BasePo {
    private static final long serialVersionUID = 1L;
    /** 用户ID */
    private Long userId;
    /** 用户账号 */
    private String loginName;
    /** 游戏平台类型 */
    private Integer platformType;
    /** 玩家账号 */
    private String playerName;
    /** 玩家密码 */
    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getPlatformType() {
        return platformType;
    }

    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}