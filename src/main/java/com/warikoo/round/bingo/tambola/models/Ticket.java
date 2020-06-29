package com.warikoo.round.bingo.tambola.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

@Data
@AllArgsConstructor
public class Ticket {
    
    String username;
    
    Long gameId;
    
    Long ticketId;
    
    ArrayList<ArrayList<Integer>> ticket;
    
}
