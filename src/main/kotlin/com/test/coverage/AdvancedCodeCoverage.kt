package com.test.coverage

class AdvancedCodeCoverage() {
    fun helloWorld() = "Hello advanced ${world()}!"

    fun helloWorld2(): String {
        return "Hello advanced ${world()}!"
    }

    fun greet(s: String) = "Hello advanced $s"

    inline fun world() = "World"
}
