package com.flyers.tms.mapper;

import com.flyers.tms.model.dto.CustomPageDto;
import com.flyers.tms.model.dto.TicketRequestDto;
import com.flyers.tms.model.dto.TicketResponseDto;
import com.flyers.tms.model.entity.Ticket;
import java.util.List;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

/**
 * The ticket mapper class.
 */
@Mapper(componentModel = "spring")
public interface TicketMapper {

  Ticket toEntity(TicketRequestDto ticketRequestDto);

  TicketResponseDto toDto(Ticket ticket);

  List<TicketResponseDto> toDtoList(List<Ticket> ticket);

  /**
   * The convert page list of ticket details to custom page details.
   *
   * @param page page
   *
   * @return custom page details
   */
  default CustomPageDto toPageDto(Page<Ticket> page) {
    List<TicketResponseDto> dtoList = toDtoList(page.getContent());
    CustomPageDto pageDto = new CustomPageDto();
    pageDto.setContent(dtoList);
    pageDto.setTotalPages(page.getTotalPages());
    pageDto.setNumberOfElements(page.getNumberOfElements());
    pageDto.setTotalElements(page.getTotalElements());
    pageDto.setPage(page.getNumber());
    pageDto.setOffset(page.getSize());
    return pageDto;
  }
}
