package com.github.lucasls.rockpaperscissors.domain.player

import com.github.lucasls.rockpaperscissors.domain.player.FixedShapePlayer
import com.github.lucasls.rockpaperscissors.domain.value.Shape
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class FixedShapePlayerTest {
    @ParameterizedTest
    @EnumSource(Shape::class)
    fun `should always return the same shape`(shape: Shape) {
        // GIVEN
        val fixedShapePlayer =
            FixedShapePlayer(shape)
        // WHEN
        val result = fixedShapePlayer.play()
        // THEN
        expectThat(result) isEqualTo shape
    }
}