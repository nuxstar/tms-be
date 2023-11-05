package com.flyers.tms.exception;

/**
 * The illegal argument exception class.
 */
public class IllegalArgumentException extends TmsException {

  public static  final String ILLEGAL_ARGUMENT_EXCEPTION_PAGE =
      "page number must be integer value";

  public static  final String ILLEGAL_ARGUMENT_EXCEPTION_OFFSET =
      "offset number must be integer value";

  public IllegalArgumentException(String message) {
    super(message);
  }

}
