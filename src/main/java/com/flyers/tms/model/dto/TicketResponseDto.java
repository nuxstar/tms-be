package com.flyers.tms.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.flyers.tms.model.entity.Comment;
import com.flyers.tms.model.entity.enums.Priority;
import com.flyers.tms.model.entity.enums.Status;
import java.util.List;
import lombok.Data;

/**
 * The ticket response dto.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketResponseDto {

  private String id;

  private String title;

  private String description;

  private Priority priority;

  private Status status;

  private List<String> images;

  private String createdBy;

  private String assignedTo;

  private List<Comment> comments;
}
