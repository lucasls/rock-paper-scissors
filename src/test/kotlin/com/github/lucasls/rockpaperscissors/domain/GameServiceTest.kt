package com.github.lucasls.rockpaperscissors.domain

import com.github.lucasls.rockpaperscissors.domain.player.Player
import com.github.lucasls.rockpaperscissors.domain.value.Shape
import com.github.lucasls.rockpaperscissors.domain.value.GameScore
import com.github.lucasls.rockpaperscissors.domain.value.RoundResult
import com.github.lucasls.rockpaperscissors.domain.value.Winner
import com.nhaarman.mockitokotlin2.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class GameServiceTest {
    private val playerOne: Player = mock()
    private val playerTwo: Player = mock()

    private val gameService =
        GameService(playerOne, playerTwo)

    @ParameterizedTest
    @CsvSource(
        "Scissors,Scissors,None",
        "Scissors,Paper,PlayerOne",
        "Scissors,Rock,PlayerTwo",
        "Paper,Paper,None",
        "Paper,Rock,PlayerOne",
        "Paper,Scissors,PlayerTwo",
        "Rock,Rock,None",
        "Rock,Scissors,PlayerOne",
        "Rock,Paper,PlayerTwo"
    )
    fun `battle winner should be player one, two or draw according to game rules`(
        playerOneShape: Shape,
        playerTwoShape: Shape,
        expectedWinner: Winner
    ) {
        // WHEN
        val battleResult = gameService.fight(playerOneShape, playerTwoShape)
        // THEN
        expectThat(battleResult) isEqualTo expectedWinner
    }

    @ParameterizedTest
    @CsvSource(
        "Scissors,Paper,PlayerOne",
        "Rock,Paper,PlayerTwo",
        "Paper,Paper,None"
    )
    fun `should return winner and chosen shapes `(
        playerOneShape: Shape, playerTwoShape: Shape, expectedWiner: Winner
    ) {
        // GIVEN
        whenever(playerOne.play()).then { playerOneShape }
        whenever(playerTwo.play()).then { playerTwoShape }

        // WHEN
        val roundResult = gameService.round(GameScore())

        // THEN
        expectThat(roundResult.winner) isEqualTo expectedWiner
        expectThat(roundResult.playerOneShape) isEqualTo playerOneShape
        expectThat(roundResult.playerTwoShape) isEqualTo playerTwoShape
    }

    @Test
    fun `should increase only player one win count when player one wins`() {
        // GIVEN
        whenever(playerOne.play()).then { Shape.Scissors }
        whenever(playerTwo.play()).then { Shape.Paper }

        // WHEN
        val roundResult = gameService.round(GameScore(playerOneWins = 1, playerTwoWins = 2, draws = 3))

        // THEN
        expectThat(roundResult.gameScore) isEqualTo GameScore(playerOneWins = 2, playerTwoWins = 2, draws = 3)
    }

    @Test
    fun `should increase only player two win count when player two wins`() {
        // GIVEN
        whenever(playerOne.play()).then { Shape.Scissors }
        whenever(playerTwo.play()).then { Shape.Rock }

        // WHEN
        val roundResult = gameService.round(GameScore(playerOneWins = 3, playerTwoWins = 2, draws = 1))

        // THEN
        expectThat(roundResult.gameScore) isEqualTo GameScore(playerOneWins = 3, playerTwoWins = 3, draws = 1)
    }

    @Test
    fun `should increase only draws count when no player wins`() {
        // GIVEN
        whenever(playerOne.play()).then { Shape.Rock }
        whenever(playerTwo.play()).then { Shape.Rock }

        // WHEN
        val roundResult = gameService.round(GameScore(playerOneWins = 0, playerTwoWins = 0, draws = 1))

        // THEN
        expectThat(roundResult.gameScore) isEqualTo GameScore(playerOneWins = 0, playerTwoWins = 0, draws = 2)
    }

    @Test
    fun `should call interceptor with winner for each round`() {
        // GIVEN
        whenever(playerOne.play()).then { Shape.Rock }
        whenever(playerTwo.play()).then { Shape.Scissors }
        val roundInterceptor: (RoundResult) -> Unit = mock()
        val numberOfRounds = 20

        // WHEN
        gameService.startGame(numberOfRounds, roundInterceptor)

        // THEN
        verify(roundInterceptor, times(numberOfRounds)).invoke(check {
            expectThat(it.winner) isEqualTo Winner.PlayerOne
        })
    }

    @Test
    fun `should have a different score on each intercepted round`() {
        // GIVEN
        whenever(playerOne.play()).then { Shape.Rock }
        whenever(playerTwo.play()).then { Shape.Scissors }
        val roundInterceptor: (RoundResult) -> Unit = mock()

        // WHEN
        gameService.startGame(5, roundInterceptor)

        // THEN
        val results = argumentCaptor<RoundResult> {
            verify(roundInterceptor, atLeastOnce()).invoke(capture())
        }.allValues

        results.forEachIndexed { i, result ->
            expectThat(result.gameScore) isEqualTo GameScore(playerOneWins = i + 1, playerTwoWins = 0, draws = 0)
        }
    }

    @Test
    fun `should return player one as winner with right score when player one wins`() {
        // GIVEN
        whenever(playerOne.play()).thenReturn(
            Shape.Paper,    // draw
            Shape.Rock,     // lose
            Shape.Scissors, // win
            Shape.Scissors, // win
            Shape.Scissors  // win
        )
        whenever(playerTwo.play())
            .thenReturn(Shape.Paper)

        // WHEN
        val (winner, gameScore) = gameService.startGame(5)

        // THEN
        expectThat(winner) isEqualTo Winner.PlayerOne
        expectThat(gameScore) isEqualTo GameScore(playerOneWins = 3, playerTwoWins = 1, draws = 1)
    }

    @Test
    fun `should return player two as winner with right score when player two wins`() {
        // GIVEN
        whenever(playerOne.play())
            .thenReturn(Shape.Paper)
        whenever(playerTwo.play()).thenReturn(
            Shape.Paper,    // draw
            Shape.Rock,     // lose
            Shape.Scissors, // win
            Shape.Scissors, // win
            Shape.Scissors  // win
        )

        // WHEN
        val (winner, gameScore) = gameService.startGame(5)

        // THEN
        expectThat(winner) isEqualTo Winner.PlayerTwo
        expectThat(gameScore) isEqualTo GameScore(playerOneWins = 1, playerTwoWins = 3, draws = 1)
    }

    @Test
    fun `should return none as winner with right score when no one wins`() {
        // GIVEN
        whenever(playerOne.play()).thenReturn(
            Shape.Scissors, // win
            Shape.Rock,     // lose
            Shape.Scissors, // win
            Shape.Rock,     // lose
            Shape.Paper     // draw
        )
        whenever(playerTwo.play())
            .thenReturn(Shape.Paper)

        // WHEN
        val finalGameResult = gameService.startGame(5)

        // THEN
        expectThat(finalGameResult.winner) isEqualTo Winner.None
        expectThat(finalGameResult.gameScore) isEqualTo GameScore(playerOneWins = 2, playerTwoWins = 2, draws = 1)
    }
}