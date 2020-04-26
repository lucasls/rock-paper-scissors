package com.github.lucasls.rockpaperscissors.service

import com.github.lucasls.rockpaperscissors.domain.Shape
import com.github.lucasls.rockpaperscissors.value.BattleResult
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class GameServiceTest {
    val gameService = GameService()

    @ParameterizedTest
    @CsvSource(
        "Scissors,Scissors,Draw",
        "Scissors,Paper,PlayerOneWins",
        "Scissors,Rock,PlayerTwoWins",
        "Paper,Paper,Draw",
        "Paper,Rock,PlayerOneWins",
        "Paper,Scissors,PlayerTwoWins",
        "Rock,Rock,Draw",
        "Rock,Scissors,PlayerOneWins",
        "Rock,Paper,PlayerTwoWins"
    )
    fun `battle result should be player 1, 2 or draw according to game rules`(
        playerOneShape: Shape,
        playerTwoShape: Shape,
        expectedResult: BattleResult
    ) {
        // WHEN
        val battleResult = gameService.fight(playerOneShape, playerTwoShape)
        // THEN
        expectThat(battleResult) isEqualTo expectedResult
    }
}