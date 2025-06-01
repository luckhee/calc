package com.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {
    static int result;
    static int cnt =0;
    static int run(String calc) {
        calc = calc.replaceAll(" ","");
        if(calc.contains("+")) {
            String[] splitCf = calc.split("\\+"); // [10-10-10-10, 10, 10-10]
            System.out.println(Arrays.toString(splitCf));
            for(String x : splitCf) {
                if(x.contains("-")) {
                    String[] minusSplitCf = x.split("-");
                    System.out.println(cnt+"번 minus  = "+Arrays.toString(minusSplitCf));
                    result += Integer.parseInt(minusSplitCf[0]);
                    System.out.println("1번 " +result);
                    minusSplitCf[0]="0";
                    for(String y : minusSplitCf) {
                        result -= Integer.parseInt(y);
                        System.out.println("2번 " +result);
                    }
                    System.out.println("result = " + result);
                    splitCf[cnt++]="0";
                    System.out.println(Arrays.toString(splitCf));


                }
                else {
                    result += Integer.parseInt(x);
                    //cnt++;
                }
            }
//            for(String x : splitCf) {
//                result += Integer.parseInt(x);
//                System.out.println("3번 " +result);
//            }
            System.out.println("최종 result = " +result);
            return result;
        } else if(calc.contains("-")) {

            String[] splitCf = calc.split("-");
            //System.out.println(Arrays.toString(splitCf));
            result += Integer.parseInt(splitCf[0]);
            splitCf[0]="0";
            for(String x : splitCf) {
                result -= Integer.parseInt(x);
            }
        } else if(calc.contains("*")) {
            List<String> list = new ArrayList<>(Arrays.asList(calc.split("\\*")));
            System.out.println(list);
            int answer =1;
            for( String x: list) {
                answer *= Integer.parseInt(x);
                result = answer;
            }



        }
        return result;
    }

}
