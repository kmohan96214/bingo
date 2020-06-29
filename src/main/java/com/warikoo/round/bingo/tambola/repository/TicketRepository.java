package com.warikoo.round.bingo.tambola.repository;

import com.warikoo.round.bingo.tambola.models.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

public interface TicketRepository extends MongoRepository<Ticket, String> {
    Ticket findByUsername(@Param("username") String username);
    Ticket findByTicketId(@Param("ticketId") Long ticketId);
    Ticket findByGameId(@Param("gameId") Long gameId);
}
