package com.back;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calc {


    static int run(String s) {
        List<String> numList = new ArrayList<>();
        List<String> signList = new ArrayList<>();
        int cnt =0;



        signList = findSign(s, signList);
        numList = findNum(s);

        int num = sortSign(signList);

        if(num > 0) {
            numList = sortNum(numList, num+1);
        }



        int result = Integer.parseInt(numList.get(cnt));
        numList.remove(cnt);



        result = calc(cnt, numList, signList, result);


        return result;
    }

    private static List<String> sortNum(List<String> numList, int num) {
        String str = numList.get(num);
        String str1 = numList.get(0);
        numList.set(0,str);
        numList.set(num,str1);
        return numList;
    }

    private static int sortSign(List<String> signList) {
        int cnt = 0;

        for (int i = 0; i < signList.size(); i++) {
            if(signList.get(i).equals("*")) {
                cnt = i;
                Collections.sort(signList);
            }
            else {
                cnt = 0;
            }
        }


        return cnt;
    }

    private static int calc(int cnt, List<String> numList, List<String> signList, int result) {

        if(numList.isEmpty()) return result;

        String op = signList.get(cnt);
        int num = Integer.parseInt(numList.get(cnt));

        switch(op) {
            case "+" -> result += num;
            case "-" -> result -= num;
            case "*" -> result *= num;
        }

        numList.remove(cnt);
        signList.remove(cnt);
        return calc(cnt,numList,signList, result);


    }

    private static List<String> findNum(String s) {
        String[] trim = s.split(" "); // [10, *, -10]
        List<String> sortNum = new ArrayList<>();

        for(String x : trim) {
            if(!x.equals("+") && !x.equals("-") && !x.equals("*")) {
                sortNum.add(x);
            }
        }
        return sortNum;
    }




    private static List<String> findSign(String s, List<String> signList) {
        //1+1
        String[] trim = s.split(" "); // [10,*,-10]

        for(String x : trim) { //1+1
            try {
                Integer.parseInt(x);
            } catch (NumberFormatException e) {
                signList.add(x);
            }
        }

        return signList;
    }
}
