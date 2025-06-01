package com.back;

public class Calc {
    static int result;

    static int run(String calc) {
        result = 0;
        calc = calc.replaceAll(" ", "");

        if (calc.contains("+")) {
            String[] plusParts = calc.split("\\+");
            for (int i = 0; i < plusParts.length; i++) {
                String part = plusParts[i];
                if (part.contains("-")) {
                    String[] minusParts = part.split("-");
                    result += Integer.parseInt(minusParts[0]);
                    for (int j = 1; j < minusParts.length; j++) {
                        result -= Integer.parseInt(minusParts[j]);
                    }
                } else {
                    result += Integer.parseInt(part);
                }
            }
            return result;
        }

        if (calc.contains("*")) {
            String[] multiplyParts = calc.split("\\*");
            result = 1;
            for (String part : multiplyParts) {
                result *= Integer.parseInt(part);
            }
            return result;
        }

        if (calc.contains("-")) {
            String[] minusParts = calc.split("-");
            result = Integer.parseInt(minusParts[0]);
            for (int i = 1; i < minusParts.length; i++) {
                result -= Integer.parseInt(minusParts[i]);
            }
            return result;
        }



        return result;
    }
}
