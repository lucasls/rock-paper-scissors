package com.github.lucasls.rockpaperscissors.application

import com.github.lucasls.rockpaperscissors.application.config.ApplicationConfig
import com.github.lucasls.rockpaperscissors.application.ui.TextBasedUIHandler
import com.github.lucasls.rockpaperscissors.domain.GameService

class RockPaperScissorsApplication(
    private val gameService: GameService,
    private val uiHandler: TextBasedUIHandler
) {

    companion object {
        private const val NUMBER_OF_ROUNDS = 200
    }

    fun start(numberOfRounds: Int = NUMBER_OF_ROUNDS) {
        uiHandler.showHeader()

        var roundIndex = 0
        val finalGameResult = gameService.startGame(numberOfRounds) { roundResult ->
            uiHandler.showRoundResult(roundIndex, roundResult)
            roundIndex++
        }

        uiHandler.showFinalResult(finalGameResult)
    }

}

fun main() {
    ApplicationConfig.application.start()
}