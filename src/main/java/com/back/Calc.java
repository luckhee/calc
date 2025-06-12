package com.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {
    static int result = 0;

    static int run(String s) {
        List<String> numList = new ArrayList<>();
        List<String> signList = new ArrayList<>();
        int cnt =0;

        // 음수 계산할것~
        //s=s.replaceAll(" ","");

        signList = findSign(s, signList);
        numList = findNum(s);

        // 첫번째 숫자는 무조건 더해버려
        result += Integer.parseInt(numList.get(cnt));
        numList.remove(cnt);

        calc(cnt, numList, signList);


        return result;
    }

    private static int calc(int cnt, List<String> numList, List<String> signList) {

        if(numList.isEmpty()) return result;
        else {
            if(signList.get(cnt).equals("+")) {
                result += Integer.parseInt(numList.get(cnt));
                numList.remove(cnt);
                signList.remove(cnt);

            } else if(signList.get(cnt).equals("-")) {
                result -= Integer.parseInt(numList.get(cnt));
                numList.remove(cnt);
                signList.remove(cnt);

            } else if(signList.get(cnt).equals("*")) {
                result *= Integer.parseInt(numList.get(cnt));
                numList.remove(cnt);
                signList.remove(cnt);
            }
        }

        calc(cnt,numList,signList);

        return result;
    }

    private static List<String> findNum(String s) {
        return new ArrayList<>(Arrays.asList(s.split("[+\\-\\*]")));
    }




    private static List<String> findSign(String s, List<String> signList) {
        //1+1
        String[] trim = s.split(" "); // [10,*,-10]
        for(char x : s.toCharArray()) { //1+1
            if(!Character.isDigit(x)) signList.add(String.valueOf(x));

        }

        return signList; // 이게 문제여 내가보기엔 이게 진짜 대형사고fd
    }
}
