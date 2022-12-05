package com.github.wakingrufus.aoc.day2

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
    fun `test part2`() {
        val input = """A Y
B X
C Z""".lines()
        assertThat(Day2().part2(input))
            .`as`("question example")
            .isEqualTo(12)
    }

    @Test
    fun `test scoreRound`() {
        assertThat(scoreRound(Shape.ROCK to Shape.SCISSORS)).isEqualTo(0)
        assertThat(scoreRound(Pair(Shape.ROCK, Shape.PAPER))).isEqualTo(6)
        assertThat(scoreRound(Pair(Shape.ROCK, Shape.ROCK))).isEqualTo(3)
        assertThat(scoreRound(Pair(Shape.PAPER, Shape.SCISSORS))).isEqualTo(6)
        assertThat(scoreRound(Pair(Shape.PAPER, Shape.PAPER))).isEqualTo(3)
        assertThat(scoreRound(Pair(Shape.PAPER, Shape.ROCK))).isEqualTo(0)
        assertThat(scoreRound(Pair(Shape.SCISSORS, Shape.SCISSORS))).isEqualTo(3)
        assertThat(scoreRound(Pair(Shape.SCISSORS, Shape.PAPER))).isEqualTo(0)
        assertThat(scoreRound(Pair(Shape.SCISSORS, Shape.ROCK))).isEqualTo(6)
    }

    @Test
    fun `test chooseShape`() {
        assertThat(chooseShape(Shape.ROCK, Outcome.DRAW)).isEqualTo(Shape.ROCK)
        assertThat(chooseShape(Shape.ROCK, Outcome.WIN)).isEqualTo(Shape.PAPER)
        assertThat(chooseShape(Shape.ROCK, Outcome.LOSE)).isEqualTo(Shape.SCISSORS)

        assertThat(chooseShape(Shape.PAPER, Outcome.DRAW)).isEqualTo(Shape.PAPER)
        assertThat(chooseShape(Shape.PAPER, Outcome.WIN)).isEqualTo(Shape.SCISSORS)
        assertThat(chooseShape(Shape.PAPER, Outcome.LOSE)).isEqualTo(Shape.ROCK)

        assertThat(chooseShape(Shape.SCISSORS, Outcome.DRAW)).isEqualTo(Shape.SCISSORS)
        assertThat(chooseShape(Shape.SCISSORS, Outcome.WIN)).isEqualTo(Shape.ROCK)
        assertThat(chooseShape(Shape.SCISSORS, Outcome.LOSE)).isEqualTo(Shape.PAPER)
    }
}