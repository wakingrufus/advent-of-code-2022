package com.github.wakingrufus.aoc.day13

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day13Test {
    private val sample1 = """[1,1,3,1,1]
[1,1,5,1,1]

[[1],[2,3,4]]
[[1],4]

[9]
[[8,7,6]]

[[4,4],4,4]
[[4,4],4,4,4]

[7,7,7,7]
[7,7,7]

[]
[3]

[[[]]]
[[]]

[1,[2,[3,[4,[5,6,7]]]],8,9]
[1,[2,[3,[4,[5,6,0]]]],8,9]"""

    @Test
    fun `test part1`() {
        val instance = Day13()
        assertThat(instance.part1(sample1.lines()))
            .`as`("question example 1")
            .isEqualTo(13)
    }

    @Test
    fun `test in right order`() {
        assertThat(inRightOrder("[1,1,3,1,1]", "[1,1,5,1,1]")).isTrue
        assertThat(inRightOrder("[[1],[2,3,4]]", "[[1],4]")).isTrue
    }

    @Test
    fun `test part2`() {
        val instance = Day13()
        assertThat(instance.part2(sample1.lines()))
            .`as`("question example 2")
            .isEqualTo(140)
    }
}