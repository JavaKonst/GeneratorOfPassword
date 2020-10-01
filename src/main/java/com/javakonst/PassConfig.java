package com.javakonst;

public class PassConfig {
    private int quantityWords;
    private int quantityPass;
    private String digits;
    private String letters;
    private String specLetters;

    public PassConfig(){
        quantityWords = 10;
        quantityPass = 1;
        digits = "0123456789";
        letters = "abcdefghijklmnoprstuvxyzABCDEFGHIJKLMNOPRSTUVXYZ";
        specLetters = "@#$%&";
    }

    public PassConfig(int quantityWords, int quantityPass){
        this();
        if (quantityWords > 0) this.quantityWords = quantityWords;
        if (quantityPass > 0) this.quantityPass = quantityPass;
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

    public char[] getAlphabet() {
        return (digits + letters + specLetters).toCharArray();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassConfig that = (PassConfig) o;

        if (quantityWords != that.quantityWords) return false;
        if (quantityPass != that.quantityPass) return false;
        if (!digits.equals(that.digits)) return false;
        if (!letters.equals(that.letters)) return false;
        return specLetters.equals(that.specLetters);
    }

    @Override
    public int hashCode() {
        int result = quantityWords;
        result = 31 * result + quantityPass;
        result = 31 * result + digits.hashCode();
        result = 31 * result + letters.hashCode();
        result = 31 * result + specLetters.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PassConfig{" +
                "quantityWords=" + quantityWords +
                ", quantityPass=" + quantityPass +
                ", digits='" + digits + '\'' +
                ", letters='" + letters + '\'' +
                ", specLetters='" + specLetters + '\'' +
                '}';
    }
}
