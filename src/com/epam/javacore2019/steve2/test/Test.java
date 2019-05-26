package com.epam.javacore2019.steve2.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)     //инструкция что делать с этой аннотацией - забрось на рантайм и используй
@Target(ElementType.METHOD)                // используй к классам
public @interface Test {
boolean enabled() default true;
}
