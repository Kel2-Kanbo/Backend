package com.example.officebookingsystem.controller;

import com.example.officebookingsystem.domain.dto.request.RoomCreateRequest;
import com.example.officebookingsystem.service.RoomItemService;
import com.example.officebookingsystem.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/page")
@CrossOrigin(origins = "*", maxAge = 3600L)
@Api(tags = "Admin Managing Room and Items Room API")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomItemService roomItemService;

    @ApiOperation(value = "Create room", notes = "Endpoint for admin creating the room")
    @PostMapping("/admin/room/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createRoom(@Valid @RequestBody
                                        RoomCreateRequest roomCreateRequest){
        return roomService.create(roomCreateRequest);
    }
}
