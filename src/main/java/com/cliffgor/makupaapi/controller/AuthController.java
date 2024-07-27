package com.cliffgor.makupaapi.controller;



import com.cliffgor.makupaapi.model.LoginRequest;
import com.cliffgor.makupaapi.model.User;
import com.cliffgor.makupaapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser (@RequestBody User user) {
        User registeredUser = authService.registerUser(user);
        return ResponseEntity.ok("User registered successfully. Please check your email for OTP.");
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        String token = authService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword(), loginRequest.getOtp());
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().body("Invalid credentials or OTP");
    }


}
