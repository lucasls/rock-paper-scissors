package com.github.lucasls.rockpaperscissors.domain

import com.github.lucasls.rockpaperscissors.domain.Shape

interface Player {
    fun play(): Shape
}