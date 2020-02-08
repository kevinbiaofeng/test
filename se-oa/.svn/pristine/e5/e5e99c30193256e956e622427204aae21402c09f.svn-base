package com.xjw.kzenum;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
public class AbstractEnum
{
    
    public static class EnumBean
    {
        private String code;
        
        private String name;
        
        public String getCode()
        {
            return code;
        }
        
        public void setCode(String code)
        {
            this.code = code;
        }
        
        public String getName()
        {
            return name;
        }
        
        public void setName(String name)
        {
            this.name = name;
        }
        
        public EnumBean(String key, String value)
        {
            this.code = key;
            this.name = value;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof EnumBean )) 
                return false ;
            
            return this.getCode().equals(((EnumBean)obj).getCode());
        }
        
    }
    
    public static List<EnumBean> getEnumBeans(Class clazz)
    {
        try
        {
            List<EnumBean> list = new LinkedList<EnumBean>();
            Field[] fs = clazz.getDeclaredFields();
            for(Field f : fs)
            {
                if(f.getType().equals(EnumBean.class))
                {
                    EnumBean obj = (EnumBean) f.get(f.getName());
                    list.add(obj);
                }
            }
            return list;
        }
        catch(SecurityException e)
        {
            e.printStackTrace();
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String getNameByCode(Class clazz, String code)
    {
        List<EnumBean> list = getEnumBeans(clazz);
        for(EnumBean eb : list)
        {
            if(eb.getCode().equals(code))
            {
                return eb.getName();
            }
        }
        return null;
    }
    
    
    public static EnumBean getEnumByCode(Class clazz, String code)
    {
        List<EnumBean> list = getEnumBeans(clazz);
        for(EnumBean eb : list)
        {
            if(eb.getCode().equals(code))
            {
                return eb;
            }
        }
        return null;
    }
    
}
