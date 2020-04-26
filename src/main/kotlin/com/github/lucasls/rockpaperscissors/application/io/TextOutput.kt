package com.github.lucasls.rockpaperscissors.application.io

import kotlin.io.println as systemPrintln

class TextOutput {
    fun println(message: Any?) {
        systemPrintln(message)
    }
}