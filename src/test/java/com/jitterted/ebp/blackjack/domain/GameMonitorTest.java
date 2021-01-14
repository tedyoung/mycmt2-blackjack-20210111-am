package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.domain.port.GameMonitor;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class GameMonitorTest {

  @Test
  public void playerWithNoBlackjackStandsCompletesGameSendsToMonitor() throws Exception {
    // creates the spy based on the interface
    GameMonitor gameMonitorSpy = spy(GameMonitor.class);

    Deck noBlackjackDeck = new StubDeck(Rank.TEN, Rank.EIGHT, Rank.QUEEN, Rank.QUEEN);
    Game game = new Game(noBlackjackDeck, gameMonitorSpy);
    game.initialDeal();

    game.playerStands();

    // verify that the roundCompleted method was called with any instance of a Game class
    verify(gameMonitorSpy).roundCompleted(any(Game.class));
  }

  @Test
  public void playerWithBlackjackThenGameSendsToMonitor() throws Exception {
    GameMonitor gameMonitorSpy = spy(GameMonitor.class);

    Deck blackjackDeck = new StubDeck(Rank.TEN, Rank.EIGHT, Rank.ACE, Rank.KING);
    Game game = new Game(blackjackDeck, gameMonitorSpy);
    game.initialDeal();

    verify(gameMonitorSpy).roundCompleted(any(Game.class));
  }

  @Test
  public void playerHitsGoesBustGameSendResultToMonitor() throws Exception {
    GameMonitor gameMonitorSpy = spy(GameMonitor.class);
    Deck playerBustsDeck = new StubDeck(Rank.TEN, Rank.EIGHT, Rank.QUEEN, Rank.QUEEN, Rank.FIVE);
    Game game = new Game(playerBustsDeck, gameMonitorSpy);
    game.initialDeal();

    game.playerHits();

    verify(gameMonitorSpy).roundCompleted(any(Game.class));
  }

  @Test
  public void playerHitsDoesNotGoBustThenGameDoesNotSendResultToMonitor() throws Exception {
    GameMonitor gameMonitorSpy = spy(GameMonitor.class);
    Deck playerNotBustedDeck = new StubDeck(Rank.TEN, Rank.EIGHT, Rank.SIX, Rank.QUEEN, Rank.FIVE);
    Game game = new Game(playerNotBustedDeck, gameMonitorSpy);
    game.initialDeal();

    game.playerHits();

    verify(gameMonitorSpy, never()).roundCompleted(any(Game.class));
  }

}