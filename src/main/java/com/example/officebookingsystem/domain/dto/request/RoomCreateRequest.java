package com.example.officebookingsystem.domain.dto.request;

import com.example.officebookingsystem.domain.entity.Room;
import com.example.officebookingsystem.domain.entity.RoomSpecification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomCreateRequest {
    private String roomName;
    private String building_name;
    private String description;
    private Double pricePerHour;
    private String room_image;
    private Integer floor;
    private Integer capacity;
    private Integer large;
    private List<RoomItemRequest> items;




}
