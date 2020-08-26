package com.dxctraining.consumer.controllers;


import com.dxctraining.consumer.dto.ConsumerDto;
import com.dxctraining.consumer.dto.CreateConsumer;
import com.dxctraining.consumer.entities.Consumer;
import com.dxctraining.consumer.service.IConsumerService;
import com.dxctraining.consumer.util.ConsumerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Component
@Path("/consumers")
public class ConsumerJerseyController {

    @Autowired
    private IConsumerService consumerService;

    @Autowired
    private ConsumerUtility consumerUtil;

    @Path("/add")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ConsumerDto addconsumer(CreateConsumer data)
    {
        Consumer consumer=new Consumer(data.getName());
        consumerService.addConsumer(consumer);
        ConsumerDto res=consumerUtil.consumerDto(consumer);
        return res;
    }




}
