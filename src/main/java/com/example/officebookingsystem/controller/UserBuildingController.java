package com.example.officebookingsystem.controller;

import com.example.officebookingsystem.domain.dto.response.UserAllBuildingResponse;
import com.example.officebookingsystem.domain.dto.response.UserResponseBuilding;
import com.example.officebookingsystem.service.UserBuildingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/page/user/building")
@CrossOrigin(origins = "*", maxAge = 3600L)
@Api(tags = "User View Building API", description = "Buildings")
public class UserBuildingController {
    @Autowired
    private UserBuildingService userBuildingService;

    @GetMapping("/list")
    @ApiOperation(value = "List All Building", notes = "Endpont for Listing All Builings")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<UserAllBuildingResponse>> listBuildings() {
        return userBuildingService.getAllBuildings();
    }

    @GetMapping("/list/{id}")
    @ApiOperation(value = "List Building", notes = "Endpoint for Listing all Building by City Id")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<UserResponseBuilding>> listBuildingByCity(@PathVariable("id") Long id) {
        return userBuildingService.getAllBuildingsByCity(id);
    }

}
