package com.cletus.ejercicio.converter;


import com.cletus.ejercicio.model.dto.UserCreateDto;
import com.cletus.ejercicio.model.dto.UserDto;
import com.cletus.ejercicio.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    public User toEntity(UserCreateDto userCreateDto){
        User u = new User();
        u.setName(userCreateDto.getName());
        u.setSurname(userCreateDto.getSurname());
        return u;
    }

    public User toEntity(User u, UserCreateDto userCreateDto){
        if (u == null){return null;}

        if(userCreateDto.getName()!=null){ u.setName(userCreateDto.getName());}
        if(userCreateDto.getSurname()!=null){ u.setSurname(userCreateDto.getSurname());}

        return u;
    }

    public UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        return userDto;
    }

    public List<UserDto> toDto(List<User> user){
        List<UserDto> userDtos = new ArrayList<>();

        if (user == null) { return userDtos; }

        for (User u : user){
            if(u!=null){ userDtos.add(toDto(u)); }
        }

        return userDtos;
    }

}
