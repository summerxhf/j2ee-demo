import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:linux时间戳转换
 * Created  2016/4/12 13:25  by xinghaifang
 */
public class linuxLongTime {


    public static void main(String[] args) {
        //当前日期时间戳.
//        System.out.println("当前时间戳"+ System.currentTimeMillis());

        //时间戳转化为日期.
        String beginDate="1460023968000";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(beginDate)));
        System.out.println("该时间戳-- "+ beginDate +"  的日期为--"+ sd);

    }
}
