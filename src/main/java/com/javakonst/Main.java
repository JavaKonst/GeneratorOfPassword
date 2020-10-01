package com.javakonst;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        /**
         * допустмые символы: abcdefghmnpqstuvxyz ABCDEFGHJKMNPQRSTUVXYZ 23456789 @#%&?$
         * мин 8 символов
         * мин 1 цифра
         * мин 1 строчный символ
         * мин 1 прописной символ
         * мин 1 спецсивол
         */

        PassConfig passConfig = new PassConfig();
        passConfig.setQuantityWords(8);
        passConfig.setQuantityPass(42);
        passConfig.setDigits("23456789");
        passConfig.setLetters("abcdefghmnpqstuvxyzABCDEFGHJKMNPQRSTUVXYZ");
        passConfig.setSpecLetters("@#%&?$");

        GenPassService genPassService = new GenPassMethodOne();
        genPassService.setConfigPassGenerator(passConfig);

        Set<String> passList = genPassService.getPassList();
        System.out.println("-----listPass( "+passList.size()+"шт. )-----");
        passList.forEach(System.out::println);

    }
}
