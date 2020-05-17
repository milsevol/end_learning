package com.vonzhou.springinaction.cuitest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectJavaMain01 {

    public static void main(String[] args) {
        AspectJavaMain01.test02();
    }

   /**  步骤：1.编写关注点类SingerImp,添加注解@Component
     *       2.编写切面类SingerLog,添加注解@Component,添加注解Aspect表明该类是一个切面类
     *       3.编写AspectJavaConfig
     **/
    public static void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectJavaConfig.class);
        //  Singer singer = (Singer) context.getBean(Singer.Class); //这样会报错
        Singer singer = (Singer) context.getBean("singerImp");
        singer.sing("正在唱歌");
    }

    /**
     * 打印参数
     */
    public static void test02(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectJavaConfig.class);
        Singer singerParam = (Singer) context.getBean("singerParam");
        singerParam.sing("正在唱歌");
    }
}
