package com.tmt.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@Aspect
public class Logging {

    @AfterThrowing(value = "execution(* com.tmt.controller.*.*(..))")
    public void methodeTracker(JoinPoint joinPoint){
        log.info("***** {}", joinPoint);
    }
}
