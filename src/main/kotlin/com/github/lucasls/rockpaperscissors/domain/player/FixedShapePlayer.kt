package com.github.lucasls.rockpaperscissors.domain.player

import com.github.lucasls.rockpaperscissors.domain.player.Player
import com.github.lucasls.rockpaperscissors.domain.value.Shape

class FixedShapePlayer(
    private val shape: Shape
) : Player {

    override fun play(): Shape = shape

}