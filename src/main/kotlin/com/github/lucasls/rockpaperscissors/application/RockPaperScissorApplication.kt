package com.github.lucasls.rockpaperscissors.application

import com.github.lucasls.rockpaperscissors.application.config.ApplicationConfig
import com.github.lucasls.rockpaperscissors.application.ui.*
import com.github.lucasls.rockpaperscissors.service.GameService
import com.github.lucasls.rockpaperscissors.value.Winner.*
import java.io.PrintStream

private const val NUMBER_OF_ROUNDS = 200

class RockPaperScissorApplication(
    private val gameService: GameService,
    private val uiHandler: TextBasedUIHandler
) {

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