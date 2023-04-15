package com.hostal.hostelManagementSystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hostel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long hostelId;
    private String hotelName;
    private String hotelAddress;
    private String hotelMobileNumber;
    private String hotelEmail;
    private String hotelDescription;

    public Long getHostelId() {
        return hostelId;
    }

    public void setHostelId(Long hostelId) {
        this.hostelId = hostelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelMobileNumber() {
        return hotelMobileNumber;
    }

    public void setHotelMobileNumber(String hotelMobileNumber) {
        this.hotelMobileNumber = hotelMobileNumber;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    @Override
    public String toString() {
        return "Hostel{" +
                "hostelId=" + hostelId +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelMobileNumber='" + hotelMobileNumber + '\'' +
                ", hotelEmail='" + hotelEmail + '\'' +
                ", hotelDescription='" + hotelDescription + '\'' +
                '}';
    }
}
