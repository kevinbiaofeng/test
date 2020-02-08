package com.xjw.utility;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	/**
	 * 格式化byte
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] out = new char[b.length * 2];
		for (int i = 0; i < b.length; i++) {
			byte c = b[i];
			out[i * 2] = digit[(c >>> 4) & 0X0F];
			out[i * 2 + 1] = digit[c & 0X0F];
		}

		return new String(out);
	}
	
    public static boolean isBlank(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotBlank(String str) {
        if (str != null && !"".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    public static String trim(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        for (int i = 0; i < str.length(); i++) {
            int tmp = str.charAt(i);
            if (tmp == 9 || tmp == 13 || tmp == 10 || tmp == 32 || tmp == 12288) {
                continue;
            } else {
                str = str.substring(i);
                break;
            }
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            int tmp = str.charAt(i);
            if (tmp == 9 || tmp == 13 || tmp == 10 || tmp == 32 || tmp == 12288) {
                continue;
            } else {
                str = str.substring(0, i + 1);
                break;
            }
        }
        return str;
    }

    public static String return2Br(String arg) {
        if (arg == null || "".equals(arg)) {
            return "";
        } else {
            arg = arg.replaceAll("\r\n", "<br/>");
            arg = arg.replaceAll("\n", "<br/>");
            return arg;
        }
    }

    public static String br2Return(String arg) {
        if (arg == null || "".equals(arg)) {
            return "";
        } else {
            arg = arg.replaceAll("<br>", "\r\n");
            arg = arg.replaceAll("<br/>", "\r\n");
            return arg;
        }
    }

    public static String whiteSpace2nbsp(String arg) {
        if (arg == null || "".equals(arg)) {
            return "";
        } else {
            arg = arg.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
            arg = arg.replaceAll(" ", "&nbsp;");
            return arg;
        }
    }

    public static String format(float d, int scale) {
        return format(new Double(d), scale);
    }

    public static String format(double d, int scale) {
        StringBuffer sb = new StringBuffer("0");
        if (scale > 0) {
            sb.append(".");
        }
        for (int i = 0; i < scale; i++) {
            sb.append("0");
        }
        DecimalFormat df = new DecimalFormat(sb.toString());
        return df.format(d);
    }

    public static String supplyChar(String str, int len, char c) {
        String ret = str;
        if (ret != null && !"".equals(ret)) {
            for (int i = 0; i < len - str.length(); i++) {
                ret = c + ret;
            }
        }
        return ret;
    }

    public static String supply8Zero(Object str) {
        return supplyChar(String.valueOf(str), 8, '0');
    }

    public static String supply8Zero(String str) {
        return supplyChar(str, 8, '0');
    }

    public static String supply8Zero(Integer str) {
        if (str != null) {
            return supplyChar(String.valueOf(str), 8, '0');
        } else {
            return null;
        }
    }

    public static String supply8Zero(int str) {
        return supplyChar(String.valueOf(str), 8, '0');
    }

    public static String highlight(String text, String target) {
        if (text == null) {
            return null;
        }
        if (target == null || "".equals(target)) {
            return text;
        }
        StringBuffer sb = new StringBuffer();
        target = target.toLowerCase();
        int len = target.length();
        for (int i = 0; i < text.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < target.length(); j++) {
                if (i + j >= text.length()) {
                    flag = true;
                    break;
                }
                if (Character.toLowerCase(text.charAt(i + j)) != target.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                sb.append(text.charAt(i));
            } else {
                sb.append("<font color='red'>");
                sb.append(text.substring(i, i + len));
                sb.append("</font>");
                i = i + len - 1;
            }
        }
        return sb.toString();
    }

    public static String delSpace(String str) {
        if (str == null) {
            return null;
        }
        str = str.trim();
        StringBuffer tmp = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isSpaceChar(str.charAt(i)) && str.charAt(i) != '\t') {
                tmp.append(str.charAt(i));
            }

        }
        return tmp.toString();
    }

    public static String filterDollarStr(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        String sReturn = "";

        if (str.indexOf('$', 0) > -1) {
            while (str.length() > 0) {
                if (str.indexOf('$', 0) > -1) {
                    sReturn += str.subSequence(0, str.indexOf('$', 0));
                    sReturn += "\\$";
                    str = str.substring(str.indexOf('$', 0) + 1, str.length());
                } else {
                    sReturn += str;
                    str = "";
                }
            }
        } else {

            sReturn = str;
        }

        return sReturn;

    }

    public static String escape(String src) {
        if (src == null) {
            return src;
        }
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length() * 6);
        for (i = 0; i < src.length(); i++) {
            j = src.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))
                tmp.append(j);
            else if (j < 256) {
                tmp.append("%");
                if (j < 16)
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }

    public static String unescape(String src) {
        if (src == null) {
            return null;
        }
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length());
        int lastPos = 0, pos = 0;
        char ch;
        while (lastPos < src.length()) {
            pos = src.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (src.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    tmp.append(src.substring(lastPos));
                    lastPos = src.length();
                } else {
                    tmp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }

    public static String native2ascii(String str) {
        String tmp;
        StringBuffer sb = new StringBuffer();
        char c;
        int i, j;
        sb.setLength(0);
        for (i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c > 255) {
                sb.append("\\u");
                j = (c >>> 8);
                tmp = Integer.toHexString(j);
                if (tmp.length() == 1) {
                    sb.append("0");
                }
                sb.append(tmp);
                j = (c & 0xFF);
                tmp = Integer.toHexString(j);
                if (tmp.length() == 1) {
                    sb.append("0");
                }
                sb.append(tmp);
            } else {
                sb.append(c);
            }

        }
        return sb.toString();
    }

    public static String native2ascii(char c) {
        String tmp;
        StringBuffer sb = new StringBuffer();

        if (c > 255) {
            sb.append("\\u");

            int j = (c >>> 8);
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
            j = (c & 0xFF);
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
        } else {
            sb.append(c);
        }

        return sb.toString();
    }

    public static String getLine(String context, int lineNum) {
        String tmp = context.trim();
        int start = 0;
        int end = tmp.indexOf("\r\n", start);
        int cnt = 0;
        while (end >= 0) {
            String line = tmp.substring(start, end).trim();
            if (line != null && !"".equals(line)) {
                cnt++;
            }
            if (cnt == lineNum) {
                return line;
            }
            start = end + 1;

            end = tmp.indexOf("\r\n", start);
        }

        return null;
    }

    public static String omit(String str, int len, String elide) {
        if (str == null) {
            return "";
        }
        try {
            byte[] strByte = str.getBytes("gbk");
            int strLen = strByte.length;
            int elideLen = (elide.trim().length() == 0) ? 0 : elide.getBytes().length;
            if (len >= strLen || len < 1) {
                return str;
            }
            if (len - elideLen > 0) {
                len = len - elideLen;
            }
            int count = 0;
            for (int i = 0; i < len; i++) {
                int value = (int) strByte[i];
                if (value < 0) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                len = (len == 1) ? len + 1 : len - 1;
            }
            return new String(strByte, 0, len, "gbk") + elide.trim();
        } catch (Throwable e) {
            return str;
        }

    }

    public static String initCap(String str) {
        if (str != null && str.length() > 0) {
            str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
        return str;
    }

    public static void main(String[] args) {
        double d = 19921.1029917125;
        System.out.println(StringUtil.format(d, 3));

    }

    /**
     * 把数组array中间使用separator分隔符拼成一个字符串
     * 
     * @author fengpeng May 17, 2011 10:19:41 AM
     * @param array 数组
     * @param separator 分隔符
     * @return
     */
    public static String array2str(String[] array, String separator) {
        if (array == null || array.length <= 0) {
            return "";
        }
        if (separator == null || "".equals(separator)) {
            return "";
        }

        String ret = "";
        separator = separator.trim();
        for (int i = 0; i < array.length; i++) {
            ret = ret + separator + array[i].trim();
        }
        if (ret.startsWith(separator)) {
            ret = ret.substring(1);
        }
        if (ret.endsWith(separator)) {
            ret = ret.substring(0, ret.length() - 1);
        }

        return ret;
    }

    /**
     * 通过邮箱获得域名
     * 
     * @author fengpeng May 5, 2011 2:54:54 PM
     * @return
     */
    public static String getDomainName(String email) {
        if (email == null || "".equals(email) || email.indexOf("@") < 0) {
            return "";
        }
        String emailSuffix = email.substring(email.indexOf("@") + 1).trim();

        String domainName = "";
        if ("163.com".equals(emailSuffix)) {
            domainName = "mail.163.com";
        } else if ("126.com".equals(emailSuffix)) {
            domainName = "mail.126.com";
        } else if ("yeah.net".equals(emailSuffix)) {
            domainName = "mail.yeah.net";
        } else if ("gmail.com".equals(emailSuffix)) {
            domainName = "www.gmail.com";
        } else if ("10086.com".equals(emailSuffix)) {
            domainName = "mail.10086.cn";
        } else if ("139.com".equals(emailSuffix)) {
            domainName = "mail.10086.cn";
        } else if ("yahoo.com.cn".equals(emailSuffix)) {
            domainName = "mail.yahoo.cn";
        } else if ("yahoo.cn".equals(emailSuffix)) {
            domainName = "mail.yahoo.cn";
        } else if ("yahoo.com".equals(emailSuffix)) {
            domainName = "mail.yahoo.com";
        } else if ("foxmail.com".equals(emailSuffix)) {
            domainName = "www.foxmail.com";
        } else if ("sohu.com".equals(emailSuffix)) {
            domainName = "mail.sohu.com";
        } else if ("vip.sohu.com".equals(emailSuffix)) {
            domainName = "vip.sohu.com";
        } else if ("sina.com".equals(emailSuffix)) {
            domainName = "mail.sina.com.cn";
        } else if ("vip.sina.com".equals(emailSuffix)) {
            domainName = "mail.sina.com.cn";
        } else if ("eyou.com".equals(emailSuffix)) {
            domainName = "www.eyou.com";
        } else if ("vip.eyou.com".equals(emailSuffix)) {
            domainName = "vip.eyou.com";
        } else if ("wo.com.cn".equals(emailSuffix)) {
            domainName = "mail.wo.com.cn";
        } else if ("tom.com".equals(emailSuffix)) {
            domainName = "mail.tom.com";
        } else if ("hotmail.com".equals(emailSuffix)) {
            domainName = "login.live.com";
        } else if ("live.cn".equals(emailSuffix)) {
            domainName = "login.live.com";
        } else if ("live.com".equals(emailSuffix)) {
            domainName = "login.live.com";
        } else if ("msn.com".equals(emailSuffix)) {
            domainName = "login.live.com";
        } else if ("21.cn".equals(emailSuffix)) {
            domainName = "mail.21cn.com";
        } else if ("263.net".equals(emailSuffix)) {
            domainName = "www.263.net";
        } else if ("263.net.cn".equals(emailSuffix)) {
            domainName = "www.263.net";
        } else if ("x263.net".equals(emailSuffix)) {
            domainName = "www.263.net";
        } else if ("sogou.com".equals(emailSuffix)) {
            domainName = "mail.sogou.com";
        } else if ("189.cn".equals(emailSuffix)) {
            domainName = "www.189.cn";
        } else if ("188.com".equals(emailSuffix)) {
            domainName = "www.188.com";
        } else if ("vip.188.com".equals(emailSuffix)) {
            domainName = "www.188.com";
        }
        if (!"".equals(domainName) && !domainName.startsWith("http://")) {
            domainName = "http://" + domainName;
        }
        return domainName;
    }

    /**
     * 处理特殊字符的显示 < &lt; > &gt; & &amp; " &quot; 处理页面脚本显示
     */
    public static String FilterSpecialCharacter(String content) {
        if (content == null || "".equals(content)) {
            return content;
        }
        // <
        Pattern pattern1 = Pattern.compile("<");
        Matcher matcher1 = pattern1.matcher(content);
        content = matcher1.replaceAll("&lt;");
        // >
        Pattern pattern2 = Pattern.compile(">");
        Matcher matcher2 = pattern2.matcher(content);
        content = matcher2.replaceAll("&gt;");
        // &
        Pattern pattern3 = Pattern.compile("&");
        Matcher matcher3 = pattern3.matcher(content);
        content = matcher3.replaceAll("&amp;");
        // "
        Pattern pattern4 = Pattern.compile("\"");
        Matcher matcher4 = pattern4.matcher(content);
        content = matcher4.replaceAll("&quot;");
        return content;
    }

    /**
     * 通过list获得以逗号隔开的字符串
     * 
     * @param list
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String getCollectionStr(List list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder objs = new StringBuilder();
        for (Object obj : list) {
            objs.append(obj).append(",");
        }
        if (objs.length() > 0) {
            objs.deleteCharAt(objs.length() - 1);
        }
        return objs.toString();
    }
    
    /**
     * 通过list获得以逗号隔开的字符串
     * 
     * @param list
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static List getListFromStr(String sss) {
        List list = Arrays.asList(sss.split(","));
        return list;
    }

    /**
     * 通过数组获得以逗号隔开的字符串
     * 
     * @param array
     * @return
     */
    public static String getArrayStr(String array[]) {
        if (array == null || array.length == 0) {
            return null;
        }
        StringBuilder objs = new StringBuilder();
        for (String obj : array) {
            if (!"".equals(obj)) {
                objs.append(obj).append(",");
            }
        }
        if (objs.length() > 0) {
            objs.deleteCharAt(objs.length() - 1);
        }
        return "".equals(objs.toString()) ? null : objs.toString();
    }

    /**
     * 通过数组获得以逗号隔开的字符串
     * 
     * @param array
     * @return
     */
    public static String getArrayStr(Integer array[]) {
        if (array == null || array.length == 0) {
            return null;
        }
        StringBuilder objs = new StringBuilder();
        for (Object obj : array) {
            if (!"".equals(String.valueOf(obj))) {
                objs.append(String.valueOf(obj)).append(",");
            }
        }
        if (objs.length() > 0) {
            objs.deleteCharAt(objs.length() - 1);
        }
        return "".equals(objs.toString()) ? null : objs.toString();
    }

    public static int string2int(String str, int defaultValue) {
        if (str == null || str.trim().length() == 0) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static boolean isNull(String value) {
        return (value == null || value.trim().length() == 0) ? true : false;
    }
    
    public static String replaceContextByMap(String context, Map<String, Object> map){
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
          Map.Entry entry = (Map.Entry) iter.next();
          Object key = entry.getKey();
          Object val = entry.getValue();
          context = context.replace("${" + String.valueOf(key) + "}", String.valueOf(val));
        }
        return context;
    }
    
    public static String replaceContextByMap(BigDecimal money){
    	DecimalFormat df = new DecimalFormat();
    	df.applyPattern("##,##0.00");
    	return df.format(money.doubleValue());
    }
    
    
}
