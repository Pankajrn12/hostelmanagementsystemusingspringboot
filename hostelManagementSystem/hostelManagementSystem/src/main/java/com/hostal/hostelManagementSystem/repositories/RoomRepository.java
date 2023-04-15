package com.hostal.hostelManagementSystem.repositories;

import com.hostal.hostelManagementSystem.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    public Room findByRoomNumber(String roomNumber);
}
