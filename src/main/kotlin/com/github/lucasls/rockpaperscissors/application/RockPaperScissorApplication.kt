package com.github.lucasls.rockpaperscissors.application

import com.github.lucasls.rockpaperscissors.application.config.ApplicationConfig
import com.github.lucasls.rockpaperscissors.application.io.TextOutput
import com.github.lucasls.rockpaperscissors.service.GameService

class RockPaperScissorApplication(
    private val gameService: GameService,
    private val out: TextOutput
) {

    fun start() {
        out.println("Hello World")
    }

}

fun main() {
    ApplicationConfig.application.start()
}