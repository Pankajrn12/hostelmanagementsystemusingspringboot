package com.hostal.hostelManagementSystem.entities;

import com.hostal.hostelManagementSystem.status.AvailabilityStatus;
import com.hostal.hostelManagementSystem.utility.DateUtility;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RoomBooked {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long roomBookedId;
    private Long studentId;
    private Date inDate;
    private String outDate;
    private String roomNumber;
    @Enumerated (EnumType.STRING)
    private AvailabilityStatus status;


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

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
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

    public AvailabilityStatus getStatus() {
        return status;
    }

    public void setStatus(AvailabilityStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RoomBooked{" +
                "roomBookedId=" + roomBookedId +
                ", studentId=" + studentId +
                ", inDate=" + inDate +
                ", outDate='" + outDate + '\'' +
                ", roomNumber=" + roomNumber +
                ", status=" + status +
                '}';
    }
}
