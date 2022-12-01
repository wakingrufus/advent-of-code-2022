package com.github.wakingrufus.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day1Test {
    @Test
    fun `test part1`() {
        val input = """1000
2000
3000

4000

5000
6000

7000
8000
9000

10000""".lines()
        assertThat(Day1().part1(input))
            .`as`("question example")
            .isEqualTo(24_000)
    }

    @Test
    fun `test processInput`() {
        Day1().processInput()
    }

    @Test
    fun `test part2`() {
        val input = """1000
2000
3000

4000

5000
6000

7000
8000
9000

10000""".lines()
        assertThat(Day1().part2(input))
            .`as`("question example")
            .isEqualTo(45_000)
    }

}