package com.cletus.ejercicio.controller;

import com.cletus.ejercicio.model.dto.Response;
import com.cletus.ejercicio.model.dto.UserCreateDto;
import com.cletus.ejercicio.model.dto.UserDto;
import com.cletus.ejercicio.model.dto.UserListDto;
import com.cletus.ejercicio.service.IResponseService;
import com.cletus.ejercicio.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired private IResponseService responseService;
    @Autowired private IUserService userService;

    @PostMapping()
    public Response create(@Valid @RequestBody UserCreateDto userCreateDto, Errors error) {
        if (error.hasErrors()){
            return responseService.response(422,"Params error.");
        }
        userService.save(userCreateDto);
        return responseService.response(200);
    }

    @GetMapping("/{id}")
    public Response get(@PathVariable("id") Long id){
        UserDto userDto = userService.get(id);
        return responseService.data(userDto);
    }

    @GetMapping()
    public Response getAll(){
        UserListDto userListDto = userService.getAll();
        return responseService.data(userListDto);
    }

    @PatchMapping("/{id}")
    public Response update(@PathVariable("id") Long id, @RequestBody UserCreateDto userCreateDto){
        userService.update(id,userCreateDto);
        return responseService.response(200);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        userService.delete(id);
        return responseService.response(200);
    }

    @DeleteMapping()
    public Response deleteAll(){
        userService.delete();
        return responseService.response(200);
    }


}
