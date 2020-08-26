package com.dxctraining.complaints.controllers;


import com.dxctraining.complaints.dto.ComplaintDto;
import com.dxctraining.complaints.dto.ConsumerDto;
import com.dxctraining.complaints.dto.CreateComplaint;
import com.dxctraining.complaints.entities.Complaints;
import com.dxctraining.complaints.service.IComplaintService;
import com.dxctraining.complaints.utility.ComplaintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;


@Component
@Path("/complaint")
public class ComplaintJerseyController {

    @Autowired
    private IComplaintService complaintService;

    @Autowired
    private ComplaintUtil complaintUtil;

    @Autowired
    private RestTemplate restTemplate;

    @Path("/add")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ComplaintDto addComplaint(CreateComplaint data) {
        String description = data.getDescription();
        System.out.println("the description is="+description);
        int consumerid = data.getConsumerId();
        System.out.println("consumer id is=" + consumerid);
        Complaints complaints = new Complaints(description, consumerid);
        complaints = complaintService.add(complaints);
        ConsumerDto consumerDto = fetchfromConsumerId(consumerid);
        System.out.println("the consumer name "+consumerDto.getName());
        ComplaintDto complaintDto = complaintUtil.complaintDto(complaints, consumerid, consumerDto.getName());
        return complaintDto;

    }
    private ConsumerDto fetchfromConsumerId(int consumerid) {
      String url="http://localhost:7777/consumers/get/"+consumerid;
      ConsumerDto consumerDto=restTemplate.getForObject(url,ConsumerDto.class);
      return consumerDto;
    }
    @Path("/by/{id}")
    @Produces("application/json")
    @GET
public ComplaintDto complaintDto(@PathParam("id") int id)
    {
        Complaints complaints=complaintService.complaintById(id);
        int conid=complaints.getConsumerId();
        ConsumerDto consumerDto = fetchfromConsumerId(conid);
        System.out.println("consumer name is="+consumerDto.getName());
        ComplaintDto complaintDto = complaintUtil.complaintDto(complaints,conid,consumerDto.getName());
        return complaintDto;
    }

    @Path("/cid/{id}")
    @Produces("application/json")
    @GET
    public List<ComplaintDto> complaintsList(@PathParam("id") int id)
    {
        List<Complaints>resu=complaintService.complaintByConsumerById(id);
        ConsumerDto consumerDto = fetchfromConsumerId(id);
        List<ComplaintDto>dtos=new ArrayList<>();
        for (Complaints complaint:resu){
            ComplaintDto dto =complaintUtil.complaintDto(complaint,id,consumerDto.getName());
            dtos.add(dto);
        }
        return dtos;

    }






}
