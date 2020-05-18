package com.vonzhou.springinaction.cuitest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SingerLogParam {

    @Before("execution( * com.vonzhou.springinaction.cuitest.SingerParam.sing(*))")
    public void singAspect(JoinPoint point){
        System.out.println("---SingerLogParam---");
        Signature signature = point.getSignature();
        String methodName = signature.getName();
        Object[] args = point.getArgs();
        System.out.println("SingerLogParam:"+methodName);

    }


}
