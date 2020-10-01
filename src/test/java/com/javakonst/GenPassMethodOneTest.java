package com.javakonst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenPassMethodOneTest {
    private GenPassService genPassService;

    @Before
    public void setUp(){
        genPassService = new GenPassMethodOne();
    }

    @Test
    public void setConfigPassGenerator() {
        PassConfig expected = new PassConfig();
        expected.setDigits("0123456789");
        expected.setLetters("abcdefghijklmnoprstuvxyzABCDEFGHIJKLMNOPRSTUVXYZ");
        expected.setQuantityWords(10);
        expected.setQuantityPass(1);
        expected.setSpecLetters("@#$%&");

        GenPassMethodOne genPassMethodOne = new GenPassMethodOne();
        genPassMethodOne.setConfigPassGenerator(new PassConfig());
        PassConfig actual = genPassMethodOne.getPassConfig();

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void getPassList() {
        int expected = 3;

        genPassService.setConfigPassGenerator(new PassConfig(10, expected));
        Set<String> passList = genPassService.getPassList();
        int actual = passList.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getSinglePass() {

        genPassService.setConfigPassGenerator(new PassConfig());
        Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[@#$%&])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z@#$%&]{10,}");
        Matcher matcher = pattern.matcher(genPassService.getSinglePass());

        Assert.assertTrue(matcher.matches());
    }

}