package com.example.officebookingsystem.controller;

import com.example.officebookingsystem.domain.dto.request.LoginRequest;
import com.example.officebookingsystem.domain.dto.request.SignupRequest;
import com.example.officebookingsystem.domain.dto.response.MessageResponse;
import com.example.officebookingsystem.domain.dto.response.UserInfoResponse;
import com.example.officebookingsystem.domain.entity.Role;
import com.example.officebookingsystem.domain.entity.User;
import com.example.officebookingsystem.domain.model.ERole;
import com.example.officebookingsystem.domain.repository.RoleRepository;
import com.example.officebookingsystem.domain.repository.UserRepository;
import com.example.officebookingsystem.security.jwt.JwtUtils;
import com.example.officebookingsystem.domain.implement.UserDetailImpl;
import com.example.officebookingsystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.signIn(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        return authService.signUp(signupRequest);
    }


    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser(){
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
}

