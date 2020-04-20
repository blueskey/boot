package com.my.log;

import java.lang.annotation.*;

/**
 * @author ju
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {

    String module() default "";

    String operator() default "";

}
