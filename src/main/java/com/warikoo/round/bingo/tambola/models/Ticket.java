package com.warikoo.round.bingo.tambola.models;

import java.util.ArrayList;

import javax.persistence.Id;

import lombok.Data;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

@Data
public class Ticket {
    
    @Id
    String id;
    
    String username;
    
    Long gameId;
    
    Long ticketId;
    
    ArrayList<ArrayList<Integer>> ticket;
    
    public Ticket(String username, Long gameId, Long ticketId, ArrayList<ArrayList<Integer>> ticket){
        this.username = username;
        this.gameId = gameId;
        this.ticketId = ticketId;
        this.ticket = ticket;
    }
    
}
