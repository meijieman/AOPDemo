package com.hongfans.libaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;

/**
 * 作者:meijie
 * 包名:com.hongfans.libaop.aspect
 * 工程名:AOPDemo
 * 时间:2018/7/20 17:15
 * 说明:
 */
@Aspect
public class LogAspect{

    @Pointcut("execution(@com.hongfans.libaop.annotation.Around * *(..))")
    public void methodAround(){}

    @Pointcut("execution(@com.hongfans.libaop.annotation.Ret * *(..))")
    public void methodRet(){}

    @Around("methodAround()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getName();
        String methodName = methodSignature.getName();


        Object[] paramValues = joinPoint.getArgs(); // 参数值
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames(); // 参数名
        System.out.println("==## 执行目标方法前 " + className + "#" + methodName + ", params " + Arrays.toString(paramValues) + ", line " + joinPoint.getSourceLocation().getLine());
        // 方法前
        Object result = joinPoint.proceed();
        // 方法后
        System.out.println("==## 执行目标方法后 " );

        return result;
    }

    @AfterReturning(pointcut="methodRet()", returning="returnValue")
    public void log(JoinPoint point, Object returnValue) {
        System.out.println("returnValue " + returnValue);

    }

}
