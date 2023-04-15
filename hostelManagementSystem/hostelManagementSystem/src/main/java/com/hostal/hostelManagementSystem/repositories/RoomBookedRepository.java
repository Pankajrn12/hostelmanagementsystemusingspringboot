package com.hostal.hostelManagementSystem.repositories;

import com.hostal.hostelManagementSystem.entities.RoomBooked;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomBookedRepository extends JpaRepository<RoomBooked, Long> {
}
