package com.dxctraining.complaints.dao;

import com.dxctraining.complaints.entities.Complaints;

import java.util.List;

public interface IComplaintDao {
Complaints add(Complaints complaints);
Complaints complaintById(int id);
List<Complaints>complaintByConsumerId(int id);
}
