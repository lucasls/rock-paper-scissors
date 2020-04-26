package com.github.lucasls.rockpaperscissors.service

import com.github.lucasls.rockpaperscissors.domain.Player
import com.github.lucasls.rockpaperscissors.domain.Shape
import com.github.lucasls.rockpaperscissors.value.BattleWinner
import com.github.lucasls.rockpaperscissors.value.BattleWinner.*
import com.github.lucasls.rockpaperscissors.value.GameScore
import com.github.lucasls.rockpaperscissors.value.RoundResult

class GameService(
    private val playerOne: Player,
    private val playerTwo: Player
) {

    fun round(previousScore: GameScore): RoundResult {
        val playerOneShape = playerOne.play()
        val playerTwoShape = playerTwo.play()

        val battleWinner = fight(playerOneShape, playerTwoShape)

        val gameScore = when (battleWinner) {
            PlayerOne -> previousScore.copy(playerOneWins = previousScore.playerOneWins + 1)
            PlayerTwo -> previousScore.copy(playerTwoWins = previousScore.playerTwoWins + 1)
            None -> previousScore.copy(draws = previousScore.draws + 1)
        }

        return RoundResult(playerOneShape, playerTwoShape, battleWinner, gameScore)
    }

    internal fun fight(playerOneShape: Shape, playerTwoShape: Shape): BattleWinner {
        return when (playerTwoShape) {
            playerOneShape -> None
            playerOneShape.beats() -> PlayerOne
            else -> PlayerTwo
        }
    }

}