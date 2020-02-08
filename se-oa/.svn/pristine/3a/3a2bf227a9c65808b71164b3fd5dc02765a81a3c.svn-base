package com.xjw.service.mail;

import com.xjw.entity.po.Email;

public interface MailService {
    
    /** 异步发送邮件 */
    public void sendMailByAsync(Email email);
    
    /** 同步发送邮件 */
    public void sendMailBySync(Email email);

    /**
     * 根据模板异步发送邮件
     * Email.content    模板名
     * model            freemarker模板的参数
     */
    public void sendMailByFreemarker(Email email, Object model);
}
