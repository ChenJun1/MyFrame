package com.frame.chenj.myframe.mode;

/**
 * Created by ${ChenJ} on 2016/8/30.
 */
public class Studends {
    private  volatile  static Studends studends;
    private Studends(){};

    public static Studends getInstance(){
        if(studends==null){
            synchronized (Studends.class){
                if (studends == null) {
                    studends=new Studends();
                }
            }
        }
        return studends;
    }
}
