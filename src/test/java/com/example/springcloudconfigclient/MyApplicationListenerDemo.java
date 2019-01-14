package com.example.springcloudconfigclient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplicationListenerDemo {
    public static void main(String[] args) {
        //annotation 驱动的spring 上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册监听器
        context.addApplicationListener(new ApplicationListener<MyApplicationEvent>() {
            @Override
            public void onApplicationEvent(MyApplicationEvent applicationEvent) {
                System.out.println("接收到的对象"+applicationEvent.getSource()+"@@"+applicationEvent.getApplicationContext());
            }
        });
        //发布事件
        context.refresh();
        context.publishEvent(new MyApplicationEvent(context,"Hello Word"));
        context.publishEvent(new MyApplicationEvent(context,"0000Hello Word"));
        //监听器得到的事件
        //
    }

    public static class MyApplicationEvent extends ApplicationEvent{

        private final ApplicationContext applicationContext;

        public MyApplicationEvent(ApplicationContext applicationContext,Object source) {
            super(source);
            this.applicationContext = applicationContext;
        }

        public ApplicationContext getApplicationContext() {
            return applicationContext;
        }
    }
}
