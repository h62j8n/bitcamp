package com.bit.mvc03.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface MyAnnotation {
	String value() default "java";
}
