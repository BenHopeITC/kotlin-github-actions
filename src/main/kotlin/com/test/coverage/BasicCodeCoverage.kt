package com.test.coverage

class BasicCodeCoverage() {
    fun helloWorld() = "Hello ${world()}!"

    fun helloWorld2(): String {
        return "Hello 2 ${world()}!"
    }

    fun greet(s: String) = "Hello $s"

    inline fun world() = "World"
}
