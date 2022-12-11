package com.github.wakingrufus.aoc.day11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day11Test {
    private val sample1 = """Monkey 0:
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3

Monkey 1:
  Starting items: 54, 65, 75, 74
  Operation: new = old + 6
  Test: divisible by 19
    If true: throw to monkey 2
    If false: throw to monkey 0

Monkey 2:
  Starting items: 79, 60, 97
  Operation: new = old * old
  Test: divisible by 13
    If true: throw to monkey 1
    If false: throw to monkey 3

Monkey 3:
  Starting items: 74
  Operation: new = old + 3
  Test: divisible by 17
    If true: throw to monkey 0
    If false: throw to monkey 1"""

    @Test
    fun `test part1`() {
        val instance = Day11()
        assertThat(instance.part1(sample1.lines()))
            .`as`("question example 1")
            .isEqualTo(10605)
    }

    @Test
    fun `test part2`() {
        val instance = Day11()
        assertThat(instance.part2(sample1.lines()))
            .`as`("question example 2")
            .isEqualTo(2713310158)
    }

    @Test
    fun `test processInput`() {
        val actual = processInput(sample1.lines())
        assertThat(actual).containsExactly(
            Monkey(mutableListOf(79, 98), '*', "19", 23, 2, 3),
            Monkey(mutableListOf(54, 65, 75, 74), '+', "6", 19, 2, 0),
            Monkey(mutableListOf(79, 60, 97), '*', "old", 13, 1, 3),
            Monkey(mutableListOf(74), '+', "3", 17, 0, 1)
        )
    }

    @Test
    fun `test round`() {
        val monkeys = processInput(sample1.lines())
        runRound(monkeys)
        assertThat(monkeys[0].items).containsExactly(20, 23, 27, 26)
        assertThat(monkeys[1].items).containsExactly(2080, 25, 167, 207, 401, 1046)
        assertThat(monkeys[2].items).isEmpty()
        assertThat(monkeys[3].items).isEmpty()
    }

    @Test
    fun `test round no relief 1`() {
        val monkeys = processInput(sample1.lines())
        val commonDivisor =  monkeys.fold(1L){acc, monkey ->  acc * monkey.test }
        runRound(monkeys) { it.mod(commonDivisor) }
        assertThat(monkeys.map { it.itemsInspected }).containsExactly(2, 4, 3, 6)
    }

    @Test
    fun `test round no relief 20`() {
        val monkeys = processInput(sample1.lines())
        val commonDivisor =  monkeys.fold(1L){acc, monkey ->  acc * monkey.test }
        repeat(20){
            runRound(monkeys) { it.mod(commonDivisor) }
        }
        assertThat(monkeys.map { it.itemsInspected }).containsExactly(99, 97, 8, 103)
    }
    @Test
    fun `test round no relief 5000`() {
        val monkeys = processInput(sample1.lines())
        val commonDivisor =  monkeys.fold(1L){acc, monkey ->  acc * monkey.test }
        repeat(5000){
            runRound(monkeys) { it.mod(commonDivisor) }
        }
        assertThat(monkeys.map { it.itemsInspected }).containsExactly(26075, 23921, 974, 26000)
    }
    @Test
    fun `test round no relief 10000`() {
        val monkeys = processInput(sample1.lines())
        val commonDivisor =  monkeys.fold(1L){acc, monkey ->  acc * monkey.test }
        repeat(10000){
            runRound(monkeys){ it.mod(commonDivisor) }
        }
        assertThat(monkeys.map { it.itemsInspected }).containsExactly(52166, 47830, 1938, 52013)
    }
}