package com.github.lucasls.rockpaperscissors.domain.value

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
}