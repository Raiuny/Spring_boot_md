package com.example.aopstu.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggerAspect {

   @Before("execution(public int com.example.aopstu.Aop.CalImpl.*(..))")
    public void before(JoinPoint joinPoint) {
       String name = joinPoint.getSignature().getName();
       String args = Arrays.toString(joinPoint.getArgs());
       System.out.println(name+"方法的参数"+args);
   }
   @After("execution(public int com.example.aopstu.Aop.CalImpl.*(..))")
   public void after(JoinPoint joinPoint) {
      String name = joinPoint.getSignature().getName();
      System.out.println(name+"方法结束");
   }
}
