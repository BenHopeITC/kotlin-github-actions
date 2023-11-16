package com.test.coverage

class AdvancedCodeCoverage() {
    fun HelloWorld() = "Hello 2 advanced ${world()}!"

    fun helloWorld2(): String {
        return "Hello advanced ${world()}!"
    }

    fun greet(s: String) = "Hello advanced $s"

    inline fun world() = "World"
}
