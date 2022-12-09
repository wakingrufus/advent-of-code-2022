package com.github.wakingrufus.aoc.day9

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day9Test {
    private val sample1 = """R 4
U 4
L 3
D 1
R 4
D 1
L 5
R 2"""
    private val sample2 = """R 5
U 8
L 8
D 3
R 17
D 10
L 25
U 20"""

    @Test
    fun `test part1`() {
        val instance = Day9()
        assertThat(instance.part1(sample1.lines()))
            .`as`("question example 1")
            .isEqualTo(13)
    }

    @Test
    fun `test part2`() {
        val instance = Day9()
        assertThat(instance.part2(sample2.lines()))
            .`as`("question example 2")
            .isEqualTo(36)
    }
}