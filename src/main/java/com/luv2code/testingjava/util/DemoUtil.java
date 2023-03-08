package com.luv2code.testingjava.util;

public class DemoUtil {

    public Integer add(Integer a, Integer b){
        return a + b;
    }

    public Object checkNull(Object o){
        if (o != null) {
            return o;
        }
        return null;
    }

    public String getAcademyName(){
        return "luv2code";
    }

    public Boolean isGreater(Integer a, Integer b){
        return a > b;
    }

}
