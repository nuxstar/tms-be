package com.flyers.tms.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Unauthorized custom exception class.
 */
@Getter
@Setter
public class UnAuthorizedException extends TmsException {

  public static final String INVALID_TOKEN = "Invalid Access Token";

  public UnAuthorizedException(String message) {
    super(message);
  }
}
