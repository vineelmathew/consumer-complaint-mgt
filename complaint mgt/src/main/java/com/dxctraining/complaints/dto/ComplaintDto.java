package com.dxctraining.complaints.dto;

public class ComplaintDto {
    private int id;
    private String description;
    private int consumerId;
    private String consumerName;

    public ComplaintDto(int id, String descp,int consumerId,String consumerName) {
        this.id = id;
        this.description = descp;
        this.consumerId=consumerId;
        this.consumerName=consumerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }
}
