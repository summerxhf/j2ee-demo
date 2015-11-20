import java.lang.annotation.*;

/**
 * Description:注解方式定义
 * Created  2015/11/18 18:29  by xinghaifang
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface testComment {
    boolean value() default true;
}
