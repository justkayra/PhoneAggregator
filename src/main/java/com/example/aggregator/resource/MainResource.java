package com.example.aggregator.resource;

import com.example.aggregator.controller.PhoneResolver;
import com.example.aggregator.dto.AggregatedPhoneData;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/")
public class MainResource {
    private PhoneResolver controller;


    public MainResource(Client restClient){
        controller = new PhoneResolver(restClient);
    }

    @POST
    @Path("/aggregate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response streamAudio(List<String> phones) {
        AggregatedPhoneData phoneData = controller.getPhone(phones);
        return Response.ok().entity(phoneData.getPhones()).build();
    }


}