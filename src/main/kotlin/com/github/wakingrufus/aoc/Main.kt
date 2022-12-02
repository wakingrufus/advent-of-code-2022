package com.github.wakingrufus.aoc

import com.github.wakingrufus.aoc.day1.Day1
import com.github.wakingrufus.aoc.day2.Day2
import com.github.wakingrufus.util.outputResult
import com.github.wakingrufus.util.time

fun main(args: Array<String>) {
    listOf(Day1(), Day2()).forEach {
        it.run {
            val input = processInput()
            time { part1(input) }.also { outputResult(day, 1, it) }
            time { part2(input) }.also { outputResult(day, 2, it) }
        }
    }
}