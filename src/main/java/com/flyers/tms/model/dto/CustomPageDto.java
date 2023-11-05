package com.flyers.tms.model.dto;

import lombok.Data;

/**
 * The custom page dto.
 *
 * @param <T> data
 */
@Data
public class CustomPageDto<T> {

  private T content;
  private long totalElements;
  private int totalPages;
  private int offset;
  private int page;
  private int numberOfElements;
}
