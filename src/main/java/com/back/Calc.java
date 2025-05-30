package com.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {
    static int run(String calc) {
        List<Integer> list = new ArrayList<>();
        int result = 0;
//2 + 2

        if (calc.contains("+")) {
            String[] calcParam = calc.split("\\+");

            for (String num : calcParam) {
                list.add(Integer.parseInt(num.trim()));
            }

            for (int num : list) {
                result += num;
            }

        } else if (calc.contains("-")) {
            String[] calcParam = calc.split("-");

            for (String num : calcParam) {
                list.add(Integer.parseInt(num.trim()));

            }

            result += list.get(0);

            for(int i = 1; i <list.size(); i++) {
                result -= list.get(i);
            }

// 10 - 20 + 30 == 20
        }


        String x = calc.replace(" ",""); // 10-20+30;
        String[] num = x.split("");

        for(int i = 0; i < num.length; i++) {
            if(num[i].equals("-") ) {
                int cutString = Integer.parseInt(x.substring(0,i));
                x= x.substring(i);
                System.out.println(x);
                System.out.println(cutString);
                result +=cutString;
            }
        }

        return result;
    }

}
