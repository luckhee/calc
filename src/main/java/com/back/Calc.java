package com.back;

import java.util.*;

public class Calc {


    static int run(String s) {
        List<String> numList = new ArrayList<>();
        List<String> signList = new ArrayList<>();
        int cnt =0;



        signList = findSign(s, signList);
        numList = findNum(s);
        int result = 0;
        if(signList.stream().anyMatch(sign -> !sign.equals("*"))) {
            result = multiplyCalc(numList, signList);
        }


        int num = sortSign(signList);

        if(num > 0) {
            numList = sortNum(numList, num+1);
        }

        if(numList.size() >0) {
            result += Integer.parseInt(numList.get(cnt));
            numList.remove(cnt);
        }




        result = calc(cnt, numList, signList, result);


        return result;
    }

    private static int multiplyCalc(List<String> numList, List<String> signList) {
        List<Integer> multiplyList = new ArrayList<>();
        int result = 0;
        int index = 0;
        for(String x : signList) {
            if(x.equals("*")) multiplyList.add(index);
            index +=1;
        }

        for (int i = 0; i < multiplyList.size(); i++) {
            int x = multiplyList.get(i);

            result += Integer.parseInt(numList.get(x)) * Integer.parseInt(numList.get(x + 1));

        }
        Set<Integer> toRemoveSet = new HashSet<>();
        for (int i = 0; i < multiplyList.size(); i++) {
            int idx = multiplyList.get(i);
            toRemoveSet.add(idx);
            toRemoveSet.add(idx + 1);
        }
        List<Integer> toRemoveList = new ArrayList<>(toRemoveSet);
        toRemoveList.sort(Collections.reverseOrder());

        for(int x : toRemoveList) {
            numList.remove(x);
        }
        signList.removeIf(sign -> sign.equals("*"));



        return result ;
    }

    private static List<String> sortNum(List<String> numList, int num) {
        String leftOperand = numList.get(num - 1); // 5
        String rightOperand = numList.get(num);    // 2

        List<String> reordered = new ArrayList<>();
        reordered.add(leftOperand);
        reordered.add(rightOperand);

        for (int i = 0; i < numList.size(); i++) {
            if (i != num && i != num - 1) {
                reordered.add(numList.get(i));
            }
        }

        return reordered;
    }

    private static int sortSign(List<String> signList) {
        int cnt = 0;

        for (int i = 0; i < signList.size(); i++) {
            if(signList.get(i).equals("*") && i != 0) {
                cnt = i;
                Collections.sort(signList);
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
