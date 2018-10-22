package com.cletus.ejercicio.service;

import com.cletus.ejercicio.model.dto.UserCreateDto;
import com.cletus.ejercicio.model.dto.UserDto;
import com.cletus.ejercicio.model.dto.UserListDto;

public interface IUserService {

    void save(UserCreateDto userCreateDto);

    UserListDto getAll();

    UserDto get(Long id);

    void update(Long id,UserCreateDto userCreateDto);

    void delete(Long id);

    void delete();
}
