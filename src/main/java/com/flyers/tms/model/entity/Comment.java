package com.flyers.tms.model.entity;

import java.util.List;
import lombok.Data;

/**
 * The Comment entity.
 */
@Data
public class Comment {

  private String id;

  private Integer rank;

  private String employeeId;

  private String description;

  private List<String> images;

}
