package annotation.p625;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
//如果注解可以应用于所有类型，那么此注解可以省去
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
    //通过此元素为处理器创建表数据库提供名字
}
