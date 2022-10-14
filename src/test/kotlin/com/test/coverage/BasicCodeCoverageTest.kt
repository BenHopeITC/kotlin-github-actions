package com.test.coverage

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BasicCodeCoverageTest {

    @Test
    fun `greet calls world but no coverage for HelloWorld()`() {
        val m = BasicCodeCoverage()
        m.greet(m.world()) shouldBe "Hello World"
    }

    @Test
    fun `calls HelloWorld2()`() {
        val m = BasicCodeCoverage()
        m.HelloWorld2() shouldBe "Hello World!"
    }
}