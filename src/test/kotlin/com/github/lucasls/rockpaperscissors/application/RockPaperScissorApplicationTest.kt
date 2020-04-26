package com.github.lucasls.rockpaperscissors.application

import com.github.lucasls.rockpaperscissors.application.io.TextOutput
import com.github.lucasls.rockpaperscissors.domain.FixedShapePlayer
import com.github.lucasls.rockpaperscissors.domain.RandomShapePlayer
import com.github.lucasls.rockpaperscissors.domain.Shape
import com.github.lucasls.rockpaperscissors.service.GameService
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Test
import kotlin.random.Random

class RockPaperScissorApplicationTest {
    val playerOne = spy(RandomShapePlayer(Random))
    val playerTwo = spy(FixedShapePlayer(Shape.Rock))
    val gameService = spy(GameService(playerOne, playerTwo))

    val out: TextOutput = spy(TextOutput())
    val application = spy(RockPaperScissorApplication(gameService, out))

    @Test
    fun `should write Hello World`() {
        application.start()

        verify(out) {
            1 * { this.println("Hello World") }
        }
    }
}