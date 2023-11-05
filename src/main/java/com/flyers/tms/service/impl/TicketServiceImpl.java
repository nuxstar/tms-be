package com.flyers.tms.service.impl;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.flyers.tms.exception.IllegalArgumentException;
import com.flyers.tms.mapper.TicketMapper;
import com.flyers.tms.model.dto.CustomPageDto;
import com.flyers.tms.model.dto.TicketRequestDto;
import com.flyers.tms.model.dto.TicketResponseDto;
import com.flyers.tms.model.entity.Ticket;
import com.flyers.tms.model.repository.TicketRepository;
import com.flyers.tms.service.TicketService;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * The ticket service implementation class.
 */
@Service
public final class TicketServiceImpl extends A implements TicketService {

  private static final Logger log = LoggerFactory.getLogger(TicketServiceImpl.class);

  @Autowired
  private BlobServiceClient blobServiceClient;
  @Autowired
  TicketRepository ticketRepository;
  @Autowired
  TicketMapper ticketMapper;

  @Override
  public TicketResponseDto createTicket(String employeeId, TicketRequestDto ticketRequestDto) {
    Ticket ticketDetails = ticketMapper.toEntity(ticketRequestDto);
    log.debug("Creating ticket: {}", ticketRequestDto.getTitle());
    ticketDetails.setCreatedBy(employeeId);
    ticketDetails.setComments(Collections.emptyList());
    TicketResponseDto ticketResponse = ticketMapper.toDto(ticketRepository.save(ticketDetails));
    log.debug("Saving Ticket Details: {}", ticketResponse.getTitle());
    return ticketResponse;
  }

  @Override
  public CustomPageDto readAllTickets(int page, int offset) {
    if (page < 0) {
      throw new IllegalArgumentException(
          IllegalArgumentException.ILLEGAL_ARGUMENT_EXCEPTION_PAGE);
    } else if (offset < 0) {
      throw new IllegalArgumentException(
          IllegalArgumentException.ILLEGAL_ARGUMENT_EXCEPTION_OFFSET);
    }
    Pageable pageable = PageRequest.of(page, offset);
    CustomPageDto allTickets = ticketMapper.toPageDto(ticketRepository.findAll(pageable));
    log.debug("Fetching all tickets");
    return allTickets;
  }

  @Override
  public String uploadFile(MultipartFile file) throws IOException {

    // Store the file in Azure Blob Storage
    String blobName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
    BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient("your-container-name");
    BlobClient blobClient = containerClient.getBlobClient(blobName);
    blobClient.upload(file.getInputStream(), file.getSize());

    // Generate the URL for the stored blob
    String blobUrl = blobClient.getBlobUrl();

    // Add the URL to the imageUrls list in the Ticket entity
    Ticket ticket = new Ticket();
    ticket.getImages().add(blobUrl);

    // Save the Ticket entity to MongoDB
    ticketRepository.save(ticket);

    return "File uploaded successfully!";
  }

  @Override
  public String deleteFile(String id) {

    BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient("your-container-name");
    BlobClient blobClient = containerClient.getBlobClient(id);

    if (blobClient.exists()) {
      blobClient.delete();
      return "Image deleted Successfully";
    }

    return "Image Not Deleted";
  }

}
