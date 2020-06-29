package com.warikoo.round.bingo.tambola.repository;

import com.warikoo.round.bingo.tambola.models.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

public interface GameRepository extends MongoRepository<Game, String> {
    Game findByGameId(@Param("gameId") Long gameId);
}
