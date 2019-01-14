package com.example.springcloudconfigclient;


import java.util.*;

public class ObservableDemo {
    public static void main(String[] args) {


        MyObservable observable = new MyObservable();
        //订阅者
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg);
            }
        });
        observable.setChanged();
        // 发布者通知， 订阅者是被动感知（推模式）
        observable.notifyObservers("我要发布了");

        echoIterator();
    }

    public static void echoIterator(){
        List<Integer>  values = Arrays.asList(1,2,3,4,5);
        Iterator<Integer> integerIterable =  values.iterator();
        while (integerIterable.hasNext()){//通过循环主动获取
            System.out.println(integerIterable.next());
        }
    }

    public static class MyObservable extends Observable{

        //线程安全不安全看这个对象被连续使用的情况
        public void setChanged(){
            super.setChanged();
        }
    }
}
