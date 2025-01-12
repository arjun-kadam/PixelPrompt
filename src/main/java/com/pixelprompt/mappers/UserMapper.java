package com.pixelprompt.mappers;

import com.pixelprompt.entity.User;
import com.pixelprompt.payload.request.UserRegistrationRequest;
import com.pixelprompt.payload.response.UserRegistrationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    User requestToEntity(UserRegistrationRequest userRegistrationRequest);
    UserRegistrationResponse entityToRequest(User user);
}
