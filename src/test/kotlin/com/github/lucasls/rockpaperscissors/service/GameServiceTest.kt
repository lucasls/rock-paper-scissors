package com.github.lucasls.rockpaperscissors.service

import com.github.lucasls.rockpaperscissors.domain.Player
import com.github.lucasls.rockpaperscissors.domain.Shape
import com.github.lucasls.rockpaperscissors.value.BattleWinner
import com.github.lucasls.rockpaperscissors.value.GameScore
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class GameServiceTest {
    private val playerOne: Player = mock()
    private val playerTwo: Player = mock()

    private val gameService = GameService(playerOne, playerTwo)

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
    fun `battle result should be player 1, 2 or draw according to game rules`(
        playerOneShape: Shape,
        playerTwoShape: Shape,
        expectedWinner: BattleWinner
    ) {
        // WHEN
        val battleResult = gameService.fight(playerOneShape, playerTwoShape)
        // THEN
        expectThat(battleResult) isEqualTo expectedWinner
    }

    @Test
    fun `should increase only player one win count when player one wins`() {
        // GIVEN
        val playerOneShape = Shape.Scissors
        val playerTwoShape = Shape.Paper
        val previousScore = GameScore(playerOneWins = 1, playerTwoWins = 2, draws = 3)

        whenever(playerOne.play()).then { playerOneShape }
        whenever(playerTwo.play()).then { playerTwoShape }

        // WHEN
        val roundResult = gameService.round(previousScore)

        // THEN
        expectThat(roundResult.battleWinner) isEqualTo BattleWinner.PlayerOne
        expectThat(roundResult.playerOneShape) isEqualTo playerOneShape
        expectThat(roundResult.playerTwoShape) isEqualTo playerTwoShape
        expectThat(roundResult.gameScore) isEqualTo GameScore(playerOneWins = 2, playerTwoWins = 2, draws = 3)
    }

    @Test
    fun `should increase only player two win count when player two wins`() {
        // GIVEN
        val playerOneShape = Shape.Scissors
        val playerTwoShape = Shape.Rock
        val previousScore = GameScore(playerOneWins = 3, playerTwoWins = 2, draws = 1)

        whenever(playerOne.play()).then { playerOneShape }
        whenever(playerTwo.play()).then { playerTwoShape }

        // WHEN
        val roundResult = gameService.round(previousScore)

        // THEN
        expectThat(roundResult.battleWinner) isEqualTo BattleWinner.PlayerTwo
        expectThat(roundResult.playerOneShape) isEqualTo playerOneShape
        expectThat(roundResult.playerTwoShape) isEqualTo playerTwoShape
        expectThat(roundResult.gameScore) isEqualTo GameScore(playerOneWins = 3, playerTwoWins = 3, draws = 1)
    }

    @Test
    fun `should increase only draws count when no player wins`() {
        // GIVEN
        val playerOneShape = Shape.Rock
        val playerTwoShape = Shape.Rock
        val previousScore = GameScore(playerOneWins = 0, playerTwoWins = 0, draws = 1)

        whenever(playerOne.play()).then { playerOneShape }
        whenever(playerTwo.play()).then { playerTwoShape }

        // WHEN
        val roundResult = gameService.round(previousScore)

        // THEN
        expectThat(roundResult.battleWinner) isEqualTo BattleWinner.None
        expectThat(roundResult.playerOneShape) isEqualTo playerOneShape
        expectThat(roundResult.playerTwoShape) isEqualTo playerTwoShape
        expectThat(roundResult.gameScore) isEqualTo GameScore(playerOneWins = 0, playerTwoWins = 0, draws = 2)
    }
}