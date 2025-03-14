package com.bookhive.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) 
public @interface RateLimited {
    int limit() default 100; // Maximum number of requests
    int duration() default 1; // Duration in minute
}
   