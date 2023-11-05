package com.flyers.tms.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

/**
 * The ticket request dto.
 */
@Data
public class TicketRequestDto {

  @NotBlank(message = "Title is mandatory")
  @Size(min = 10, max = 100, message = "Title size must be between 3 to 30")
  @Pattern(
      regexp = "^[A-Za-z0-9 ]+$",
      message = "Title must not contain special characters"
  )
  private String title;

  @NotBlank(message = "Description is mandatory")
  @Size(min = 10, message = "Description size must be between 3 to 30")
  private String description;

  private List<String> images;
}
