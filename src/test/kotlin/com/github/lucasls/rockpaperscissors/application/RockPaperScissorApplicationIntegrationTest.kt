package com.github.lucasls.rockpaperscissors.application

import com.github.lucasls.rockpaperscissors.application.ui.TextBasedUIHandler
import com.github.lucasls.rockpaperscissors.domain.player.FixedShapePlayer
import com.github.lucasls.rockpaperscissors.domain.player.RandomShapePlayer
import com.github.lucasls.rockpaperscissors.domain.value.Shape
import com.github.lucasls.rockpaperscissors.domain.GameService
import com.github.lucasls.rockpaperscissors.domain.value.FinalGameResult
import com.github.lucasls.rockpaperscissors.domain.value.RoundResult
import com.github.lucasls.rockpaperscissors.domain.value.Winner
import com.nhaarman.mockitokotlin2.*
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.contains
import java.io.*
import kotlin.random.Random

class RockPaperScissorApplicationIntegrationTest {
    private val outputStream = ByteArrayOutputStream()

    private val playerOne = spy(
        RandomShapePlayer(
            Random
        )
    )
    private val playerTwo = spy(
        FixedShapePlayer(
            Shape.Rock
        )
    )
    private val gameService = spy(
        GameService(
            playerOne,
            playerTwo
        )
    )
    private val uiHandler = spy(TextBasedUIHandler(PrintStream(outputStream)))

    private val application = spy(RockPaperScissorsApplication(gameService, uiHandler))

    @Test
    fun `should run application and output text correctly`() {
        // GIVEN
        val numberOfRounds = 50

        // WHEN
        application.start(numberOfRounds)

        // THEN
        val output = outputStream.toString()
        val outputReader = StringReader(output).buffered()

        val results = argumentCaptor<RoundResult> {
            verify(uiHandler, times(numberOfRounds)).showRoundResult(any(), capture())
        }.allValues

        outputReader.readLine() // skip
        outputReader.readLine() // skip

        results.forEach { (_, _, winner, _) ->

            expectThat(outputReader.readLine()) contains when (winner) {
                Winner.PlayerOne -> "Player 1 wins"
                Winner.PlayerTwo -> "Player 2 wins"
                Winner.None -> "It's a Draw"
            }
        }

        outputReader.readLine()

        val (winner, gameScore) = argumentCaptor<FinalGameResult> {
            verify(uiHandler).showFinalResult(capture())
        }.firstValue

        expectThat(outputReader.readLine()) contains when (winner) {
            Winner.PlayerOne -> "Player 1 wins"
            Winner.PlayerTwo -> "Player 2 wins"
            Winner.None -> "It's a Draw"
        }

        expectThat(outputReader.readLine()) contains "Player 1 victories: ${gameScore.playerOneWins}"
        expectThat(outputReader.readLine()) contains "Player 2 victories: ${gameScore.playerTwoWins}"
        expectThat(outputReader.readLine()) contains "Number of draws: ${gameScore.draws}"

    }

    @Test
    fun `should start application from main`() {
        main()
    }
}