package com.warikoo.round.bingo.tambola.controllers;

import java.util.ArrayList;
import java.util.Objects;

import com.warikoo.round.bingo.tambola.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

@Controller
public class TicketController {
    
    @Autowired
    private GameService service;
    
    @GetMapping("/ticket/{ticketId}")
    @ResponseBody
    public ResponseEntity<ArrayList<ArrayList<Integer>>> getTicket(@PathVariable("ticketId") Long ticketId) {
        ArrayList<ArrayList<Integer>> ticket = service.getTicket(ticketId);
        if (Objects.nonNull(ticket)) {
            return ResponseEntity.ok().body(ticket);
        } else {
            return ResponseEntity.badRequest().body(ticket);
        }
    }
    
}
