package com.example.officebookingsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.officebookingsystem.domain.dto.response.UserDetailRoomResponse;
import com.example.officebookingsystem.domain.dto.response.UserListRoom;
import com.example.officebookingsystem.domain.entity.Building;
import com.example.officebookingsystem.domain.entity.Room;
import com.example.officebookingsystem.domain.repository.BuildingRepository;
import com.example.officebookingsystem.domain.repository.RatingsRepository;
import com.example.officebookingsystem.domain.repository.ReviewRepository;
import com.example.officebookingsystem.domain.repository.RoomItemRepository;
import com.example.officebookingsystem.domain.repository.RoomRepository;
import com.example.officebookingsystem.domain.repository.SpecificationRepository;

@Service
public class UserRoomService {
    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RoomItemRepository roomItemRepository;

    @Autowired
    private RatingsRepository ratingsRepository;

    @Autowired
    private SpecificationRepository specificationRepository;

    public ResponseEntity<List<UserListRoom>> getAllRoomsByIdBuilding(Long id) {
        Optional<Building> building = buildingRepository.findById(id);
        if (building.isPresent() == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        List<UserListRoom> userListRoom = new ArrayList<>();
        List<Room> rooms = roomRepository.listAllRoomByBuilding(id);
        if (rooms.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        for (Room r : rooms) {
            UserListRoom ULR = new UserListRoom();
            ULR.setNama(r.getName());
            ULR.setPricePerHour(r.getPricePerHour());
            ULR.setRating(ratingsRepository.ratingRoom(r.getId()));
            ULR.setStatus(r.getStatus());
            ULR.setItemName(roomItemRepository.roomItemNames(r.getId()));
            userListRoom.add(ULR);
        }
        return ResponseEntity.status(HttpStatus.OK).body(userListRoom);

    }

    public ResponseEntity<UserDetailRoomResponse> getDetailRoom(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent() == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        UserDetailRoomResponse userDetailRoomResponse = new UserDetailRoomResponse();
        userDetailRoomResponse.setRoom(room.get());
        userDetailRoomResponse.setRoomSpecification(specificationRepository.roomSpecification(id));
        userDetailRoomResponse.setRoomItems(roomItemRepository.roomItems(id));
        userDetailRoomResponse.setReviews(reviewRepository.roomReviews(id));
        userDetailRoomResponse.setRating(ratingsRepository.ratingRoom(id));

        return ResponseEntity.status(HttpStatus.OK).body(userDetailRoomResponse);

    }
}
