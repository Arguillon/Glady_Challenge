package com.glady.challenge.mapper;

import com.glady.challenge.data.entity.UserClient;
import com.glady.challenge.model.UserClientModel;
import org.mapstruct.Mapper;

@Mapper
public interface UserClientModelMapper {
    UserClientModel toDestination(UserClient userClient);

    UserClient toSource(UserClientModel userClient);


}
