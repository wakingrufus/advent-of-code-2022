package com.github.wakingrufus.aoc

import com.github.wakingrufus.util.outputResult
import com.github.wakingrufus.util.time

fun main(args: Array<String>) {
    val days= listOf(Day1()).forEach{
        it.run {
            val input = processInput()
            time { part1(input) }.also { outputResult(day, 1, it) }
            time { part2(input) }.also { outputResult(day, 2, it) }
        }
    }
    Day1().run {

    }
}