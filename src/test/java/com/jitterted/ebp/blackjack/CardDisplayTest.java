package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CardDisplayTest {

  @Test
  public void displayTenAsString() throws Exception {
    Card card = new Card(Suit.HEARTS, Rank.TEN);

    assertThat(card.display())
        .isEqualTo("\u001B[31m┌─────────┐\u001B[1B\u001B[11D│10       │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│    ♥    │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│       10│\u001B[1B\u001B[11D└─────────┘");
  }

  @Test
  public void displayNonTenAsString() throws Exception {
    Card card = new Card(Suit.SPADES, Rank.SEVEN);

    assertThat(card.display())
      .isEqualTo("\u001B[30m┌─────────┐\u001B[1B\u001B[11D│7        │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│    ♠    │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│        7│\u001B[1B\u001B[11D└─────────┘");
  }
}