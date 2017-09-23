package com.estudojavaspring.ProjetoEstudoSpring.handler;

import com.estudojavaspring.ProjetoEstudoSpring.Error.ErrorsDetail;
import com.estudojavaspring.ProjetoEstudoSpring.Error.ResourceNotFoundDetails;
import com.estudojavaspring.ProjetoEstudoSpring.Error.ResourceNotFoundException;
import com.estudojavaspring.ProjetoEstudoSpring.Error.ValidationErrorsDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Crisley Alves on 23, set, 2017
 **/

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException){

        ResourceNotFoundDetails errorMessage = ResourceNotFoundDetails
                .Builder
                .newBuilder()
                .timeStamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not Found")
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();

        return new ResponseEntity<Object>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manvException,
                                                          HttpHeaders headers,
                                                          HttpStatus status,
                                                          WebRequest request) {

        List<FieldError> errorList =manvException.getBindingResult().getFieldErrors();

        String fields = errorList.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String messages = errorList.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));

        ValidationErrorsDetails errorMessage = ValidationErrorsDetails
                .Builder
                .newBuilder()
                .timeStamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Field Validation Error")
                .field(fields)
                .fieldMessage(messages)
                .detail("Field Validation Error")
                .developerMessage(manvException.getClass().getName())
                .build();

        return new ResponseEntity<Object>(errorMessage, HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                             Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {
        ErrorsDetail errorMessage = ResourceNotFoundDetails
                .Builder
                .newBuilder()
                .timeStamp(new Date().getTime())
                .status(status.value())
                .title("Internal Exception")
                .detail(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build();

        return new ResponseEntity<>(errorMessage, headers, status);
    }


}
