package com.flyers.tms.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Comment Dto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDto {

  private String id;

  private int rank;

  @NotNull(message = "description is mandatory")
  @Size(min = 10, max = 500, message = "description must be between 2 to 30")
  private String description;

  private List<String> images;
}
