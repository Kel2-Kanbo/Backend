package com.example.officebookingsystem.domain.dto.response;

import java.util.List;

import com.example.officebookingsystem.domain.entity.Review;
import com.example.officebookingsystem.domain.entity.Room;
import com.example.officebookingsystem.domain.entity.RoomItem;
import com.example.officebookingsystem.domain.entity.RoomSpecification;

import lombok.Data;

@Data
public class UserDetailRoomResponse {
    private Room room;
    private Integer rating;
    private RoomSpecification roomSpecification;
    private List<RoomItem> roomItems;
    private List<Review> reviews;
}