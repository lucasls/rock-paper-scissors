package com.github.lucasls.rockpaperscissors.service

import com.github.lucasls.rockpaperscissors.domain.Player
import com.github.lucasls.rockpaperscissors.domain.Shape
import com.github.lucasls.rockpaperscissors.value.BattleResult
import com.github.lucasls.rockpaperscissors.value.GameScore
import com.github.lucasls.rockpaperscissors.value.BattleResult.*

class GameService {

    fun round(playerOne: Player, playerTwo: Player, previousScore: GameScore = GameScore()): GameScore {
        TODO()
    }

    fun fight(playerOneShape: Shape, playerTwoShape: Shape): BattleResult {
        return when (playerTwoShape) {
            playerOneShape -> Draw
            playerOneShape.beats() -> PlayerOneWins
            else -> PlayerTwoWins
        }
    }

}