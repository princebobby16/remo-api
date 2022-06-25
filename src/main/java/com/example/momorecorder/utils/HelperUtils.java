package com.example.momorecorder.utils;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import net.minidev.json.JSONArray;

import java.sql.Date;

public class HelperUtils {
    public Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }
}
