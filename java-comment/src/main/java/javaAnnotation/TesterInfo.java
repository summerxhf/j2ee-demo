package javaAnnotation;

/**
 * Description:
 * Created  2015/11/18 18:46  by xinghaifang
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //on class level
public @interface TesterInfo {

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    Priority priority() default Priority.MEDIUM;

    String[] tags() default "";

    String createdBy() default "xinghaifang";

    String lastModified() default "2015年11月18日18:47:23";

}
