package com.github.wakingrufus.aoc.day8

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day8Test {
    private val sample1 = """30373
25512
65332
33549
35390"""

    @Test
    fun `test part1`() {
        val instance = Day8()
        assertThat(instance.part1(sample1.lines()))
            .`as`("question example 1")
            .isEqualTo(21)
    }

    @Test
    fun `test part2`() {
        val instance = Day8()
        assertThat(instance.part2(sample1.lines()))
            .`as`("question example 1")
            .isEqualTo(8)
    }
}