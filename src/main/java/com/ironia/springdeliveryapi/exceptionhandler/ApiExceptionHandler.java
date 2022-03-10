package com.ironia.springdeliveryapi.exceptionhandler;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Problema.Campo> campos = ex.getBindingResult().getAllErrors().stream()
                .map(e -> new Problema.Campo(((FieldError) e).getField(), messageSource.getMessage(e, LocaleContextHolder.getLocale())))
                .collect(Collectors.toList());

        Problema problema = new Problema(status.value(), LocalDateTime.now(),
                "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.", campos);

        return handleExceptionInternal(ex, problema, headers, status, request);
    }
}
