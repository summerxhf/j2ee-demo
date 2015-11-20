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
@Target(ElementType.METHOD) //can use in method only.
public @interface Test {

    //should ignore this test?
    public boolean enabled() default true;

}
