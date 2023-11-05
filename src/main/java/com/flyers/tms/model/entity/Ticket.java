package com.flyers.tms.model.entity;

import com.flyers.tms.model.entity.enums.Priority;
import com.flyers.tms.model.entity.enums.Status;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The Ticket entity.
 */
@Document(collection = "tickets")
@Data
public class Ticket {

  @Id
  private String id;

  private String title;

  private String description;

  private Priority priority = Priority.LOW;

  private Status status = Status.TODO;

  private List<String> images;

  private String createdBy;

  private String assignedTo;

  private List<Comment> comments;

}
