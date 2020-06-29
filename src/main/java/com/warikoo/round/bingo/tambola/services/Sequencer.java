package com.warikoo.round.bingo.tambola.services;

import javax.annotation.PostConstruct;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

public interface Sequencer {
    
    @PostConstruct
    public void init();
    
    Long getNext();
}
