package com.github.lucasls.rockpaperscissors.domain.value

data class GameScore(
    val playerOneWins: Int = 0,
    val playerTwoWins: Int = 0,
    val draws: Int = 0
)