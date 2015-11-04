import java.util.Calendar;

/**
 * Description:
 * Created  2015/11/2 23:26  by xinghaifang
 */
public class DateTest {
    public static void main(String[] args) {
        Calendar time=Calendar.getInstance();
        time.set(Calendar.YEAR,2015);
        time.set(Calendar.MONTH,Calendar.OCTOBER);
        time.set(Calendar.DAY_OF_MONTH,29);

        System.out.println(time.getTime().getTime());

    }
}
