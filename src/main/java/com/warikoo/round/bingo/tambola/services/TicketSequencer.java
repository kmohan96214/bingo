package com.warikoo.round.bingo.tambola.services;

import java.util.Objects;
import javax.annotation.PostConstruct;

import com.warikoo.round.bingo.tambola.models.TicketCounter;
import com.warikoo.round.bingo.tambola.repository.TicketCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

@Service
public class TicketSequencer implements Sequencer {
    
    @Autowired
    private TicketCounterRepository repository;
    
    @Override
    @PostConstruct
    public void init() {
        TicketCounter tc = repository.findTopByOrderByIdDesc();
        if (Objects.isNull(tc)) {
            repository.save(new TicketCounter(1000L));
        }
    }
    
    @Override
    public Long getNext() {
        TicketCounter last = repository.findTopByOrderByIdDesc();
        Long lastnum = last.getSeq();
        last.setSeq(lastnum + 1);
        repository.save(last);
        return lastnum + 1;
    }
}
