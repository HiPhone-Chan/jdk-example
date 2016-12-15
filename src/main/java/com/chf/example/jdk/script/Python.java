package com.chf.example.jdk.script;

public class Python {

    
    public static void main(String[] args) {
        int value = 3019;
        
        float fValue = (float) value / 100;
        System.out.println(fValue);
        System.out.println((float) Math.round(fValue * 100) / 100);
    }
}
