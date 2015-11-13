import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Description:
 * Created  2015/11/2 23:26  by xinghaifang
 */
public class DateTest {
    public static void main(String[] args) throws Exception{
        Calendar time=Calendar.getInstance();
        time.set(Calendar.YEAR,2015);
        time.set(Calendar.MONTH,Calendar.OCTOBER);
        time.set(Calendar.DAY_OF_MONTH,29);

        System.out.println(time.getTime().getTime());


        Date d =new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dd =format.format(d);
        Date ddd =format.parse(dd);
        System.out.println("日期"+ddd);


        String strDate = "2015-11-04";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        System.out.println("日期date"+strtodate);


        Date currentTime = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter1.format(currentTime);
        ParsePosition pos1 = new ParsePosition(8);
        Date currentTime_2 = formatter1.parse(dateString, pos1);
        System.out.println("日期date currentTiem--"+currentTime_2);

    }
}
