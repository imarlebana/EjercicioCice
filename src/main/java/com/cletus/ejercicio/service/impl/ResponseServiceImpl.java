package com.cletus.ejercicio.service.impl;

import com.cletus.ejercicio.model.dto.Response;
import com.cletus.ejercicio.service.IResponseService;
import org.springframework.stereotype.Service;

@Service
public class ResponseServiceImpl implements IResponseService {
    @Override
    public <T> Response data(T data) {
       return response(200,"OK", data);
    }

    @Override
    public <T> Response response(int code) {
        return response(code,null);
    }

    @Override
    public <T> Response response(int code, String description) {
        return response(code,description,null);
    }

    @Override
    public <T> Response response(int code,String description, T data) {
        Response<T> response = new Response<>();
        response.setCode(code);
        response.setDescription(description);
        response.setData(data);
        return response;
    }
}
