package com.warikoo.round.bingo.tambola.controllers.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author krishnamohan
 * @date 29/06/20
 **/

@Data
@AllArgsConstructor
public class Stats {
    Integer numbersDrawn;
    Integer numberOfTickets;
    Integer numberOfUsers;
}
