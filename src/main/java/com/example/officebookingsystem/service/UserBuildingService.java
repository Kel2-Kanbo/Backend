package com.example.officebookingsystem.service;

import com.example.officebookingsystem.domain.dto.response.ResponseData;
import com.example.officebookingsystem.domain.dto.response.UserAllBuildingResponse;
import com.example.officebookingsystem.domain.dto.response.UserResponseBuilding;
import com.example.officebookingsystem.domain.entity.Building;
import com.example.officebookingsystem.domain.entity.City;
import com.example.officebookingsystem.domain.entity.Facility;
import com.example.officebookingsystem.domain.repository.BuildingRepository;
import com.example.officebookingsystem.domain.repository.CityRepository;
import com.example.officebookingsystem.domain.repository.FacilityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserBuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    public ResponseEntity<List<UserResponseBuilding>> getAllBuildingsByCity(Long id) {
        Optional<City> city = cityRepository.findById(id);

        if (!city.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(buildingRepository.getAllBuildingsById((id)));
    }

    public ResponseEntity<List<UserAllBuildingResponse>> getAllBuildings() {
        List<UserAllBuildingResponse> userAllBuildingResponses = new ArrayList<>();
        List<Building> buildings = buildingRepository.findAll();
        if (buildings.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        for (Building b : buildings) {
            UserAllBuildingResponse urb = new UserAllBuildingResponse();
            urb.setId(b.getId());
            urb.setName(b.getName());
            urb.setBuilding_image(b.getBuilding_image());
            urb.setImage_type(b.getImage_type());
            urb.setAddress(b.getAddress());
            urb.setDescription(b.getDescription());
            List<Facility> facility = facilityRepository.findFacilityByBuidling(b.getId());
            if (!facility.isEmpty()) {
                urb.setNerby_facilities(facility);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(userAllBuildingResponses);
    }

}
