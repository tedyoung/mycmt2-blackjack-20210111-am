package com.jitterted.ebp.blackjack.domain;

public enum GameOutcome {
  PLAYER_BUSTS("You Busted, so you lose.  💸"),
  DEALER_BUSTS("Dealer went BUST, Player wins! Yay for you!! 💵"),
  PLAYER_BEATS_DEALER("You beat the Dealer! 💵"),
  PUSH("Push: The house wins, you Lose. 💸"),
  PLAYER_LOSES("You lost to the Dealer. 💸"),
  PLAYER_WINS_BLACKJACK("You won blackjack!!");

  private final String displayString;

  GameOutcome(String displayString) {
    this.displayString = displayString;
  }

  public String displayString() {
    return displayString;
  }
}
