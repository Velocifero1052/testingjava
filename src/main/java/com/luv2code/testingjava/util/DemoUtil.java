package com.luv2code.testingjava.util;

import java.util.List;

public class DemoUtil {

    private final String academyName = "luv2code";
    private final String[] array = new String[]{"A", "B", "C"};
    private final List<String> iterableObject = List.of("luv", "2", "code");

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
        return academyName;
    }

    public String getAcademyNameDuplicate(){
        return getAcademyName();
    }

    public Boolean isGreater(Integer a, Integer b){
        return a > b;
    }

    public String[] getFirstThreeLettersOfAlphabet(){
        return array;
    }

    public List<String> returnIterable(){
        return iterableObject;
    }

    public void throwOnNegative(int a) throws Exception{
        if(a < 0){
            throw new Exception("OMFG! Number is negative");
        }
    }

    public void checkTimeout() throws InterruptedException {
        System.out.println("thread is going to sleep");
        Thread.sleep(2000);
        System.out.println("thread sleeping period is ended");
    }

    public Integer multiply(Integer a, Integer b){
        return a * b;
    }

}
