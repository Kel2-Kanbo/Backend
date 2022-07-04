package com.example.officebookingsystem.domain.dto.response;

import java.util.List;

import com.example.officebookingsystem.domain.entity.Facility;
import com.example.officebookingsystem.domain.entity.Room;

import lombok.Data;

@Data
public class UserAllBuildingResponse {
    private Long id;
    private String name;
    private String building_image;
    private String image_type;
    private String address;
    private String description;
    private List<Facility> nerby_facilities;
    private List<Room> available_rooms;
}
