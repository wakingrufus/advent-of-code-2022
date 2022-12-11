package com.github.wakingrufus.aoc.day11

import com.github.wakingrufus.aoc.AocDay
import com.github.wakingrufus.util.log

class Day11 : AocDay<Int, Long>(11) {

    override fun part1(input: List<String>): Int {
        val monkeys = processInput(input)
        repeat(20) {
            runRound(monkeys)
        }
        monkeys.forEachIndexed { index, monkey ->
            log.info("monkey $index inspected ${monkey.itemsInspected} items")
        }
        val sorted = monkeys.map { it.itemsInspected }.sortedDescending()
        return sorted[0] * sorted[1]
    }


    override fun part2(input: List<String>): Long {
        val monkeys = processInput(input)
        val commonDivisor = monkeys.fold(1L) { acc, monkey -> acc * monkey.test }
        repeat(10_000) {
            runRound(monkeys) { it.mod(commonDivisor) }
        }
        monkeys.forEachIndexed { index, monkey ->
            log.info("monkey $index inspected ${monkey.itemsInspected} items")
        }
        val sorted = monkeys.map { it.itemsInspected }.sortedDescending()
        return sorted[0].toLong() * sorted[1].toLong()
    }
}

fun runRound(monkeys: List<Monkey>, worryManagement: (Long) -> Long = { it / 3 }) {
    monkeys.forEach { monkey ->
        monkey.items.forEach {
            monkey.itemsInspected++
            val afterInspection =
                operation(monkey.operation)(it, if (monkey.operand == "old") it else monkey.operand.toLong())
            val afterRelief = worryManagement(afterInspection)
            if (afterRelief.mod(monkey.test) == 0) {
                monkeys[monkey.ifTrue].items.add(afterRelief)
            } else {
                monkeys[monkey.ifFalse].items.add(afterRelief)
            }
        }
        monkey.items.clear()
    }
}

fun operation(char: Char): (Long, Long) -> Long {
    return when (char) {
        '*' -> { i1, i2 -> i1 * i2 }
        '+' -> { i1, i2 -> i1 + i2 }
        '-' -> { i1, i2 -> i1 - i2 }
        '/' -> { i1, i2 -> i1 / i2 }
        else -> { i1, i2 -> 0 }
    }
}

fun processInput(input: List<String>): List<Monkey> {
    val monkeys: MutableList<Monkey> = mutableListOf()
    var items: MutableList<Long> = mutableListOf()
    var operation: Char? = null
    var operand: String? = null
    var test: Int? = null
    var ifTrue: Int? = null
    var ifFalse: Int? = null
    input.forEach { line ->
        if (line.startsWith("Monkey")) {
            if (ifFalse != null) {
                monkeys.add(Monkey(items, operation!!, operand!!, test!!, ifTrue!!, ifFalse!!))
            }
        } else if (line.contains("Starting items:")) {
            items = line.split(":")[1].trim().split(",").map { it.trim().toLong() }.toMutableList()
        } else if (line.contains("Operation:")) {
            val tokens = line.split("=")[1].trim().split(" ")
            operation = tokens[1][0]
            operand = tokens[2]
        } else if (line.contains("Test:")) {
            test = line.split(" ").last().toInt()
        } else if (line.contains("If true:")) {
            ifTrue = line.last().digitToInt()
        } else if (line.contains("If false:")) {
            ifFalse = line.last().digitToInt()
        }
    }
    monkeys.add(Monkey(items, operation!!, operand!!, test!!, ifTrue!!, ifFalse!!))
    return monkeys.toList()
}

data class Monkey(
    val items: MutableList<Long> = mutableListOf(),
    var operation: Char,
    var operand: String,
    var test: Int,
    var ifTrue: Int,
    var ifFalse: Int,
    var itemsInspected: Int = 0
)