package com.javarush.test.level22.lesson13.task03;

import java.util.regex.Pattern;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("05012--3456"));
        System.out.println(checkTelNumber("(0)501234567"));
    }

    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null){
            return false;
        }
        if(telNumber.startsWith("+")){
            String tempstring  = telNumber.replaceAll("\\D", "");
            if(tempstring.length() != 12){
                return false;
            }
        }
        if(telNumber.startsWith("(")){
            String tempstring  = telNumber.replaceAll("\\D", "");
            if(tempstring.length() != 10){
                return false;
            }
        }
        if((telNumber.startsWith("0") || telNumber.startsWith("1") || telNumber.startsWith("2") ||telNumber.startsWith("3")
                || telNumber.startsWith("4") || telNumber.startsWith("5") || telNumber.startsWith("6") || telNumber.startsWith("7") ||
                telNumber.startsWith("8") || telNumber.startsWith("9"))){
            String tempstring  = telNumber.replaceAll("\\D", "");
            if(tempstring.length() != 10) {
                return false;
            }
        }
        if(telNumber.contains("-")){
            int defisSecondIndex = 0;
            int defisIndex = telNumber.indexOf("-");
            String temp = telNumber.substring(defisIndex + 1);
            if(temp.contains("-")){
                defisSecondIndex = temp.indexOf("-");
                String temp2 = temp.substring(temp.indexOf("-") + 1);
                if(temp2.contains("-")){
                    return false;
                }
            }
            if(defisSecondIndex != 0){
                if(defisIndex - (defisIndex + defisIndex) == 1){
                    return false;
                }
            }
        }
        if(telNumber.contains("-")){
            int defisIndex = telNumber.indexOf("-");
            if(telNumber.charAt(defisIndex+1) == '-'){
                return false;
            }
        }
        if(telNumber.contains("(") && !telNumber.contains(")")){
            return false;
        }
        if(telNumber.contains(")") && !telNumber.contains("(")){
            return false;
        }
        if(telNumber.contains("(") && telNumber.contains(")")){
            if(telNumber.indexOf("(") > telNumber.indexOf(")")){
                return false;
            }
        }
        if(telNumber.contains("(") && telNumber.contains(")")){
            int left = telNumber.indexOf("(");
            int right = telNumber.indexOf(")");
            String temp = telNumber.substring(telNumber.indexOf("(") + 1);
            if(temp.contains("(")){
                return false;
            }
            String temp2 = telNumber.substring(telNumber.indexOf(")") + 1);
            if(temp2.contains(")")){
                return false;
            }
        }
        if(telNumber.contains("(") && telNumber.contains(")") && telNumber.contains("-")){
            if(telNumber.indexOf(")") > telNumber.indexOf("-")){
                return false;
            }
        }
        if(telNumber.contains("(") && telNumber.contains(")")){
            int left = telNumber.indexOf("(");
            int right = telNumber.indexOf(")");
            if(right - left != 4){
                return false;
            }
        }
        if(!Character.isDigit(telNumber.charAt(telNumber.length()-1))){
            return false;
        }
        if(Pattern.matches("[a-zA-Z]+", telNumber)){
            return false;
        }
        return true;
    }

}
