package com.warikoo.round.bingo.tambola.controllers;

import java.util.ArrayList;
import java.util.Objects;

import com.warikoo.round.bingo.tambola.controllers.response.Stats;
import com.warikoo.round.bingo.tambola.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

@Controller
@RequestMapping("/api/game")
public class GameController {
    
    @Autowired
    private GameService service;

    @GetMapping("/create")
    @ResponseBody
    public ResponseEntity<Long> game() {
        return ResponseEntity.ok().body(service.createGame());
    }

    @GetMapping("/{gameId}/ticket/{username}/generate")
    @ResponseBody
    public ResponseEntity<Long> ticket(@PathVariable("gameId") Long gameId,
            @PathVariable("username") String username) {
        return ResponseEntity.ok().body(service.createTicket(username, gameId));
    }
    
    @GetMapping("/{gameId}/number/random")
    @ResponseBody
    public ResponseEntity<Integer> getRandom(@PathVariable("gameId") Long gameId) {
        return ResponseEntity.ok().body(service.getRandomNumber(gameId));
    }
    
    @GetMapping("/{gameId}/numbers")
    @ResponseBody
    public ResponseEntity<ArrayList<Integer>> getNumbers(@PathVariable("gameId") Long gameId) {
        ArrayList<Integer> numbers = service.getNumbers(gameId);
        if (Objects.nonNull(numbers)) {
            return ResponseEntity.ok().body(numbers);
        } else {
            return ResponseEntity.badRequest().body(numbers);
        }
    }
    
    @GetMapping("/{gameId}/stats")
    @ResponseBody
    public ResponseEntity<Stats> getStats(@PathVariable("gameId") Long gameId) {
        Stats stats = service.getStats(gameId);
        if (Objects.nonNull(stats)) {
            return ResponseEntity.ok().body(stats);
        } else {
            return ResponseEntity.badRequest().body(stats);
        }
    }
    
}
