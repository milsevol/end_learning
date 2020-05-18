package com.vonzhou.springinaction.cuitest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SingerLogRound {

    @Around("execution( * com.vonzhou.springinaction.cuitest.Singer.sing(*))")
    public void singAspect(ProceedingJoinPoint point){
        try{
            System.out.println("round---singBefore---");
            point.proceed();
            System.out.println("round---singAfter---");
        }catch (Throwable e){

        }
    }


}
