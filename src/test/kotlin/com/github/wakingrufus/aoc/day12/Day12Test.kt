package com.github.wakingrufus.aoc.day12

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day12Test {
    private val sample1 = """Sabqponm
abcryxxl
accszExk
acctuvwj
abdefghi"""

    @Test
    fun `test part1`() {
        val instance = Day12()
        assertThat(instance.part1(sample1.lines()))
            .`as`("question example 1")
            .isEqualTo(31)
    }

    @Test
    fun `test part2`() {
        val instance = Day12()
        assertThat(instance.part2(sample1.lines()))
            .`as`("question example 2")
            .isEqualTo(29)
    }
}