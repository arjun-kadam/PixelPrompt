package com.pixelprompt.service.impl;

import com.pixelprompt.entity.User;
import com.pixelprompt.enums.USER_PROFILE_VISIBILITY;
import com.pixelprompt.exceptions.PixelException;
import com.pixelprompt.mappers.UserMapper;
import com.pixelprompt.payload.request.UserRegistrationRequest;
import com.pixelprompt.payload.response.UserRegistrationResponse;
import com.pixelprompt.repository.AuthRepository;
import com.pixelprompt.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final AuthRepository authRepository;

    @Override
    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
       if(authRepository.existsByEmailOrUsername(request.getEmail(), request.getUsername().toLowerCase())){
           throw new PixelException(409,"User Already Exist with Email or Username");
       }

        User user = UserMapper.INSTANCE.requestToEntity(request);
        user.setProfileVisibility(USER_PROFILE_VISIBILITY.PUBLIC);
        authRepository.save(user);
        return UserMapper.INSTANCE.entityToRequest(user);
    }
}
