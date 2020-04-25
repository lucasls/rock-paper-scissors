package com.github.lucasls.rockpaperscissors.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class ShapeTest {

    @ParameterizedTest
    @CsvSource(
        "Scissors,Paper",
        "Paper,Rock",
        "Rock,Scissors"
    )
    fun `should correctly return that Scissors beats Paper, Paper beats Rock and Rock beats Scissors`(
        strongerShape: Shape, weakerShaper: Shape
    ) {
        expectThat(strongerShape.beats()) isEqualTo weakerShaper
    }

    @ParameterizedTest
    @CsvSource(
        "Scissors,Scissors,Draw",
        "Scissors,Paper,Win",
        "Scissors,Rock,Lose",
        "Paper,Paper,Draw",
        "Paper,Rock,Win",
        "Paper,Scissors,Lose",
        "Rock,Rock,Draw",
        "Rock,Scissors,Win",
        "Rock,Paper,Lose"
    )
    fun `game result should be Win, Lose or Draw following game rules`(
        subject: Shape, opponent: Shape, gameResult: GameResult
    ) {
        expectThat(subject.fight(opponent)) isEqualTo gameResult
    }
}