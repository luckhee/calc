package com.back;

public class ReCalc {
    static int result = 0;
    static int run(String s) {

        s=s.replaceAll(" ",""); // 2+2


        if(s.isBlank()) {
            return result;
        }
        else {
            if(s.contains("+")) {
                String[] splitString = s.split("\\+");
                result += Integer.parseInt(splitString[0]);
                run(splitString[1]);
            } else {
                result +=Integer.parseInt(s);
            }

        }
        return result;
    }

}
