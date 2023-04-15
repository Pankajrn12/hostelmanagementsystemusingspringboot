package com.hostal.hostelManagementSystem.repositories;

import com.hostal.hostelManagementSystem.entities.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostelRepository extends JpaRepository<Hostel,Long> {
}
