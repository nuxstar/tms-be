package com.flyers.tms.exception;


/**
 * Not found custom exception handler class.
 */
public class NotFoundException extends TmsException {

  public static final String TICKET_NOT_FOUND = "Ticket with ID %s not found";

  public NotFoundException(String message) {
    super(message);
  }
}
