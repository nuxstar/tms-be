package com.flyers.tms.service;

import com.flyers.tms.model.dto.CustomPageDto;
import com.flyers.tms.model.dto.TicketRequestDto;
import com.flyers.tms.model.dto.TicketResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * The ticket service class.
 */
public interface TicketService {

  /**
   * Create ticket details.
   *
   * @param employeeId employeeId
   *
   * @param ticketRequestDto ticketRequestDto
   *
   * @return created ticket details
   */
  TicketResponseDto createTicket(String employeeId, TicketRequestDto ticketRequestDto);

  /**
   * Read all tickets.
   *
   * @param page page
   *
   * @param offset offset
   *
   * @return get all ticket details
   */
  CustomPageDto readAllTickets(int page, int offset);

  /**
   * To upload a image.
   *
   * @param file file
   *
   * @return stored path
   */
  String uploadFile(MultipartFile file) throws IOException;

  /**
   * To delete image.
   *
   * @param id id
   *
   * @return deleted message
   */
  String deleteFile(String id);

  default void del(){

  }
}
