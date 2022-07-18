package com.example.officebookingsystem.domain.dto.response;

import java.util.List;

import com.example.officebookingsystem.domain.model.EStatus;

import lombok.Data;

@Data
public class UserListRoom {
    private String nama;
    private Double pricePerHour;
    private Integer rating;
    private EStatus status;
    private List<String> itemName;
}
