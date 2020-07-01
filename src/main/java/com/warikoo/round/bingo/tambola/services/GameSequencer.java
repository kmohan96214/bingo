package com.warikoo.round.bingo.tambola.services;

import java.util.Objects;
import javax.annotation.PostConstruct;

import com.warikoo.round.bingo.tambola.models.GameCounter;
import com.warikoo.round.bingo.tambola.repository.GameCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

@Service
public class GameSequencer implements Sequencer {
    
    @Autowired
    private GameCounterRepository repository;
    
    @Override
    @PostConstruct
    public void init() {
        GameCounter gc = repository.findTopByOrderByIdDesc();
        if (Objects.isNull(gc)) {
            repository.save(new GameCounter(1000L));
        }
    }
    
    @Override
    public Long getNext() {
        GameCounter last = repository.findTopByOrderByIdDesc();
        Long lastnum = last.getSeq();
        last.setSeq(lastnum + 1);
        repository.save(last);
        return lastnum + 1;
    }
}
