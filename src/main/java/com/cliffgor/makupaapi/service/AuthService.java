package com.cliffgor.makupaapi.service;

import com.cliffgor.makupaapi.model.OTP;
import com.cliffgor.makupaapi.model.User;
import com.cliffgor.makupaapi.repository.OTPRepository;
import com.cliffgor.makupaapi.repository.UserRepository;
import com.cliffgor.makupaapi.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OTPRepository otpRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setVerified(false);
        User savedUser = userRepository.save(user);

        String otp = generateOTP();
        saveOTP(savedUser.getId(), otp);

        try {
            emailService.sendOTPEmail(user.getEmail(), otp);
        } catch (IOException e) {
            //Handle email failiure
        }
        return savedUser;
    }

    public String authenticateUser (String email, String password, String otp) {
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            if(!user.isVerified()){
                OTP otpEntity = otpRepository.findByUserIdAndCode(user.getId(), otp);
                if(otpEntity != null && !isOTPExpired(otpEntity)) {
                    user.setVerified(true);
                    userRepository.save(user);
                    otpRepository.delete(otpEntity);
                } else {
                    return null;
                }
            }
            return jwtUtil.generateToken(user.getUsername());
        }
        return null;
    }

    public String generateOTP() {
        return String.format("%06d", new Random().nextInt(999999));
    }

    private void saveOTP(String userId, String otp) {
        OTP otpEntity = new OTP();
        otpEntity.setUserId(userId);
        otpEntity.setCode(otp);
        otpEntity.setExpiryDate(LocalDateTime.now().plusMinutes(15));
        otpRepository.save(otpEntity);
    }

    private boolean isOTPExpired(OTP otp) {
        return LocalDateTime.now().isAfter(otp.getExpiryDate())
    }

}
