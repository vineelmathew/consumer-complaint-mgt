package com.dxctraining.complaints.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Complaints {
   @GeneratedValue
   @Id
    private int id;
    private String descp;
    private int consumerId;
    public Complaints(String descp,int consumerId) {

        this.descp = descp;
        this.consumerId=consumerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }
}
