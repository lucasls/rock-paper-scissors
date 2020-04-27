package com.github.lucasls.rockpaperscissors.domain.value

data class RoundResult(
    val playerOneShape: Shape,
    val playerTwoShape: Shape,
    val winner: Winner,
    val gameScore: GameScore
)