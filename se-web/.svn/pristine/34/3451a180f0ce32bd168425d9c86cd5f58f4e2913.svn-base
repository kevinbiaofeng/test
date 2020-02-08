package com.xjw.service.mail.impl;

import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.xjw.entity.po.Email;
import com.xjw.service.mail.MailService;
import com.xjw.utility.StringUtil;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class MailServiceImpl implements MailService {
    private static Logger logger= LoggerFactory.getLogger(MailServiceImpl.class.getName());
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    
    private final String mailFrom = "admin@xinhat.com";
    
    public void sendMailByAsync(final Email email) {
        new Thread(new Runnable() {
            public void run() {
                sendMailBySync(email);
            }
        }).start();
    }
    
    public void sendMailBySync(Email email){
        try{
            String from = (StringUtil.isNotBlank(email.getFrom()) ? email.getFrom() : mailFrom);
            
            MimeMessage mime = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mime, true, "utf-8");
            helper.setFrom(from);
            helper.setReplyTo(from); //回复到
            helper.setTo(email.getTo()); //收件人
            helper.setSubject(email.getSubject()); //邮件主题
            helper.setText(email.getContent(), true); //true表示设定html格式
            mailSender.send(mime);
        }catch(Exception e){
            logger.error("发送邮件失败");
            logger.error(e.getMessage(), e);
        }
    }

    public void sendMailByFreemarker(Email email, Object model) {
        String freemarkerName = email.getContent();
        
        try {
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate(freemarkerName);
            String freemarkerHtml = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            
            email.setContent(freemarkerHtml);
            this.sendMailByAsync(email);
        } catch (IOException e) {
            logger.error("读取FreeMarker模板错误, [{}]", email.getContent());
            logger.error(e.getMessage(), e);
        } catch (TemplateException e) {
            logger.error("解析FreeMarker模板错误, [{}]", email.getContent());
            logger.error(e.getMessage(), e);
        }
    }
}
