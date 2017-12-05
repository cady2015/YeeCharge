package com.yeecharge.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//声明该注解需要保留的域---保留到运行时
@Retention(RetentionPolicy.RUNTIME)
//声明要作用的地方----作用在方法上
@Target(ElementType.METHOD)
public @interface Tran {
	
}
