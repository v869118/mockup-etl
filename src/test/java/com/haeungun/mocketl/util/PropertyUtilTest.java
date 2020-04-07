package com.haeungun.mocketl.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyUtilTest {

    private PropertyUtil propertyUtil;

    @Before
    public void setUp() {
        this.propertyUtil = new PropertyUtil("test");
    }

    @Test
    public void testPropetyUtil1() {
        String expected = "barrack";
        String actual = this.propertyUtil.getStringValue("test.string");

        assertEquals(expected, actual);
    }

    @Test
    public void testPropetyUtil2() {
        int expected = 12345;
        int actual = this.propertyUtil.getIntValue("test.number");

        assertEquals(expected, actual);
    }
}