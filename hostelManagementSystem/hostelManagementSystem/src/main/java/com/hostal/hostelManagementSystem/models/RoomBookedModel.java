package com.hostal.hostelManagementSystem.models;


import java.util.Date;

public class RoomBookedModel {
    private Long roomBookedId;
    private Long studentId;
    private String inDate;
    private String outDate;
    private String roomNumber;


    public Long getRoomBookedId() {
        return roomBookedId;
    }

    public void setRoomBookedId(Long roomBookedId) {
        this.roomBookedId = roomBookedId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "RoomBookedModel{" +
                "roomBookedId=" + roomBookedId +
                ", studentId=" + studentId +
                ", inDate='" + inDate + '\'' +
                ", outDate='" + outDate + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
