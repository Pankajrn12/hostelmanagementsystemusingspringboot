package com.hostal.hostelManagementSystem.entities;

import com.hostal.hostelManagementSystem.status.AvailabilityStatus;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long roomId;
    private Long hostelId;
    private String roomNumber;
    private String capacity;
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus status;

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

    public AvailabilityStatus getStatus() {
        return status;
    }

    public void setStatus(AvailabilityStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", hostelId=" + hostelId +
                ", roomNumber=" + roomNumber +
                ", capacity=" + capacity +
                ", status=" + status +
                '}';
    }
}
