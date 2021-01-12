package com.jitterted.ebp.blackjack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameOutcomeTest {

  @Test
  public void playerBustsAndLoses() throws Exception {
    Deck stubDeck = new StubDeck(Rank.JACK, Rank.TWO,
                                 Rank.QUEEN, Rank.THREE,
                                 Rank.SIX);
    Game game = new Game(stubDeck);

    game.initialDeal();
    game.playerHits();

    assertThat(game.determineOutcome())
        .isEqualTo(GameOutcome.PLAYER_BUSTS);
  }

  @Test
  public void playerWinsBlackjack() throws Exception {
    Deck stubDeck = new StubDeck(Rank.JACK, Rank.TWO,
                                 Rank.ACE, Rank.THREE);
    Game game = new Game(stubDeck);

    game.initialDeal();

    assertThat(game.determineOutcome())
        .isEqualTo(GameOutcome.PLAYER_WINS_BLACKJACK);
  }

}