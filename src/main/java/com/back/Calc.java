package com.back;

public class Calc {
    static int result = 0;
    static String sign = "+";
    static String changeString = "";
    static int idx = 0;
    static int run(String s) {

        s=s.replaceAll(" ",""); // 1+1


        if(s.isBlank()) {
            return result;
        }
        else {



            sign = findSign(s);



            String fBit = s.substring(0,idx); //1

            if(sign.equals("+")) {
                result += Integer.parseInt(fBit);
            } else if (sign.equals("-")) {
                result -= Integer.parseInt(fBit);
            }

            s=s.substring(idx); //-1
            run(s);
        }

        return result;
    }

    private static String findSign(String s) {
        //1+1
        idx = 0;
        for(char x : s.toCharArray()) { //1+1
            if(!Character.isDigit(x)){

                idx+=1;
                changeString = findStringbyIdx(s, idx);
                return String.valueOf(x);
            }
        }

        return "+";
    }

    private static String findStringbyIdx(String s, int idx) {

        return s.substring(idx);

    }

}
