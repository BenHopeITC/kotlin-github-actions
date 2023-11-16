package com.test.coverage

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class BasicCodeCoverageTest {
    @Tag("slow")
    @Test
    fun `SLOW greet calls world but no coverage for HelloWorld()`() {
        val m = BasicCodeCoverage()
        m.greet(m.world()) shouldBe "Hello World 2"
    }

    @Test
    fun `FAST greet calls world but no coverage for HelloWorld()`() {
        val m = BasicCodeCoverage()
        m.greet(m.world()) shouldBe "Hello World 33"
    }

    @Test
    fun `calls HelloWorld2()`() {
        val m = BasicCodeCoverage()
        m.helloWorld2() shouldBe "Hello World!"
    }
}
