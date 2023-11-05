package com.flyers.tms.mapper;

import com.flyers.tms.model.dto.CommentDto;
import com.flyers.tms.model.entity.Comment;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * The Comment Dto.
 */
@Mapper(componentModel = "spring")
public interface CommentMapper {
  CommentDto toDto(Comment comments);

  List<CommentDto> toDto(List<Comment> comments);

  Comment toEntity(CommentDto commentDto);

}
