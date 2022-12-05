package com.github.wakingrufus.aoc.day5

import com.github.wakingrufus.aoc.AocDay
import java.util.*

class Day5 : AocDay<String>(5) {
    override fun part1(input: List<String>): String {
        val (state, instructions) = processInput(input)
        instructions.forEach { instruction ->
            repeat(instruction.quantity) {
                state[instruction.to - 1].push(
                    state[instruction.from - 1].pop()
                )
            }
        }
        return state.map { it.first }.joinToString("")
    }

    override fun part2(input: List<String>): String {
        val (state, instructions) = processInput(input)
        instructions.forEach { instruction ->
            val tempStack = ArrayDeque<Char>()
            repeat(instruction.quantity) {
                tempStack.push(
                    state[instruction.from - 1].pop()
                )
            }
            repeat(instruction.quantity) {
                state[instruction.to - 1].push(
                    tempStack.pop()
                )
            }
        }
        return state.map { it.first }.joinToString("")
    }

}

data class Instruction(val from: Int, val to: Int, val quantity: Int)

fun processInput(input: List<String>): Pair<List<Deque<Char>>, List<Instruction>> {
    val stacks = mutableMapOf<Int, MutableList<Char>>()
    val instructions = mutableListOf<Instruction>()
    input.forEach { inputLine ->
        if (inputLine.contains("[")) {
            inputLine.indices.forEach {
                if (inputLine[it] == '[') {
                    stacks.computeIfAbsent((it / 4) + 1) { mutableListOf() }.add(inputLine[it + 1])
                }
            }
        } else if (inputLine.startsWith("move")) {
            val tokens = inputLine.split(" ")
            instructions.add(Instruction(from = tokens[3].toInt(), tokens[5].toInt(), tokens[1].toInt()))
        }
    }
    return stacks.keys.sorted()
        .map { ArrayDeque(stacks[it]) } to instructions
}