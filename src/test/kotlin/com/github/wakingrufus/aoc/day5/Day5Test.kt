package com.github.wakingrufus.aoc.day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day5Test {
    private val sampleInput = """    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2"""

    @Test
    fun `test part1`() {
        assertThat(Day5().part1(sampleInput.lines()))
            .`as`("question example")
            .isEqualTo("CMZ")
    }

    @Test
    fun `test processInput`() {
        val expected = Input(
            listOf(
                stackOf(Crate('Z'), Crate('N')),
                stackOf(Crate('M'), Crate('C'), Crate('D')),
                stackOf(Crate('P'))
            ),
            listOf(
                Instruction(2, 1, 1),
                Instruction(1, 3, 3),
                Instruction(2, 1, 2),
                Instruction(1, 2, 1)
            )
        )
        val actual = processInput(sampleInput.lines())
        assertThat(actual.instructions).containsExactlyElementsOf(expected.instructions)
        assertThat(actual.startingStacks[0].stream().toList()).containsExactly(Crate('Z'), Crate('N'))
        assertThat(actual.startingStacks[1].stream().toList())
            .containsExactly(Crate('M'), Crate('C'), Crate('D'))
        assertThat(actual.startingStacks[2].stream().toList()).containsExactly(Crate('P'))
    }

    @Test
    fun `test part2`() {
        assertThat(Day5().part2(sampleInput.lines()))
            .`as`("question example")
            .isEqualTo("MCD")
    }

}