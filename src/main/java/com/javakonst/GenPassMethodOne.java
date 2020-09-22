package com.javakonst;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenPassMethodOne implements GenPassService {
    PassConfig passConfig;

    @Override
    public void setConfigPassGenerator(PassConfig passConfig){
        this.passConfig = passConfig;
    }

    @Override
    public Set<String> getPassList (){
        Set<String> passwordList = new HashSet<>();

        for (int i = 0; i < passConfig.getQuantityPass(); i++) {
            passwordList.add(this.getSinglePass());
        }

        return passwordList;
    }

    @Override
    public String getSinglePass (){
        Random random = new Random();

        char[] simbolsMustHavePass = (passConfig.getDigits()+passConfig.getLetters()+passConfig.getSpecLetters()).toCharArray();
        int quantityWords = passConfig.getQuantityWords();

        String outPass = "";
        boolean isfound = false;
        while(!isfound){
            outPass = "";
            for (int i = 0; i < quantityWords;) {
                int e = random.nextInt(simbolsMustHavePass.length);
                outPass += String.valueOf(simbolsMustHavePass[e]);
                i++;
            }
//            Pattern pattern1 = Pattern.compile("[a-z]{1}");
//            Pattern pattern2 = Pattern.compile("[A-Z]{1}");
//            Pattern pattern3 = Pattern.compile("\\d{1,}");
//            Pattern pattern4 = Pattern.compile("\\W{1,}");
//            Matcher matcher1 = pattern1.matcher(outPass);
//            Matcher matcher2 = pattern2.matcher(outPass);
//            Matcher matcher3 = pattern3.matcher(outPass);
//            Matcher matcher4 = pattern4.matcher(outPass);
            Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[@#$%&])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z@#$%&]{8,}");
            Matcher matcher = pattern.matcher(outPass);

//            if (matcher1.find() && matcher2.find() && matcher3.find() && matcher4.find()) isfound = true;
            if (matcher.matches()) isfound = true;
        }

        return outPass;
    }

    public static void showRandomRow(){
        Random random = new Random();

        int[] numbers = new int[10];
        for (int j = 0; j < 100; j++) {
            int i = random.nextInt(10);
            numbers[i]++;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(i+":\t");
            for (int j = 0; j < numbers[i]; j++) {
                System.out.print(":");
            }
            System.out.println(""+numbers[i]);
        }
    }
}
