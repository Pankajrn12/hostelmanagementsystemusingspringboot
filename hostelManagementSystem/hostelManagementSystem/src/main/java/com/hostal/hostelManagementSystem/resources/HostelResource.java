package com.hostal.hostelManagementSystem.resources;

import com.hostal.hostelManagementSystem.models.HostelModel;
import com.hostal.hostelManagementSystem.models.RoomBookedModel;
import com.hostal.hostelManagementSystem.models.RoomModel;
import com.hostal.hostelManagementSystem.models.StudentModel;
import com.hostal.hostelManagementSystem.services.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/hostel")
public class HostelResource {
    @Autowired
    HostelService hostelService;

    @PostMapping("/saveHostelAllDetails")
    public ResponseEntity saveHostelAllDetails(@RequestBody HostelModel hostelModel){
        return hostelService.saveHostelAllDetails(hostelModel);
    }
    @PostMapping("/updateHostelAllDetails")
    public ResponseEntity updateHostelAllDetails(@RequestBody HostelModel hostelModel){
        return hostelService.updateHostelAllDetails(hostelModel);
    }

    @GetMapping("/getHostelAllDetails")
    public LinkedList<HostelModel>getHostelAllDetails(){
        return hostelService.getHostelAllDetails();
    }

    @PostMapping("/saveStudentDetails")
    public ResponseEntity saveStudentDetails(@RequestBody StudentModel studentModel){
        return hostelService.saveStudentDetails(studentModel);
    }

    @PostMapping("/saveRoomDetails")
    public ResponseEntity saveRoomDetails(@RequestBody RoomModel roomModel){
        return hostelService.saveRoomDetails(roomModel);
    }

    @GetMapping("/getAllRoom")
    public LinkedList<RoomModel> getAllRoom(){
        return hostelService.getAllRoom();
    }

    @GetMapping("/getAllStudent")
    public LinkedList<StudentModel> getAllStudent(){
        return hostelService.getAllStudent();
    }

    @PostMapping("/SaveRoomBookedAllDetails")
    public ResponseEntity SaveRoomBookedAllDetails(@RequestBody RoomBookedModel roomBookedModel){
        return hostelService.SaveRoomBookedAllDetails(roomBookedModel);
    }

    @GetMapping("/getAllAvailableRoom")
    public LinkedList<RoomModel> getAllAvailableRoom(){
        return hostelService.getAllAvailableRoom();
    }

}
