package com.github.lucasls.rockpaperscissors.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
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
    fun `should correctly return what shape each shape beats`(
        target: Shape, expected: Shape
    ) {
        expectThat(target.beats()) isEqualTo expected
    }
}