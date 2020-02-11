package com.example.aggregator.controller;

import com.example.aggregator.Server;
import com.example.aggregator.dto.AggregatedPhoneData;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

public class PhoneResolver {
    private Client client;


    public PhoneResolver(Client client) {
         this.client = client;
    }

    public AggregatedPhoneData getPhone(List<String> phoneNumbers) {
        AggregatedPhoneData phoneData = new AggregatedPhoneData();

        for(String phone: phoneNumbers) {
            WebTarget webTarget = client.target(Server.extService).path("sector/" + phone);
            Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();
            Map employees = response.readEntity(Map.class);
            phoneData.addPhone((String) employees.get("number"), (String)employees.get("sector"));

        }
        return phoneData;

    }
}
