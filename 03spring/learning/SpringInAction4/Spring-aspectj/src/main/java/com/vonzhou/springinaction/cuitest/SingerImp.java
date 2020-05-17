package com.vonzhou.springinaction.cuitest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SingerImp implements Singer{


    public String sing(String m1) {
        System.out.println(m1);
        return "test";
    }
}
