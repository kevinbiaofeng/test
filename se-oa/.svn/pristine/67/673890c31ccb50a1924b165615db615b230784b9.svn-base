package com.xjw.support.spring.conver;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class DateConvert implements Converter<String, Date> {
    private Logger logger = LoggerFactory.getLogger(DateConvert.class);

    @Override
    public Date convert(String stringDate) {
        try {
            return DateUtils.parseDate(stringDate, "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");
        } catch(ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
