package com.github.lucasls.rockpaperscissors.domain

import kotlin.random.Random

class FixedShapePlayer(
    private val shape: Shape
) : Player {

    override fun play(): Shape = shape

}