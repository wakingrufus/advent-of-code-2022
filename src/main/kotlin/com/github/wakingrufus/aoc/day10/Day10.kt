package com.github.wakingrufus.aoc.day10

import com.github.wakingrufus.aoc.AocDay

class Day10 : AocDay<Int, String>(10) {

    override fun part1(input: List<String>): Int {
        var strengthTotal = 0
        var x = 1
        var cycle = 1
        input.forEach { s ->
            var runningInstruction1: Int? = null
            var runningInstruction2: Int? = null
            if (s.startsWith("addx")) {
                runningInstruction1 = s.replace("addx ", "").toInt()
            }
            do {
                if ((cycle - 20).mod(40) == 0) {
                    strengthTotal += cycle * x
                }
                x += (runningInstruction2 ?: 0)
                runningInstruction2 = runningInstruction1
                runningInstruction1 = null
                cycle++
            } while (runningInstruction2 != null)
        }
        return strengthTotal
    }


    override fun part2(input: List<String>): String {
        val lines: MutableList<String> = mutableListOf()
        var currentLine: MutableList<Char> = mutableListOf()
        var x = 1
        var cycle = 1
        input.forEach { s ->
            var runningInstruction1: Int? = null
            var runningInstruction2: Int? = null
            if (s.startsWith("addx")) {
                runningInstruction1 = s.replace("addx ", "").toInt()
            }
            do {
                currentLine.add(if (currentLine.size >= x - 1 && currentLine.size <= x + 1) '#' else '.')
                if (currentLine.size == 40) {
                    lines.add(currentLine.joinToString(""))
                    currentLine = mutableListOf()
                }
                x += (runningInstruction2 ?: 0)
                runningInstruction2 = runningInstruction1
                runningInstruction1 = null
                cycle++
            } while (runningInstruction2 != null)
        }
        return "\n"+lines.joinToString("\n")
    }
}