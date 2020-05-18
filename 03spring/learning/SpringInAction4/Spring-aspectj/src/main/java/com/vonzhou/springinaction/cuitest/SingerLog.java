package com.vonzhou.springinaction.cuitest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SingerLog {

    @Before("execution( * com.vonzhou.springinaction.cuitest.SingerParam.sing(*))")
    public void singBefore(JoinPoint point){
        System.out.println("---singBefore---");
    }


}
