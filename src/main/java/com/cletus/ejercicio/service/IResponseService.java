package com.cletus.ejercicio.service;

import com.cletus.ejercicio.model.dto.Response;

public interface IResponseService {

   <T> Response data(T data);

   <T> Response response(int code);

   <T> Response response(int code,String description);

   <T> Response response(int code, String description, T data);
}
