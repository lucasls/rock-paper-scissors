package com.github.lucasls.rockpaperscissors.domain

enum class Shape {
    Scissors {
        override fun beats() = Paper
    },
    Paper {
        override fun beats() = Rock
    },
    Rock {
        override fun beats() = Scissors
    };

    abstract fun beats(): Shape

    fun fight(opponent: Shape): GameResult {
        return when (opponent) {
            this -> GameResult.Draw
            beats() -> GameResult.Win
            else -> GameResult.Lose
        }
    }
}