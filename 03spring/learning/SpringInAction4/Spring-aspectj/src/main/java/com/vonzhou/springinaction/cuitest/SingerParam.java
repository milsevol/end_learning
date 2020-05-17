package com.vonzhou.springinaction.cuitest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SingerParam implements Singer{

    public String sing(String m1) {
        System.out.println(m1);
        return "test";
    }
}
