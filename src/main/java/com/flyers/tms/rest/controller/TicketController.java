package com.flyers.tms.rest.controller;

import com.flyers.tms.model.dto.CustomPageDto;
import com.flyers.tms.model.dto.TicketRequestDto;
import com.flyers.tms.model.dto.TicketResponseDto;
import com.flyers.tms.model.dto.TmsResponse;
import com.flyers.tms.model.entity.Ticket;
import com.flyers.tms.service.TicketService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * The ticket controller class.
 */
@RestController
@RequestMapping("/v1")
public class TicketController {

  private static final Logger log = LoggerFactory.getLogger(TicketController.class);

  @Autowired
  private TicketService ticketService;

  /**
   * To create ticket.
   *
   * @param ticketRequestDto ticketRequestDto
   * @return created ticket details
   */
  @PostMapping("/tickets/{employeeId}")
  public ResponseEntity<TmsResponse<TicketResponseDto>> createTicket(
      @PathVariable final String employeeId,
      @RequestBody @Valid final TicketRequestDto ticketRequestDto) {
    log.debug("Creating ticket with title: {}", ticketRequestDto.getTitle());
    TicketResponseDto response = ticketService.createTicket(employeeId, ticketRequestDto);
    return new ResponseEntity<>(new TmsResponse<>(
        HttpStatus.CREATED.value(), true, response), HttpStatus.CREATED);
  }


  /**
   * To get all ticket details.
   *
   * @param pageNo page
   * @param offSet offset
   * @return all ticket details
   */
  @GetMapping("/tickets")
  public ResponseEntity<TmsResponse<CustomPageDto<Ticket>>> readAllTicket(
      @RequestParam(name = "pageNo", defaultValue = "0") final int pageNo,
      @RequestParam(name = "offSet", defaultValue = "10") final int offSet) {
    log.debug("Getting all ticket details");
    CustomPageDto<Ticket> ticketResponse = ticketService.readAllTickets(pageNo, offSet);
    return new ResponseEntity<>(new TmsResponse<>(
        HttpStatus.OK.value(), true, ticketResponse), HttpStatus.OK);
  }

  /**
   * To upload image.
   *
   * @param file file
   *
   * @return uploaded path
   *
   * @throws IOException  IOException
   */
  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
    return ticketService.uploadFile(file);
  }

  /**
   * Delete image.
   *
   * @param id id
   *
   * @return successful message
   */
  @DeleteMapping("/images/{id}")
  public ResponseEntity
      <TmsResponse<String>> deleteImage(@PathVariable("id") String id) {
    String deleted = ticketService.deleteFile(id);
    return new ResponseEntity<>(new TmsResponse<>(HttpStatus.NO_CONTENT.value(), true, deleted), HttpStatus.NO_CONTENT);
  }

}
