package com.github.wakingrufus.aoc.day14

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day14Test {
    private val sample1 = """498,4 -> 498,6 -> 496,6
503,4 -> 502,4 -> 502,9 -> 494,9"""

    @Test
    fun `test part1`() {
        val instance = Day14()
        assertThat(instance.part1(sample1.lines()))
            .`as`("question example 1")
            .isEqualTo(24)
    }

    @Test
    fun `test parse`() {
        assertThat(parse("498,4 -> 498,6 -> 496,6")).containsExactlyInAnyOrder(498 to 4, 498 to 5, 498 to 6, 497 to 6, 496 to 6)
    }

    @Test
    fun `test part2`() {
        val instance = Day14()
        assertThat(instance.part2(sample1.lines()))
            .`as`("question example 2")
            .isEqualTo(93)
    }
}