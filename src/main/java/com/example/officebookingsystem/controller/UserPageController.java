package com.example.officebookingsystem.controller;

import com.example.officebookingsystem.domain.dto.response.UserPageResponse;
import com.example.officebookingsystem.domain.entity.Complex;
import com.example.officebookingsystem.domain.repository.UserPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/page/user")

public class UserPageController {
    @Autowired
    private UserPageRepository userPageRepository;

    @GetMapping("/getComplexByCity")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<UserPageResponse>> getComplexByCity(){
        return ResponseEntity.ok(userPageRepository.getComplexByCity());
    }
}
