package com.jitterted.ebp.blackjack.adapter.in.console;

import com.jitterted.ebp.blackjack.domain.GameOutcome;

public class ConsoleOutcome {

  public static String of(GameOutcome gameOutcome) {
    switch (gameOutcome) {
      case PLAYER_BUSTS: return "You Busted, so you lose.  💸";
      case DEALER_BUSTS: return "Dealer went BUST, Player wins! Yay for you!! 💵";
      case PLAYER_BEATS_DEALER: return "You beat the Dealer! 💵";
      case PUSH: return "Push: The house wins, you Lose. 💸";
      case PLAYER_LOSES: return "You lost to the Dealer. 💸";
      case PLAYER_WINS_BLACKJACK: return "You won blackjack!!";
      default:
        throw new UnsupportedOperationException();
    }
  }

}
