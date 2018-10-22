package com.cletus.ejercicio.service.impl;

import com.cletus.ejercicio.converter.UserConverter;
import com.cletus.ejercicio.model.dto.UserCreateDto;
import com.cletus.ejercicio.model.dto.UserDto;
import com.cletus.ejercicio.model.dto.UserListDto;
import com.cletus.ejercicio.model.entity.User;
import com.cletus.ejercicio.repository.UserRepository;
import com.cletus.ejercicio.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired private UserConverter userConverter;
    @Autowired private UserRepository userRepository;

    @Override
    public void save(UserCreateDto userCreateDto) {
        User u = userConverter.toEntity(userCreateDto);
        userRepository.save(u);
    }

    @Override
    public UserListDto getAll() {

        //USE LAMBDA TO CONVERTER

        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = userConverter.toDto(users);
        UserListDto userListDto = new UserListDto();
        userListDto.setUsers(usersDto);
        return userListDto;
    }

    @Override
    public UserDto get(Long id) {
        Optional<User> opt = userRepository.findById(id);
        if(!opt.isPresent()){
            throw new IllegalArgumentException("El recurso no existe");
        }
        User u =opt.get();
        UserDto userDto = userConverter.toDto(u);
        return userDto;
    }

    @Override
    public void update(Long id, UserCreateDto userCreateDto) {
        if( id==null || userCreateDto ==null){ throw new IllegalArgumentException("Faltan parametros"); }

        Optional<User> opt = userRepository.findById(id);
        if (!opt.isPresent()){ throw new IllegalArgumentException("No existe usuario con ese id."); }

        User u = opt.get();
        u = userConverter.toEntity(u,userCreateDto);
        userRepository.save(u);
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            userRepository.deleteAll();
        }else{
            Optional<User> opt = userRepository.findById(id);
            if(!opt.isPresent()){
                throw new IllegalArgumentException("El recurso no existe");
            }
            User u = opt.get();
            userRepository.delete(u);
        }
    }

    @Override
    public void delete() {
        userRepository.deleteAll();
    }

}
