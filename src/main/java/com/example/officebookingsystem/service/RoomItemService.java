package com.example.officebookingsystem.service;

import com.example.officebookingsystem.domain.entity.RoomItem;
import com.example.officebookingsystem.domain.repository.RoomItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomItemService {
    @Autowired
    private RoomItemRepository roomItemRepository;

    public ResponseEntity<List<RoomItem>> listRoomItems(){
        List<RoomItem> roomItems= roomItemRepository.findAll();
        if (roomItems.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return  ResponseEntity.status(HttpStatus.OK).body(roomItems);
    }

}
