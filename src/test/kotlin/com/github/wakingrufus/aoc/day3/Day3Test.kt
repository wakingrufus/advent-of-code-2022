package com.github.wakingrufus.aoc.day3

import com.github.wakingrufus.util.LoggingContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day3Test : LoggingContext<Day3Test> {
    @Test
    fun `test part1`() {
        val input = """vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw""".lines()
        assertThat(Day3().part1(input))
            .`as`("question example")
            .isEqualTo(157)
    }

    @Test
    fun `test processInput`() {
        Day3().processInput()
    }

    @Test
    fun `test part2`() {
        val input = """vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw""".lines()
        assertThat(Day3().part2(input))
            .`as`("question example")
            .isEqualTo(70)
    }

    @Test
    fun `test findCommonItem`() {
        assertThat(findCommonItem("vJrwpWtwJgWrhcsFMMfFFhFp")).isEqualTo('p')
        assertThat(findCommonItem("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL")).isEqualTo('L')
        assertThat(findCommonItem("PmmdzqPrVvPwwTWBwg")).isEqualTo('P')
        assertThat(findCommonItem("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn")).isEqualTo('v')
        assertThat(findCommonItem("ttgJtRGJQctTZtZT")).isEqualTo('t')
        assertThat(findCommonItem("CrZsJsPPZsGzwwsLwLmpwMDw")).isEqualTo('s')
    }

    @Test
    fun `test findBadgeItem`() {
        assertThat(
            findBadgeItem(listOf("vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg"))
        )
            .isEqualTo('r')
        assertThat(
            findBadgeItem(listOf("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw"))
        )
            .isEqualTo('Z')
    }
}