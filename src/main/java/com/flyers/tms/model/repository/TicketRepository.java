package com.flyers.tms.model.repository;

import com.flyers.tms.model.entity.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Ticket Repository.
 */
@EnableMongoRepositories
public interface TicketRepository extends MongoRepository<Ticket, String> {

}
