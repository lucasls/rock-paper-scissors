package com.github.lucasls.rockpaperscissors.domain.value

import com.github.lucasls.rockpaperscissors.domain.value.Shape
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
}