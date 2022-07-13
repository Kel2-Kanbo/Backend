package com.example.officebookingsystem.domain.dto.request;

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
    private Long building_id;
    private String description;
    private List<RoomItemRequest> items;
    private Double price;
    private String image;


}
