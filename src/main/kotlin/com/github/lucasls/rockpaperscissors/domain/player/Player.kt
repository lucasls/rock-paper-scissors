package com.github.lucasls.rockpaperscissors.domain.player

import com.github.lucasls.rockpaperscissors.domain.value.Shape

interface Player {
    fun play(): Shape
}