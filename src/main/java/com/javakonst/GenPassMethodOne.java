package com.javakonst;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenPassMethodOne implements GenPassService {
    private PassConfig passConfig;

    @Override
    public void setConfigPassGenerator(PassConfig passConfig){
        this.passConfig = passConfig;
    }

    public PassConfig getPassConfig() {
        return passConfig;
    }

    @Override
    public Set<String> getPassList (){
        Set<String> passwordList = new HashSet<>();

        for (int i = 0; i < passConfig.getQuantityPass(); i++) {
            if (!passwordList.add(this.getSinglePass())) i--;
        }

        return passwordList;
    }

    @Override
    public String getSinglePass (){
        Random random = new Random();

        char[] alphabet = passConfig.getAlphabet();
        int quantityWords = passConfig.getQuantityWords();

        String outPass = "";
        boolean isfound = false;
        while(!isfound){
            outPass = "";
            for (int i = 0; i < quantityWords;) {
                int e = random.nextInt(alphabet.length);
                outPass += String.valueOf(alphabet[e]);
                i++;
            }
            Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[@#$%&])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z@#$%&]{8,}");
            Matcher matcher = pattern.matcher(outPass);

            if (matcher.matches()) isfound = true;
        }

        return outPass;
    }

    //наглядное отображение (гистограмма) алгоритма получения случайнного числа то 0 до 9
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
