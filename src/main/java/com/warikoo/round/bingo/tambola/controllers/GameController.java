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
import org.springframework.web.bind.annotation.PostMapping;
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
    
    /*
        Creates and return a Game ID
     */
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Long> game() {
        return ResponseEntity.ok().body(service.createGame());
    }
    
    /*
        Take gameId as input creates and returns a ticket
     */
    @PostMapping("/{gameId}/ticket/{username}/generate")
    @ResponseBody
    public ResponseEntity<Long> ticket(@PathVariable("gameId") Long gameId, @PathVariable("username") String username) {
        return ResponseEntity.ok().body(service.createTicket(username, gameId));
    }
    
    /*
        Gets a Random number for a game without duplicates - 200
        Return 400 with error message if all numbers are already picked
     */
    @GetMapping("/{gameId}/number/random")
    @ResponseBody
    public ResponseEntity<Object> getRandom(@PathVariable("gameId") Long gameId) {
        Integer random = service.getRandomNumber(gameId);
        if (Objects.isNull(random)) {
            return ResponseEntity.badRequest().body("All numbers are already picked");
        }
        return ResponseEntity.ok().body(random);
    }
    
    /*
        Returns number picked for a game if game exists else return 400 bad request
     */
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
    
    /*
        Returns stats of game if game exists else return 400 bad request
     */
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
