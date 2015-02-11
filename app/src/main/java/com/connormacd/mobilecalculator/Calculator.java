package com.connormacd.mobilecalculator;

/**
 * Created by toxXy-devX on 2014-10-02.
 */
public class Calculator {

    public int add(int num1, int num2 ) {
        int result;
        result = num1 + num2;
        return result;
    }


    //Append and remove Decimals and Negatives
    public static String appendDecimal(String num) {
        return num += ".";
    }

    public static String appendNegative(String num) {
        return "-" + num;
    }

    public static String removeNegative(String num) {
        num = num.substring(1);
        return num;
    }


    //This controls the calculations that are passed to it based on the last operator pressed.
    public static double calculate(String inStr, char lastOper, double result) {
        double inNum = Double.parseDouble(inStr);
        if (lastOper==' ') {
            result = inNum;
        } else if (lastOper == '+') {
            result += inNum;
        } else if (lastOper == '-') {
            result -= inNum;
        } else if (lastOper == '*') {
            result *= inNum;
        } else if (lastOper == '/') {
            //Dividing by 0 checking
            if (inNum == 0) {
                return Double.NaN;
            }
            result /= inNum;
        } else if (lastOper== '=') {
            //We already have something in place for this!
        }
        return result;
    }

}
