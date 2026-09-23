package com.revature.demoapp.utils;

import java.util.List;

public class HelperUtil {
    public int doOperation(String op, int a, int b){
        if(op.equals("add")){
            return a + b;
        }else{
            return a - b;
        }
    }

    public int multiply(List<Integer> li){
        int product = 1;
        for(int i : li){
            product *= i;
        }
        return product;
    }

    public int divide(int a, int b){
        return a/b;
    }
}
