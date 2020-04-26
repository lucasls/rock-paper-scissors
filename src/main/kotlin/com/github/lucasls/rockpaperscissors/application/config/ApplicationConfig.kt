package com.github.lucasls.rockpaperscissors.application.config

import com.github.lucasls.rockpaperscissors.application.RockPaperScissorApplication
import com.github.lucasls.rockpaperscissors.application.ui.TextBasedUIHandler
import com.github.lucasls.rockpaperscissors.domain.FixedShapePlayer
import com.github.lucasls.rockpaperscissors.domain.RandomShapePlayer
import com.github.lucasls.rockpaperscissors.domain.Shape
import com.github.lucasls.rockpaperscissors.service.GameService
import kotlin.random.Random

object ApplicationConfig {

    private val playerOne by lazy { RandomShapePlayer(Random) }
    private val playerTwo by lazy { FixedShapePlayer(Shape.Rock) }
    private val gameService by lazy { GameService(playerOne, playerTwo) }
    private val uiHandler by lazy { TextBasedUIHandler(System.out) }

    val application by lazy { RockPaperScissorApplication(gameService, uiHandler) }
}