package com.example.officebookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.officebookingsystem.domain.dto.response.UserDetailRoomResponse;
import com.example.officebookingsystem.domain.dto.response.UserListRoom;
import com.example.officebookingsystem.domain.dto.response.UserResponseBuilding;
import com.example.officebookingsystem.service.UserRoomService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/page/user/room")
@CrossOrigin(origins = "*", maxAge = 3600L)
@Api(tags = "User View Room API", description = "Rooms")
public class UserRoomController {
    @Autowired
    private UserRoomService userRoomService;

    @GetMapping("/list/{id}")
    @ApiOperation(value = "List Rooms", notes = "Endpoint for Listing all Room by Building Id")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<UserListRoom>> listRoom(@PathVariable("id") Long idBuilding) {
        return userRoomService.getAllRoomsByIdBuilding(idBuilding);
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "Detail Room", notes = "Endpoint for Detail Room by Id")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<UserDetailRoomResponse> detailRoom(@PathVariable("id") Long id) {
        return userRoomService.getDetailRoom(id);
    }
}
