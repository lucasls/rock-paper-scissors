package com.github.lucasls.rockpaperscissors.application

import com.github.lucasls.rockpaperscissors.domain.FixedShapePlayer
import com.github.lucasls.rockpaperscissors.domain.RandomShapePlayer
import com.github.lucasls.rockpaperscissors.domain.Shape
import com.github.lucasls.rockpaperscissors.service.GameService
import com.nhaarman.mockitokotlin2.spy
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.io.ByteArrayOutputStream
import java.io.PipedInputStream
import java.io.PipedOutputStream
import java.io.PrintStream
import kotlin.random.Random

class RockPaperScissorApplicationTest {
    val playerOne = spy(RandomShapePlayer(Random))
    val playerTwo = spy(FixedShapePlayer(Shape.Rock))
    val gameService = spy(GameService(playerOne, playerTwo))

    val outputStream = PipedOutputStream()
    val outputReader = PipedInputStream(outputStream).bufferedReader()

    val application = spy(
        RockPaperScissorApplication(gameService, PrintStream(outputStream, true))
    )

    @Test
    fun `should write Hello World`() {
        application.start()

        expectThat(outputReader.readLine()) isEqualTo "Hello World"
    }
}