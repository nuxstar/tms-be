package com.flyers.tms.rest.controller;

import com.flyers.tms.model.dto.CommentDto;
import com.flyers.tms.model.dto.TmsResponse;
import com.flyers.tms.service.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Comment Controller.
 */
@RestController
@Validated
public class CommentController {

  @Autowired
  CommentService commentService;

  /**
   * add issue api.
   */
  @PreAuthorize("")
  @PostMapping("/v1/tickets/{ticketId}/employees/{employeeId}/comments")
  public ResponseEntity<TmsResponse<String>> addIssue(
      @PathVariable String ticketId,
      @PathVariable String employeeId,
      @RequestBody CommentDto commentDto
  ) {
    commentService.addComment(ticketId, employeeId, commentDto);
    return new ResponseEntity<>(
        new TmsResponse<>(
            HttpStatus.CREATED.value(),
            true,
            "Comment added successfully"
        ),
        HttpStatus.CREATED
    );
  }

  /**
   * The Comment entity.
   */
  @GetMapping("/v1/tickets/{ticketId}/comments")
  public ResponseEntity<TmsResponse<List<CommentDto>>> getCommentsOfTickets(
      @PathVariable(name = "ticketId") String ticketId
  ) {
    return new ResponseEntity<>(
        new TmsResponse<>(
            HttpStatus.ACCEPTED.value(),
            true,
            commentService.getTicketComments(ticketId)
        ),
        HttpStatus.OK
    );
  }
}
