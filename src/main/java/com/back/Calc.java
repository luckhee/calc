package com.back;

public class Calc {
    static int result = 0;
    static String sign = "+";
    static String changeString = "";
    static int idx = 0;
    static int run(String s) {

        s=s.replaceAll(" ",""); // 1+1

        sign = findSign(s);

        if(changeString.isBlank()) {
            if(sign.equals("+")) {
                result += Integer.parseInt(s);
            } else if (sign.equals("-")) {
             result-=Integer.parseInt(s);
            }
             return result;
        }
        else {







            String fBit = s.substring(0,idx); //1 여기서 "" 되는 문제 발생

            if(sign.equals("+")) {
                result += Integer.parseInt(fBit);
            } else if (sign.equals("-") && result == 0) {
                result += Integer.parseInt(fBit);
            } else if(sign.equals("-")) {
                result -= Integer.parseInt(fBit);
            }
            s=s.substring(idx); //-1

            run(changeString);
        }

        return result;
    }

    private static String findSign(String s) {
        //1+1
        idx = 0;
        for(char x : s.toCharArray()) { //1+1
            if(Character.isDigit(x)){

                idx+=1;


            } else {
                changeString = findStringbyIdx(s, idx);
                return String.valueOf(x);
            }
        }
        changeString = findStringbyIdx(s, idx);
        return sign; // 이게 문제여 내가보기엔 이게 진짜 대형사고fd
    }

    private static String findStringbyIdx(String s, int idx) {

        String result="";
        try {
             result = s.substring(idx+1);
        } catch (Exception e) {
            return "";
        }

        return result;

    }

}
