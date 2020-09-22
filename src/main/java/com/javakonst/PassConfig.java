package com.javakonst;

public class PassConfig {
    private int quantityWords;
    private int quantityPass;
    private char[] simbolsMustHavePass;
    private String digits;
    private String letters;
    private String specLetters;

    public PassConfig(){
        quantityWords = 10;
        quantityPass = 1;
        digits = "0123456789";
        letters = "abcdefghijklmnoprstuvxyzABCDEFGHIJKLMNOPRSTUVXYZ";
        specLetters = "";
        simbolsMustHavePass = (digits + letters + specLetters).toCharArray();
    }

    public PassConfig(int quantityWords, int quantityPass){
        this();
        if (quantityWords >0) this.quantityWords = quantityWords;
        if (quantityPass >0) this.quantityPass = quantityPass;
    }

    public int getQuantityWords() {
        return quantityWords;
    }

    public void setQuantityWords(int quantityWords) {
        if (quantityWords >0) this.quantityWords = quantityWords;
    }

    public int getQuantityPass() {
        return quantityPass;
    }

    public void setQuantityPass(int quantityPass) {
        if (quantityPass >0) this.quantityPass = quantityPass;
    }

    public char[] getSimbolsMustHavePass() {
        return simbolsMustHavePass;
    }

    public void setSimbolsMustHavePass(char[] simbolsMustHavePass) {
        if (simbolsMustHavePass!=null && simbolsMustHavePass.length >1) this.simbolsMustHavePass = simbolsMustHavePass;
    }

    public String getDigits() {
        return digits;
    }

    public void setDigits(String digits) {
        this.digits = digits;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public String getSpecLetters() {
        return specLetters;
    }

    public void setSpecLetters(String specLetters) {
        this.specLetters = specLetters;
    }
}
