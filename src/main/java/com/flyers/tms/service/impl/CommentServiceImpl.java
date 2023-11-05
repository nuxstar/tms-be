package com.flyers.tms.service.impl;

import com.flyers.tms.exception.NotFoundException;
import com.flyers.tms.mapper.CommentMapper;
import com.flyers.tms.model.dto.CommentDto;
import com.flyers.tms.model.entity.Comment;
import com.flyers.tms.model.entity.Ticket;
import com.flyers.tms.model.repository.TicketRepository;
import com.flyers.tms.service.CommentService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Comment Service Implementation.
 */
@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  TicketRepository ticketRepository;

  @Autowired
  CommentMapper commentMapper;

  @Override
  public Ticket addComment(String ticketId, String employeeId, CommentDto commentDto) {
    Ticket ticket = ticketRepository
        .findById(ticketId)
        .orElseThrow(
            () -> new NotFoundException(
                String.format(
                    NotFoundException.TICKET_NOT_FOUND,
                    ticketId
                )
            )
        );

    List<Comment> comments = ticket.getComments();
    Comment newComment = commentMapper.toEntity(commentDto);
    newComment.setEmployeeId(employeeId);
    UUID uuid = UUID.randomUUID();
    newComment.setId(uuid.toString());
    // update the rank of the new comment
    newComment.setRank(comments.size() + 1);
    comments.add(newComment);

    ticket.setComments(comments);
    ticketRepository.save(ticket);
    return ticket;
  }

  @Override
  public List<CommentDto> getTicketComments(String ticketId) {
    Ticket ticket = ticketRepository
        .findById(ticketId)
        .orElseThrow(
            () -> new NotFoundException(
                String.format(
                    NotFoundException.TICKET_NOT_FOUND,
                    ticketId
                )
            )
        );

    List<Comment> comments = ticket.getComments();
    // sort comments based on Rank
    if (comments.size() > 1) {
      comments.sort(
          (Comment comment1, Comment comment2) -> {
            return comment1.getRank().compareTo(comment2.getRank());
          }
      );
    }
    return commentMapper.toDto(comments);
  }
}
