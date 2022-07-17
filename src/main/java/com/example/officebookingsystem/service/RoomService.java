package com.example.officebookingsystem.service;

import com.example.officebookingsystem.domain.dto.request.RoomCreateRequest;
import com.example.officebookingsystem.domain.dto.request.RoomItemRequest;
import com.example.officebookingsystem.domain.dto.response.MessageResponse;
import com.example.officebookingsystem.domain.entity.Room;
import com.example.officebookingsystem.domain.entity.RoomItem;
import com.example.officebookingsystem.domain.model.EStatus;
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
import java.util.Optional;

@Service
@Transactional
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomItemRepository roomItemRepository;

    public ResponseEntity<?> create(RoomCreateRequest roomCreateRequest){
        if (roomRepository.existByName(roomCreateRequest.getRoomName())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Room name is already exist!"));
        }
        Room room= new Room();
        room.setName(roomCreateRequest.getBuilding_name());
        room.setName(roomCreateRequest.getRoomName());
        room.setPricePerHour(room.getPricePerHour());
        room.setRoom_image(room.getRoom_image());
        room.setFloor(roomCreateRequest.getFloor());
        room.setStatus(EStatus.AVAILABLE);
        roomRepository.save(room);

        RoomItem roomItem=new RoomItem();
        List<RoomItemRequest> roomItemRequests=roomCreateRequest.getItems();

        for (RoomItemRequest r: roomItemRequests){
            Optional<Room> roomOptional=roomRepository.findById(room.getId());
            roomItem.setId(room.getId());
            roomItem.setItemName(roomItem.getItemName());
            roomItem.setQuantity(roomItem.getQuantity());
            roomItem.setRoom(roomOptional.get());
            roomItemRepository.save(roomItem);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(roomCreateRequest);
    }
}
