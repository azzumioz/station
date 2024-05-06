package ru.lightapps.measurstation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.lightapps.measurstation.util.exception.ErrorInfo;
import ru.lightapps.measurstation.util.exception.NotConnectionException;
import ru.lightapps.measurstation.util.exception.NotFoundException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionInfoHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ErrorInfo notFound(HttpServletRequest req, Exception e) {
        return new ErrorInfo(req.getRequestURL(), e.getLocalizedMessage());
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotConnectionException.class)
    @ResponseBody
    public ErrorInfo notConnection(HttpServletRequest req, Exception e) {
        return new ErrorInfo(req.getRequestURL(), e.getLocalizedMessage());
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorInfo illegalArgument(HttpServletRequest req, IllegalArgumentException e) {
        return new ErrorInfo(req.getRequestURL(), e.getLocalizedMessage());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorInfo throwException(HttpServletRequest req, MethodArgumentTypeMismatchException e) {
        return new ErrorInfo(req.getRequestURL(), e.getLocalizedMessage());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NullPointerException.class)
    public ErrorInfo nullEntity(HttpServletRequest req, NullPointerException e) {
        return new ErrorInfo(req.getRequestURL(), e.getLocalizedMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInfo handleError(HttpServletRequest req, Exception e) {
        return new ErrorInfo(req.getRequestURL(), e.getLocalizedMessage());
    }


}
