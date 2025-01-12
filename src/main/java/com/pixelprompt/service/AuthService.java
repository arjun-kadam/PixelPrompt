package com.pixelprompt.service;

import com.pixelprompt.payload.request.UserRegistrationRequest;
import com.pixelprompt.payload.response.UserRegistrationResponse;

public interface AuthService {
    UserRegistrationResponse registerUser(UserRegistrationRequest request);
}
