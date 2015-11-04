
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Created  2015/11/3 14:08  by xinghaifang
 */
public class DateTool {
    private static final long serialVersionUID = -7256536909247927079L;
    private static final String DEFAULT_DATE_PATTERN = "yyyyMMddHHmmss";
//    protected final org.apache.commons.logging.Log logger = LogFactory.getLog(this.getClass());
    private static final Object lockObj = new Object();
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap();

    public DateTool() {
    }

    public static String formatDateToString(Date date, String pattern) {
        try {
            SimpleDateFormat e;
            if(null != pattern && !"".equals(pattern)) {
                e = new SimpleDateFormat(pattern);
            } else {
                e = new SimpleDateFormat("yyyyMMddHHmmss");
            }

            return e.format(date);
        } catch (Exception var3) {
//            logger.error(LOGGER, var3, "DateTool.formatDateToString发生异常，参数{0},{1}", new Object[]{date, pattern});
            return "";
        }
    }

    public static String format(Date date, String formatPattern) {
        try {
            return getSdf(formatPattern).format(date);
        } catch (Exception var3) {
//            LogUtil.error(LOGGER, var3, "格式化时间字符串发生异常!date={0},formatPattern={1}", new Object[]{date, formatPattern});
            return "";
        }
    }

    public static Date parse(String dateString, String formatPattern) {
        try {
            return getSdf(formatPattern).parse(dateString);
        } catch (Exception var3) {
//            LogUtil.error(LOGGER, var3, "DateUtils.getDateStrToDate(String formatPattern)格式化时间字符串发生异常!formatPattern={0},dateString={1}", new Object[]{formatPattern, dateString});
            return null;
        }
    }

    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal tl = (ThreadLocal)sdfMap.get(pattern);
        if(null == tl) {
            Object var2 = lockObj;
            synchronized(lockObj) {
                tl = (ThreadLocal)sdfMap.get(pattern);
                if(null == tl) {
                    tl = new ThreadLocal() {
                        protected SimpleDateFormat initialValue() {
                            return StringUtils.isNotEmpty(pattern)?new SimpleDateFormat(pattern):new SimpleDateFormat("yyyyMMddHHmmss");
                        }
                    };
                }
            }
        }

        return (SimpleDateFormat)tl.get();
    }

    public static Date getDateAfterDaysByFormat(Date date, int days, String format) {
        if(date == null) {
            return null;
        } else {
            Date currentDate = parse(format(date, format), format);
            return new Date(currentDate.getTime() + (long)days * 86400000L);
        }
    }

    public static Date getDateAfterDays(Date date, int days) {
        return getDateAfterDaysByFormat(date, days, "yyyy-MM-dd");
    }

    public static Date getDateAfterHoursByFormat(Date date, int hours, String format) {
        if(date == null) {
            return null;
        } else {
            Date currentDate = parse(format(date, format), format);
            return new Date(currentDate.getTime() + (long)hours * 3600000L);
        }
    }

    public static Date getDateAfterHours(Date date, int hours) {
        return getDateAfterHoursByFormat(date, hours, "yyyy-MM-dd HH");
    }

    public static void main(String[] args) {
        String beginTime = format(getDateAfterHours(new Date(), -2), "yyyyMMddHHmmss");
        System.out.println((getDateAfterHours(new Date(), -2)));
    }
}
