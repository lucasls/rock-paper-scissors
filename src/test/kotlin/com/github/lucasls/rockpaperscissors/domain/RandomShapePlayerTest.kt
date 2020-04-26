package com.github.lucasls.rockpaperscissors.domain

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.stub
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.mockito.Answers
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.random.Random

class RandomShapePlayerTest {
    private val random: Random = mock()
    private val randomShapePlayer = RandomShapePlayer(random)

    @ParameterizedTest
    @CsvSource(
        "0,Scissors",
        "1,Paper",
        "2,Rock"
    )
    fun `should return player according to random number`(
        randomNumber: Int, expectedShape: Shape
    ) {
        // GIVEN
        whenever(random.nextInt(3)).then { randomNumber }
        // WHEN
        val shape = randomShapePlayer.play()
        // THEN
        expectThat(shape) isEqualTo expectedShape
    }
}