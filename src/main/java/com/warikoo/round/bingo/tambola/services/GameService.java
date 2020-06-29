package com.warikoo.round.bingo.tambola.services;

import java.util.ArrayList;
import java.util.Objects;

import com.warikoo.round.bingo.tambola.controllers.response.Stats;
import com.warikoo.round.bingo.tambola.models.Game;
import com.warikoo.round.bingo.tambola.models.Ticket;
import com.warikoo.round.bingo.tambola.repository.GameRepository;
import com.warikoo.round.bingo.tambola.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

@Service
public class GameService {
    
    @Autowired
    private GameRepository repository;
    
    @Autowired
    private GameSequencer gameSequencer;
    
    @Autowired
    private TicketSequencer ticketSequencer;
    
    @Autowired
    private RandomService randomService;
    
    @Autowired
    private TicketRepository ticketRepository;
    
    public Long createGame() {
        Game game = repository.save(new Game(gameSequencer.getNext()));
        return game.getGameId();
    }
    
    public Long createTicket(String username, Long gameId) {
        ArrayList<ArrayList<Integer>> randomTicket = randomService.getRandomTicket();
        Ticket ticket = ticketRepository.save(new Ticket(username, gameId, ticketSequencer.getNext(), randomTicket));
        Game game = repository.findByGameId(gameId);
        game.setPlayersActive(game.getPlayersActive() + 1);
        repository.save(game);
        return ticket.getTicketId();
    }
    
    public ArrayList<ArrayList<Integer>> getTicket(Long id) {
        Ticket ticket = ticketRepository.findByTicketId(id);
        if (Objects.nonNull(ticket)) {
            return ticket.getTicket();
        }
        return null;
    }
    
    public Integer getRandomNumber(Long gameId) {
        return randomService.getRandomUnusedNumber(gameId);
    }
    
    public ArrayList<Integer> getNumbers(Long gameId) {
        Game game = repository.findByGameId(gameId);
        if (Objects.nonNull(game)) {
            return new ArrayList<>(game.getNumbersPicked());
        }
        return null;
    }
    
    public Stats getStats(Long gameId) {
        Game game = repository.findByGameId(gameId);
        if (Objects.nonNull(game)) {
            return new Stats(game.getNumbersPicked().size(), game.getPlayersActive(), game.getPlayersActive());
        }
        return null;
    }
    
}
