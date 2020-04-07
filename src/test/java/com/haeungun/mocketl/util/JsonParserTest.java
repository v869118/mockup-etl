package com.haeungun.mocketl.util;

import com.haeungun.mocketl.exceptions.MockEtlJsonConvertException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonParserTest {

    private JsonParser parser;

    @Before
    public void setUp() {
        this.parser = new JsonParser();
    }

    @Test
    public void jsonParserTestArray() throws MockEtlJsonConvertException {
        String str = "[{\"name\":\"procon\"}]";

        JSONArray jsonArray = this.parser.strToJsonArr(str);
        JSONObject json = jsonArray.getJSONObject(0);

        assertEquals(json.getString("name"), "procon");
    }

    @Test(expected=MockEtlJsonConvertException.class)
    public void expectedJSONArray() throws MockEtlJsonConvertException {
        String str = "";
        this.parser.strToJsonArr(str);
    }

    @Test(expected=MockEtlJsonConvertException.class)
    public void userJSON_Array() throws MockEtlJsonConvertException {
        String str = "[{\"name\"";
        this.parser.strToJsonArr(str);
    }
}