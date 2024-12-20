package cl.ipss.api.eva03.apieva03.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cl.ipss.api.eva03.apieva03.responses.DocenteResponse;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value=RuntimeException.class)
    public ResponseEntity<Object> RuntimeExceptionHandler(RuntimeException ex){
        DocenteResponse docenteResponse = new DocenteResponse(); 
        docenteResponse.setStatus(400);
        docenteResponse.setMessage(ex.getMessage());

        return ResponseEntity.badRequest()
        .body(docenteResponse);
    }

}
