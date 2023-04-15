package com.hostal.hostelManagementSystem.models;


public class RoomModel {

    private  Long roomId;
    private Long hostelId;
    private String roomNumber;
    private String capacity;
    private String status;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getHostelId() {
        return hostelId;
    }

    public void setHostelId(Long hostelId) {
        this.hostelId = hostelId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoomModel{" +
                "roomId=" + roomId +
                ", hostelId=" + hostelId +
                ", roomNumber='" + roomNumber + '\'' +
                ", capacity='" + capacity + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
