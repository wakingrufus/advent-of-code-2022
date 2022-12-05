package com.github.wakingrufus.aoc.day4

import com.github.wakingrufus.util.LoggingContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day4Test : LoggingContext<Day4Test> {
    @Test
    fun `test part1`() {
        val input = """2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8""".lines()
        assertThat(Day4().part1(input))
            .`as`("question example")
            .isEqualTo(2)
    }

    @Test
    fun `test part2`() {
        val input = """2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8""".lines()
        assertThat(Day4().part2(input))
            .`as`("question example")
            .isEqualTo(4)
    }

    @Test
    fun `test fullyContains`() {
        assertThat(fullyContains("2-4,6-8")).isFalse
        assertThat(fullyContains("2-3,4-5")).isFalse
        assertThat(fullyContains("5-7,7-9")).isFalse
        assertThat(fullyContains("2-8,3-7")).isTrue
        assertThat(fullyContains("6-6,4-6")).isTrue
        assertThat(fullyContains("2-6,4-8")).isFalse
    }

    @Test
    fun `test overlap`() {
        assertThat(overlap("2-4,6-8")).isFalse
        assertThat(overlap("2-3,4-5")).isFalse
        assertThat(overlap("5-7,7-9")).isTrue
        assertThat(overlap("2-8,3-7")).isTrue
        assertThat(overlap("6-6,4-6")).isTrue
        assertThat(overlap("2-6,4-8")).isTrue
    }

    @Test
    fun `test parseRanges`() {
        assertThat(parseRanges("5-7,7-9")).isEqualTo((5..7) to (7..9))
    }
}