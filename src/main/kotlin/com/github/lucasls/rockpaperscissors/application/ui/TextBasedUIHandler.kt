package com.github.lucasls.rockpaperscissors.application.ui

import com.github.lucasls.rockpaperscissors.domain.value.Shape
import com.github.lucasls.rockpaperscissors.domain.value.FinalGameResult
import com.github.lucasls.rockpaperscissors.domain.value.RoundResult
import com.github.lucasls.rockpaperscissors.domain.value.Winner
import java.io.PrintStream

class TextBasedUIHandler(
    private val out: PrintStream
) {
    companion object {
        private const val EMOJI_ROCK = "✊"
        private const val EMOJI_PAPER = "✋"
        private const val EMOJI_SCISSORS = "✌️"

        private const val EMOJI_PLAYER_ONE = "🧐"
        private const val EMOJI_PLAYER_TWO = "🤪"

        private const val EMOJI_TROPHY = "🏆"
        private const val EMOJI_RED_X = "❌"

        private const val TEXT_PLAYER_ONE = "Player 1"
        private const val TEXT_PLAYER_TWO = "Player 2"

        private const val TEXT_HEADER = "ROCK X PAPER X SCISSORS"
        private const val SECTION_DIVIDER = "----------------------------------------------------------------"
    }

    fun showHeader() {
        out.println(TEXT_HEADER)
        out.println(SECTION_DIVIDER)
    }

    fun showRoundResult(index: Int, roundResult: RoundResult) {
        val roundNumber = index + 1

        val (playerOneShape, playerTwoShape, winner, _) = roundResult

        val roundNumberTxt = "$roundNumber:".padEnd(4, ' ')

        val playerOneChoice = "$TEXT_PLAYER_ONE $EMOJI_PLAYER_ONE ${playerOneShape.emoji}"
        val playerTwoChoice = "${playerTwoShape.emoji} $EMOJI_PLAYER_ONE $TEXT_PLAYER_TWO"
        val roundResultText = winnerResultText(winner)

        out.println("Round $roundNumberTxt $playerOneChoice X $playerTwoChoice ... $roundResultText")
    }

    fun showFinalResult(finalGameResult: FinalGameResult) {
        val (winner, gameScore) = finalGameResult

        val finalResultText = winnerResultText(winner)

        val text = """
            Final Result: $finalResultText
            $EMOJI_PLAYER_ONE $TEXT_PLAYER_ONE victories: ${gameScore.playerOneWins}
            $EMOJI_PLAYER_TWO $TEXT_PLAYER_TWO victories: ${gameScore.playerTwoWins}
            $EMOJI_RED_X Number of draws: ${gameScore.draws}
        """.trimIndent()

        out.println(SECTION_DIVIDER)
        out.println(text)
    }

    private fun winnerResultText(winner: Winner): String =
        if (winner != Winner.None) {
            "$EMOJI_TROPHY ${winner.text} wins ${winner.emoji}"
        } else {
            "$EMOJI_RED_X It's a Draw $EMOJI_RED_X"
        }


    private val Shape.emoji: String
        get() = when (this) {
            Shape.Rock -> EMOJI_ROCK
            Shape.Paper -> EMOJI_PAPER
            Shape.Scissors -> EMOJI_SCISSORS
        }

    private val Winner.emoji: String
        get() = when (this) {
            Winner.PlayerOne -> EMOJI_PLAYER_ONE
            Winner.PlayerTwo -> EMOJI_PLAYER_TWO
            Winner.None -> throw UnsupportedOperationException()
        }

    private val Winner.text: String
        get() = when (this) {
            Winner.PlayerOne -> TEXT_PLAYER_ONE
            Winner.PlayerTwo -> TEXT_PLAYER_TWO
            Winner.None -> throw UnsupportedOperationException()
        }
}