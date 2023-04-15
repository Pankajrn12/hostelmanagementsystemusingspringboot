package com.hostal.hostelManagementSystem.services;


import com.hostal.hostelManagementSystem.entities.Hostel;
import com.hostal.hostelManagementSystem.entities.Room;
import com.hostal.hostelManagementSystem.entities.RoomBooked;
import com.hostal.hostelManagementSystem.entities.Student;
import com.hostal.hostelManagementSystem.models.HostelModel;
import com.hostal.hostelManagementSystem.models.RoomBookedModel;
import com.hostal.hostelManagementSystem.models.RoomModel;
import com.hostal.hostelManagementSystem.models.StudentModel;
import com.hostal.hostelManagementSystem.repositories.HostelRepository;
import com.hostal.hostelManagementSystem.repositories.RoomBookedRepository;
import com.hostal.hostelManagementSystem.repositories.RoomRepository;
import com.hostal.hostelManagementSystem.repositories.StudentRepository;
import com.hostal.hostelManagementSystem.status.AvailabilityStatus;
import com.hostal.hostelManagementSystem.utility.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.LinkedList;

@Service
public class HostelService {
    @Autowired
    HostelRepository hostelRepository;
    @Autowired
    EntityManager entityManager;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    RoomBookedRepository roomBookedRepository;

    @Transactional
    public ResponseEntity saveHostelAllDetails(HostelModel hostelModel) {
        Hostel hostel = new Hostel();
        hostel.setHostelId(hostelModel.getHostelId());
        hostel.setHotelName(hostelModel.getHotelName());
        hostel.setHotelEmail(hostelModel.getHotelEmail());
        hostel.setHotelDescription(hostelModel.getHotelDescription());
        hostel.setHotelAddress(hostelModel.getHotelAddress());
        hostel.setHotelMobileNumber(hostelModel.getHotelMobileNumber());

        hostelRepository.save(hostel);
        return new ResponseEntity<>("Data Saved", HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity updateHostelAllDetails(HostelModel hostelModel) {
        entityManager.createNativeQuery("update hostelmanagementsystem.hostel set hotel_address =:hotel_address , hotel_description =:hotel_description , hotel_email =:hotel_email , hotel_mobile_number =:hotel_mobile_number , hotel_name =:hotel_name  where hostel_id =:hostel_id ")
                .setParameter("hotel_address",hostelModel.getHotelAddress())
                .setParameter("hotel_description",hostelModel.getHotelDescription())
                .setParameter("hotel_email",hostelModel.getHotelEmail())
                .setParameter("hotel_mobile_number",hostelModel.getHotelMobileNumber())
                .setParameter("hotel_name",hostelModel.getHotelName())
                .setParameter("hostel_id",hostelModel.getHostelId()).executeUpdate();
        return new ResponseEntity<>("Data Updated",HttpStatus.OK);
    }

    public LinkedList<HostelModel> getHostelAllDetails() {
        LinkedList<HostelModel> hostelModelLinkedList = new LinkedList<>();
        LinkedList<Hostel> hostelLinkedList = new LinkedList<>(hostelRepository.findAll());
        hostelLinkedList.stream().forEach(data->{
            HostelModel model = new HostelModel();
            model.setHotelName(data.getHotelName());
            model.setHostelId(data.getHostelId());
            model.setHotelAddress(data.getHotelAddress());
            model.setHotelDescription(data.getHotelDescription());
            model.setHotelMobileNumber(data.getHotelMobileNumber());
            model.setHotelEmail(data.getHotelEmail());

            hostelModelLinkedList.add(model);
        });
        return hostelModelLinkedList;
    }

    @Transactional
    public ResponseEntity saveStudentDetails(StudentModel studentModel) {
        Student student = new Student();
        student.setStudentId(studentModel.getStudentId());
        student.setStudentName(studentModel.getStudentName());
        student.setStudentEmail(studentModel.getStudentEmail());
        student.setStudentAddress(studentModel.getStudentAddress());
        student.setStudentMobileNumber(studentModel.getStudentMobileNumber());

        studentRepository.save(student);

        return new ResponseEntity<>("Data Saved",HttpStatus.OK);

    }

    @Transactional
    public ResponseEntity saveRoomDetails(RoomModel roomModel) {
        Room room = new Room();
        room.setRoomId(roomModel.getRoomId());
        room.setRoomNumber(roomModel.getRoomNumber());
        room.setCapacity(roomModel.getCapacity());
        room.setHostelId(roomModel.getHostelId());
        if (roomModel.getStatus().equalsIgnoreCase("Available")){
            room.setStatus(AvailabilityStatus.Available);
        } else if (roomModel.getStatus().equalsIgnoreCase("Booked")) {
            room.setStatus(AvailabilityStatus.Booked);

        }
        roomRepository.save(room);
        return new ResponseEntity<>("Save room details", HttpStatus.OK);
    }

    public LinkedList<RoomModel> getAllRoom() {
        LinkedList<RoomModel> roomModelLinkedList = new LinkedList<>();
        LinkedList<Room> roomLinkedList = new LinkedList<>(roomRepository.findAll());
        roomLinkedList.stream().forEach(data->{
            RoomModel model = new RoomModel();
            model.setRoomNumber(data.getRoomNumber());
            model.setRoomId(data.getRoomId());
            model.setHostelId(data.getHostelId());
            model.setCapacity(data.getCapacity());
            model.setStatus(data.getStatus().toString());

            roomModelLinkedList.add(model);
        });
        return roomModelLinkedList;
    }

    public LinkedList<StudentModel> getAllStudent() {
        LinkedList<StudentModel> studentModelLinkedList = new LinkedList<>();
        LinkedList<Student> studentLinkedList = new LinkedList<>(studentRepository.findAll());
        studentLinkedList.stream().forEach(data->{
            StudentModel model = new StudentModel();
            model.setStudentId(data.getStudentId());
            model.setStudentName(data.getStudentName());
            model.setStudentEmail(data.getStudentEmail());
            model.setStudentAddress(data.getStudentAddress());
            model.setStudentMobileNumber(data.getStudentMobileNumber());

            studentModelLinkedList.add(model);
        });
        return studentModelLinkedList;
    }

    @Transactional
    public ResponseEntity SaveRoomBookedAllDetails(RoomBookedModel roomBookedModel) {
        Student student = studentRepository.findByStudentId(roomBookedModel.getStudentId());
        System.out.println("Student ******************* "+student);
        Room room = roomRepository.findByRoomNumber(roomBookedModel.getRoomNumber());
        System.out.println("Room ***************************** " +room);
        room.setStatus(AvailabilityStatus.Booked);
        roomRepository.save(room);
        System.out.println("Room Details After Save "+ room);

        RoomBooked booked = new RoomBooked();
        booked.setRoomBookedId(roomBookedModel.getRoomBookedId());
        booked.setStudentId(roomBookedModel.getStudentId());
        booked.setRoomNumber(room.getRoomNumber());
        booked.setInDate(DateUtility.getCurrentDate());
        booked.setOutDate(roomBookedModel.getOutDate());
        booked.setStatus(AvailabilityStatus.Booked);

        roomBookedRepository.save(booked);

        System.out.println("Hostel Affter Booking room Saved" +booked);

        return new ResponseEntity<>("Hostel Booked ", HttpStatus.OK);
    }

    public LinkedList<RoomModel> getAllAvailableRoom() {
        LinkedList<RoomModel> roomModelLinkedList = new LinkedList<>();
        LinkedList<Room> roomLinkedList = new LinkedList<>(roomRepository.findAll());
        roomLinkedList.stream().forEach(data->{
            RoomModel model =  null;
            if (data.getStatus().toString().equalsIgnoreCase("Available")){
                model= new RoomModel();
                model.setRoomId(data.getRoomId());
                model.setCapacity(data.getCapacity());
                model.setHostelId(data.getHostelId());
                model.setRoomNumber(data.getRoomNumber());
                model.setStatus(data.getStatus().toString());

                roomModelLinkedList.add(model);
            }
        });
        return roomModelLinkedList;
    }
}
