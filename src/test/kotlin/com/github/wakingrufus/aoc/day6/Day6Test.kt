package com.github.wakingrufus.aoc.day6

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day6Test {
    private val sample1 = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
    private val sample2 = "bvwbjplbgvbhsrlpgdmjqwftvncz"
    private val sample3 = "nppdvjthqldpwncqszvftbrmjlhg"
    private val sample4 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"
    private val sample5 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"

    @Test
    fun `test part1`() {
        val instance = Day6()
        assertThat(instance.part1(listOf(sample1)))
            .`as`("question example 1")
            .isEqualTo(7)
        assertThat(instance.part1(listOf(sample2)))
            .`as`("question example 2")
            .isEqualTo(5)
        assertThat(instance.part1(listOf(sample3)))
            .`as`("question example 3")
            .isEqualTo(6)
        assertThat(instance.part1(listOf(sample4)))
            .`as`("question example 4")
            .isEqualTo(10)
        assertThat(instance.part1(listOf(sample5)))
            .`as`("question example 5")
            .isEqualTo(11)
    }

    @Test
    fun `test part2`() {
        val instance = Day6()
        assertThat(instance.part2(listOf(sample1)))
            .`as`("question example 1")
            .isEqualTo(19)
        assertThat(instance.part2(listOf(sample2)))
            .`as`("question example 2")
            .isEqualTo(23)
        assertThat(instance.part2(listOf(sample3)))
            .`as`("question example 3")
            .isEqualTo(23)
        assertThat(instance.part2(listOf(sample4)))
            .`as`("question example 4")
            .isEqualTo(29)
        assertThat(instance.part2(listOf(sample5)))
            .`as`("question example 5")
            .isEqualTo(26)
    }

}