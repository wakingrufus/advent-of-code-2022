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
        val expectedInstructions = listOf(
            Instruction(2, 1, 1),
            Instruction(1, 3, 3),
            Instruction(2, 1, 2),
            Instruction(1, 2, 1)
        )
        val (state, instructions) = processInput(sampleInput.lines())
        assertThat(instructions).containsExactlyElementsOf(expectedInstructions)
        assertThat(state[0].descendingIterator().asSequence().toList())
            .containsExactly('Z', 'N')
        assertThat(state[1].descendingIterator().asSequence().toList())
            .containsExactly('M', 'C', 'D')
        assertThat(state[2].descendingIterator().asSequence().toList()).containsExactly('P')
    }

    @Test
    fun `test part2`() {
        assertThat(Day5().part2(sampleInput.lines()))
            .`as`("question example")
            .isEqualTo("MCD")
    }

}