package com.github.lucasls.rockpaperscissors.domain

import kotlin.random.Random

class RandomShapePlayer(
    private val random: Random
) : Player {

    override fun play(): Shape {
        val i = random.nextInt(until = 3)
        return Shape.values()[i]
    }

}