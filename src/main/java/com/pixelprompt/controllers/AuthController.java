package com.pixelprompt.controllers;

import com.pixelprompt.payload.request.UserRegistrationRequest;
import com.pixelprompt.payload.response.UserRegistrationResponse;
import com.pixelprompt.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse> registerUser(@Valid @RequestBody UserRegistrationRequest request){
        return ResponseEntity.ok(authService.registerUser(request));
    }

    @GetMapping
    private String getmsg(){
        return "Arjun";
    }

}
