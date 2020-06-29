package com.warikoo.round.bingo.tambola.repository;

import com.warikoo.round.bingo.tambola.models.TicketCounter;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

public interface TicketCounterRepository extends MongoRepository<TicketCounter, String> {
    TicketCounter findTopByOrderByIdDesc();
}
