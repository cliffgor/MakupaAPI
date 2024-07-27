package com.cliffgor.makupaapi.repository;

import com.cliffgor.makupaapi.model.OTP;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OTPRepository extends MongoRepository<OTP, String> {
    OTP findByUserIdAndCode(String userId, String code);
}
