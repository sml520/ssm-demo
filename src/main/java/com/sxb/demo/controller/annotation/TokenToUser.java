package com.sxb.demo.controller.annotation;


import java.lang.annotation.*;

/**
 * Created by 张元亮 on 2018/9/6.
 */

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenToUser {
    /**
     * 当前用户在request中的名字
     */
    String value() default "user";
}
