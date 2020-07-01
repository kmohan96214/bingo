package com.warikoo.round.bingo.tambola.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.warikoo.round.bingo.tambola.models.Game;
import com.warikoo.round.bingo.tambola.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

@Service
@Slf4j
public class RandomService {
    
    @Autowired
    private GameRepository gameRepository;
    
    public Integer getRandomUnusedNumber(Long gameId) {
        log.info("generating random number for game {}", gameId);
        Game game = gameRepository.findByGameId(gameId);
        Integer next = game.getRandomOrder().get(game.getCurr());
        if (game.getCurr() == 99) {
            return null;
        }
        game.setCurr((short) (game.getCurr() + 1));
        game.getNumbersPicked().add(next);
        gameRepository.save(game);
        log.info("Generated random number : {}", next);
        return next;
    }
    
    public ArrayList<ArrayList<Integer>> getRandomTicket() {
        ArrayList<ArrayList<Integer>> ticket = new ArrayList<ArrayList<Integer>>();
        Set<Integer> used = new HashSet<>();
        Random random = new Random();
        
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>(Collections.nCopies(9, -1));
            ticket.add(row);
        }
        
        for (int i = 0; i < 3; i++) {
            ArrayList<Boolean> temp = new ArrayList<>(
                    Arrays.asList(false, false, false, false, true, true, true, true, true));
            Collections.shuffle(temp);
            for (int j = 0; j < 9; j++) {
                Integer next = random.nextInt(98) + 1;
                if (used.contains(next)) {
                    j--;
                    continue;
                } else {
                    if (temp.get(j)) {
                        used.add(next);
                        ticket.get(i).set(j, next);
                    }
                }
            }
        }
        
        return ticket;
    }
    
}
