package com.warikoo.round.bingo.tambola.repository;

import com.warikoo.round.bingo.tambola.models.GameCounter;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

public interface GameCounterRepository extends MongoRepository<GameCounter, String> {
    GameCounter findTopByOrderByIdDesc();
}
