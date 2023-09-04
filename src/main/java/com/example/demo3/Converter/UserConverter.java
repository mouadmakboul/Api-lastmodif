package com.example.demo3.Converter;

import com.example.demo3.Entities.UserEntity.UserDto;
import com.example.demo3.Entities.UserEntity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto entityToDTO(UserEntity userEntity) {
        return new UserDto() {{
            setId(userEntity.getId());
            setUsername(userEntity.getUsername());
            setFirstname(userEntity.getFirstname());
            setLastname(userEntity.getLastname());
            setEmail(userEntity.getEmail());
            setNumero(userEntity.getNumero());
        }};
    }
}

