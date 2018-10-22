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
@RequestMapping("/user")
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

    @GetMapping()
    public Response get(@RequestParam(name = "id", required = false) Long id){
        if(id==null){
            UserListDto users  = userService.getAll();
            return responseService.data(users);
        }
        UserDto userDto = userService.get(id);
        return responseService.data(userDto);
    }

    @PatchMapping()
    public Response update(@RequestParam("id") Long id, @RequestBody UserCreateDto userCreateDto){
        userService.update(id,userCreateDto);
        return responseService.response(200);
    }

    @DeleteMapping()
    public Response delete(@RequestParam(name = "id", required = false) Long id){
        userService.delete(id);
        return responseService.response(200);
    }


}
