package com.example.momorecorder.response;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class HealthCheckResponse {

    public HashMap<String, Object> returnHealthStatus() {
        HashMap<String, Object> response = new HashMap<>();
        response.put("email", "eng.admin@greyparrot.io");
        response.put("system", "Mobile Money Transactions Recorder(REMO)");
        response.put("version", "0.0.1"); // TODO: fetch this from the properties file
        response.put("environment", "LOCAL");
        response.put("status", "OK");
        return response;
    }

}
