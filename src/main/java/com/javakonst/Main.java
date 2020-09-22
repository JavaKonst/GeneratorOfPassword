package com.javakonst;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        GenPassMethodOne.showRandomRow();

        /**
         * abcdefghmnpqstuvxyz ABCDEFGHJKMNPQRSTUVXYZ 23456789 @#%&?$
         * мин 8 символов
         * мин 1 цифра
         * мин 1 строчный символ
         * мин 1 прописной символ
         * мин 1 спецсивол
         */

        PassConfig passConfig = new PassConfig();
        passConfig.setQuantityWords(10);
        passConfig.setQuantityPass(10);
        passConfig.setDigits("23456789");
        passConfig.setLetters("abcdefghmnpqstuvxyzABCDEFGHJKMNPQRSTUVXYZ");
        passConfig.setSpecLetters("@#%&?$");

        GenPassService genPassService = new GenPassMethodOne();
        genPassService.setConfigPassGenerator(passConfig);


        String singlePass = genPassService.getSinglePass();
        System.out.println("-----singlePass-----\n"+singlePass);

        Set<String> passList = genPassService.getPassList();
        System.out.println("-----listPass( "+passList.size()+"шт. )-----");
        passList.forEach(System.out::println);

    }
}
