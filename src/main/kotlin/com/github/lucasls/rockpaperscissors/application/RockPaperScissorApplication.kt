package com.github.lucasls.rockpaperscissors.application

import com.github.lucasls.rockpaperscissors.application.config.ApplicationConfig
import com.github.lucasls.rockpaperscissors.service.GameService
import java.io.PrintStream
import java.io.PrintWriter

class RockPaperScissorApplication(
    private val gameService: GameService,
    private val out: PrintStream
) {

    fun start() {
        out.println("Hello World")
    }

}

fun main() {
    ApplicationConfig.application.start()
}