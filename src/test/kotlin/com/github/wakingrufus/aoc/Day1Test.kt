package com.github.wakingrufus.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day1Test {
    @Test
    fun `test sample1`() {
        testPart1(name = "sample 1", input = listOf("test"), expected = "expected")
    }

    @Test
    fun `test processInput`() {
        Day1().processInput()
    }

    private fun testPart1(name: String, input: List<String>, expected: String) {
        assertThat(Day1().part1(input))
            .`as`(name)
            .isEqualTo(expected)
    }
}