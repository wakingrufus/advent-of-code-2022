package com.github.wakingrufus.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day2Test {
    @Test
    fun `test part1`() {
        val input = """A Y
B X
C Z""".lines()
        assertThat(Day2().part1(input))
            .`as`("question example")
            .isEqualTo(15)
    }

    @Test
    fun `test processInput`() {
        Day2().processInput()
    }

    @Test
    fun `test part2`() {
        val input = """A Y
B X
C Z""".lines()
        assertThat(Day2().part2(input))
            .`as`("question example")
            .isEqualTo(12)
    }

    @Test
    fun `test scoreRound`(){
        assertThat(scoreRound(Pair(Day2.Shape.ROCK, Day2.Shape.SCISSORS))).isEqualTo(0)
        assertThat(scoreRound(Pair(Day2.Shape.ROCK, Day2.Shape.PAPER))).isEqualTo(6)
        assertThat(scoreRound(Pair(Day2.Shape.ROCK, Day2.Shape.ROCK))).isEqualTo(3)
        assertThat(scoreRound(Pair(Day2.Shape.PAPER, Day2.Shape.SCISSORS))).isEqualTo(6)
        assertThat(scoreRound(Pair(Day2.Shape.PAPER, Day2.Shape.PAPER))).isEqualTo(3)
        assertThat(scoreRound(Pair(Day2.Shape.PAPER, Day2.Shape.ROCK))).isEqualTo(0)
        assertThat(scoreRound(Pair(Day2.Shape.SCISSORS, Day2.Shape.SCISSORS))).isEqualTo(3)
        assertThat(scoreRound(Pair(Day2.Shape.SCISSORS, Day2.Shape.PAPER))).isEqualTo(0)
        assertThat(scoreRound(Pair(Day2.Shape.SCISSORS, Day2.Shape.ROCK))).isEqualTo(6)
    }
}