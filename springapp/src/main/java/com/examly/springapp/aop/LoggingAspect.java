
package com.examly.springapp.aop;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.AfterReturning;

import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Aspect

@Component

public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.examly.springapp.service.*.*(..))")

    public void logBefore(JoinPoint joinPoint) {

        logger.info("Entering method: " + joinPoint.getSignature().getName());

        logger.info("Arguments: " + java.util.Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(pointcut = "execution(* com.examly.springapp.service.*.*(..))", returning = "result")

    public void logAfter(JoinPoint joinPoint, Object result) {

        logger.info("Exiting method: " + joinPoint.getSignature().getName());

        if (result != null) {

            logger.info("Return value: " + result.toString());

        }

    }

}

