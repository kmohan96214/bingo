package com.warikoo.round.bingo.tambola.models;

import javax.persistence.Id;

import lombok.Data;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

@Data
public class GameCounter {
    
    @Id
    private String id;
    
    private Long seq;
    
    public GameCounter(Long seq) {
        this.seq = seq;
    }
}
