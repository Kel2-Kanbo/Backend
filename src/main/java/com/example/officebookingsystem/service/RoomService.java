package com.example.officebookingsystem.service;

import com.example.officebookingsystem.domain.dto.request.RoomCreateRequest;
import com.example.officebookingsystem.domain.dto.request.RoomItemRequest;
import com.example.officebookingsystem.domain.entity.Room;
import com.example.officebookingsystem.domain.entity.RoomItem;
import com.example.officebookingsystem.domain.repository.BuildingRepository;
import com.example.officebookingsystem.domain.repository.RoomItemRepository;
import com.example.officebookingsystem.domain.repository.RoomRepository;
import com.example.officebookingsystem.domain.repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomItemRepository roomItemRepository;

    @Autowired
    private BuildingRepository buildingRepository;


    @Autowired
    private SpecificationRepository specificationRepository;

    public ResponseEntity<?> create(RoomCreateRequest roomCreateRequest){
//        if(roomRepository.existByName(roomCreateRequest.getRoomName())){
//            return  ResponseEntity.badRequest().body(new MessageResponse("Error: Room name is already exist!"));
//        }
        Room room=new Room();
        room.setName(roomCreateRequest.getRoomName());
        if (roomCreateRequest.getBuilding_id() != null ){
            room.setBuilding(buildingRepository.findById(roomCreateRequest.getBuilding_id()).get());
        }
        room.setDescription(roomCreateRequest.getDescription());
        room.setPricePerHour(roomCreateRequest.getPrice());
        room.setImage_type(roomCreateRequest.getImage());

        RoomItem roomItem=new RoomItem();
        List<RoomItemRequest> roomItemRequests=roomCreateRequest.getItems();

        for (RoomItemRequest i: roomItemRequests){
            roomItem.setDescription(i.getRoomItem());
            roomItem.setQuantity(i.getQuantity());
            roomItemRepository.save(roomItem);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(roomCreateRequest);
    }
}
