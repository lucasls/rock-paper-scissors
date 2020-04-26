package com.github.lucasls.rockpaperscissors.service

import com.github.lucasls.rockpaperscissors.domain.Player
import com.github.lucasls.rockpaperscissors.domain.Shape
import com.github.lucasls.rockpaperscissors.value.FinalGameResult
import com.github.lucasls.rockpaperscissors.value.Winner
import com.github.lucasls.rockpaperscissors.value.Winner.*
import com.github.lucasls.rockpaperscissors.value.GameScore
import com.github.lucasls.rockpaperscissors.value.RoundResult

class GameService(
    private val playerOne: Player,
    private val playerTwo: Player
) {

    fun startGame(numberOfRounds: Int, roundInterceptor: (RoundResult) -> Unit = {}): FinalGameResult {
        var currentScore = GameScore()

        repeat(numberOfRounds) {
            val roundResult = round(currentScore)
            roundInterceptor.invoke(roundResult)
            currentScore = roundResult.gameScore
        }

        val winner = with(currentScore) {
            when {
                playerOneWins > playerTwoWins -> PlayerOne
                playerOneWins < playerTwoWins -> PlayerTwo
                else -> None
            }
        }

        return FinalGameResult(winner, currentScore)
    }

    internal fun round(previousScore: GameScore): RoundResult {
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

    internal fun fight(playerOneShape: Shape, playerTwoShape: Shape): Winner {
        return when (playerTwoShape) {
            playerOneShape -> None
            playerOneShape.beats() -> PlayerOne
            else -> PlayerTwo
        }
    }

}