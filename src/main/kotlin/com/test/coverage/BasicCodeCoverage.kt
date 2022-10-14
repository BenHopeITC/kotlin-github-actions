package com.test.coverage

class BasicCodeCoverage() {
    fun HelloWorld() = "Hello ${world()}!"

    fun greet(s: String) = "Hello $s"

    inline fun world() = "World"
}