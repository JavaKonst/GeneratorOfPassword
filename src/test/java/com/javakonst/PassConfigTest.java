package com.javakonst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassConfigTest {
    PassConfig passConfig;

    @Before
    public void setUp(){
        passConfig = new PassConfig();
    }

    @Test
    public void getQuantityWords() {
        int expected = 10;
        int actual = passConfig.getQuantityWords();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getQuantityPass() {
        int expected = 1;
        int actual = passConfig.getQuantityPass();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getDigits() {
        String expected = "0123456789";
        String actual = passConfig.getDigits();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getLetters() {
        String expected = "abcdefghijklmnoprstuvxyzABCDEFGHIJKLMNOPRSTUVXYZ";
        String actual = passConfig.getLetters();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getSpecLetters() {
        String expected = "@#$%&";
        String actual = passConfig.getSpecLetters();

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void getAlphabet() {
        String expected = "0123456789"+"abcdefghijklmnoprstuvxyzABCDEFGHIJKLMNOPRSTUVXYZ"+"@#$%&";
        String actual = String.valueOf(passConfig.getAlphabet());

        Assert.assertEquals(actual, expected);
    }

    //TODO:Добавить тесты на все методы setXXX()
}