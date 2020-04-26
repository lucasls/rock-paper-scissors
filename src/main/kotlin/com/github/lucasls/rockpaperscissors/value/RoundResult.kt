package com.github.lucasls.rockpaperscissors.value

import com.github.lucasls.rockpaperscissors.domain.Shape

data class RoundResult(
    val playerOneShape: Shape,
    val playerTwoShape: Shape,
    val winner: Winner,
    val gameScore: GameScore
)