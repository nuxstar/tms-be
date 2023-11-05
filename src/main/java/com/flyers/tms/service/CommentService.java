package com.flyers.tms.service;

import com.flyers.tms.model.dto.CommentDto;
import com.flyers.tms.model.entity.Ticket;
import java.util.List;

/**
 * The Comment Service interface.
 */
public interface CommentService {
  /**
   * saves comment into the database.
   */
  Ticket addComment(String ticketId, String employeeId, CommentDto comment);

  List<CommentDto> getTicketComments(String ticketId);

}
