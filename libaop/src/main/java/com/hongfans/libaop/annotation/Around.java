package com.hongfans.libaop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者:meijie
 * 包名:com.hongfans.libaop.annotation
 * 工程名:AOPDemo
 * 时间:2018/7/20 17:10
 * 说明: 方法执行前后，获取入参，方法名，方法位置
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface Around{

    String value() default "";
}
