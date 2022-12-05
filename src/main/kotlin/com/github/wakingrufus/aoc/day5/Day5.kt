package com.github.wakingrufus.aoc.day5

import com.github.wakingrufus.aoc.AocDay
import java.util.*

class Day5 : AocDay<String>(5) {
    override fun part1(input: List<String>): String {
        val startingState = processInput(input)
        startingState.instructions.forEach { instruction ->
            repeat(instruction.quantity) {
                startingState.startingStacks[instruction.to - 1].push(
                    startingState.startingStacks[instruction.from - 1].pop()
                )
            }
        }
        return startingState.startingStacks.map { it.pop().char }.joinToString("")
    }

    override fun part2(input: List<String>): String {
        val startingState = processInput(input)
        startingState.instructions.forEach { instruction ->
            val tempStack = Stack<Crate>()
            repeat(instruction.quantity) {
                tempStack.push(
                    startingState.startingStacks[instruction.from - 1].pop()
                )
            }
            repeat(instruction.quantity) {
                startingState.startingStacks[instruction.to - 1].push(
                    tempStack.pop()
                )
            }
        }
        return startingState.startingStacks.map { it.pop().char }.joinToString("")
    }

}

@JvmInline
value class Crate(val char: Char)
data class Input(val startingStacks: List<Stack<Crate>>, val instructions: List<Instruction>)
data class Instruction(val from: Int, val to: Int, val quantity: Int)

fun processInput(input: List<String>): Input {
    val stacks = mutableMapOf<Int, MutableList<Crate>>()
    val instructions = mutableListOf<Instruction>()
    input.forEach { inputLine ->
        if (inputLine.contains("[")) {
            inputLine.indices.forEach {
                if (inputLine[it] == '[') {
                    stacks.computeIfAbsent((it / 4) + 1) { mutableListOf() }.add(Crate(inputLine[it + 1]))
                }
            }
        } else if (inputLine.startsWith("move")) {
            val tokens = inputLine.split(" ")
            instructions.add(Instruction(from = tokens[3].toInt(), tokens[5].toInt(), tokens[1].toInt()))
        }
    }
    return Input(
        stacks.toSortedMap()
            .values.toList()
            .map { stackOf(it.toList().asReversed()) },
        instructions
    )
}

fun <T> stackOf(vararg items: T): Stack<T> {
    val stack = Stack<T>()
    items.forEach {
        stack.push(it)
    }
    return stack
}


fun <T> stackOf(items: List<T>): Stack<T> {
    val stack = Stack<T>()
    items.forEach {
        stack.push(it)
    }
    return stack
}