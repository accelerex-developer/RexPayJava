package com.globalaccelerex.pgs.services;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;


public class Connections {
    private final String url;
    private final String username;
    private final String password;

    public Connections(String username, String password, String url) {
        this.url = url;
        this.username = username;
        this.password = password;

    }
    public JSONObject post(Object request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(request);

        try {
            com.mashape.unirest.http.HttpResponse<com.mashape.unirest.http.JsonNode> response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .basicAuth(username, password)
                    .body(jsonString)
                    .asJson();
                return response.getBody().getObject();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

}
