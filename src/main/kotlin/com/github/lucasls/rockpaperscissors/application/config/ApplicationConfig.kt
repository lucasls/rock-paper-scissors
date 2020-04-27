package com.github.lucasls.rockpaperscissors.application.config

import com.github.lucasls.rockpaperscissors.application.RockPaperScissorsApplication
import com.github.lucasls.rockpaperscissors.application.ui.TextBasedUIHandler
import com.github.lucasls.rockpaperscissors.domain.player.FixedShapePlayer
import com.github.lucasls.rockpaperscissors.domain.player.RandomShapePlayer
import com.github.lucasls.rockpaperscissors.domain.value.Shape
import com.github.lucasls.rockpaperscissors.domain.GameService
import kotlin.random.Random

object ApplicationConfig {

    private val playerOne by lazy {
        RandomShapePlayer(
            Random
        )
    }
    private val playerTwo by lazy {
        FixedShapePlayer(
            Shape.Rock
        )
    }
    private val gameService by lazy {
        GameService(
            playerOne,
            playerTwo
        )
    }
    private val uiHandler by lazy { TextBasedUIHandler(System.out) }

    val application by lazy { RockPaperScissorsApplication(gameService, uiHandler) }
}