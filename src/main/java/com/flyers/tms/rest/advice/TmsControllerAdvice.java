package com.flyers.tms.rest.advice;

import com.flyers.tms.exception.IllegalArgumentException;
import com.flyers.tms.exception.NotFoundException;
import com.flyers.tms.exception.TmsException;
import com.flyers.tms.model.dto.TmsErrorResponse;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The controller advice class.
 */
@RestControllerAdvice
public class TmsControllerAdvice {

  /**
   * This exception will catch the illegal argument and throw a proper message.
   *
   * @param exception exception
   *
   * @return error message
   */
  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public TmsErrorResponse illegalArgument(TmsException exception) {
    return new TmsErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        exception.getMessage()
    );
  }

  /**
   * This exception catch custom validation and throw proper message.
   *
   * @param exception exception
   *
   * @return proper error message
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public TmsErrorResponse customValidation(MethodArgumentNotValidException exception) {
    String errorMessage = "Invalid input.";
    Optional<FieldError> error = exception.getBindingResult().getFieldErrors().stream().findFirst();
    if (error.isPresent()) {
      errorMessage = error.get().getDefaultMessage();
    }
    return new TmsErrorResponse(
        HttpStatus.BAD_REQUEST.value(),
        errorMessage);
  }

  /**
   * Not found exception handling for tms application.
   */
  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public TmsErrorResponse notFoundException(
      NotFoundException ex) {
    return new TmsErrorResponse(
        HttpStatus.NOT_FOUND.value(),
        ex.getMessage()
    );
  }
}

