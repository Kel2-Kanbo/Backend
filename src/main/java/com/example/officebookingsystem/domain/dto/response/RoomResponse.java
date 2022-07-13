package com.example.officebookingsystem.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RoomResponse {
    private String roomName;
    private Integer floor;
    private String roomItem;
    private Double price;
    private String Status;
}
