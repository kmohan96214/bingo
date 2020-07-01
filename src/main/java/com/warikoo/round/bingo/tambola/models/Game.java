package com.warikoo.round.bingo.tambola.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;

import lombok.Data;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

@Data
public class Game {
    
    @Id
    String id;
    
    Long gameId;
    
    Integer playersActive;
    
    Set<Integer> numbersPicked;
    
    ArrayList<Integer> randomOrder;
    
    Short curr;
    
    public Game(Long gameId) {
        this.gameId = gameId;
        this.playersActive = 0;
        this.numbersPicked = new HashSet<>();
        ArrayList<Integer> random = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            random.add(i);
        }
        Collections.shuffle(random);
        this.randomOrder = random;
        curr = 0;
    }
}
