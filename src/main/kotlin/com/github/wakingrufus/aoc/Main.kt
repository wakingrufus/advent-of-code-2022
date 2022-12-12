package com.github.wakingrufus.aoc

import com.github.wakingrufus.aoc.day1.Day1
import com.github.wakingrufus.aoc.day10.Day10
import com.github.wakingrufus.aoc.day11.Day11
import com.github.wakingrufus.aoc.day12.Day12
import com.github.wakingrufus.aoc.day2.Day2
import com.github.wakingrufus.aoc.day3.Day3
import com.github.wakingrufus.aoc.day4.Day4
import com.github.wakingrufus.aoc.day5.Day5
import com.github.wakingrufus.aoc.day6.Day6
import com.github.wakingrufus.aoc.day7.Day7
import com.github.wakingrufus.aoc.day8.Day8
import com.github.wakingrufus.aoc.day9.Day9
import com.github.wakingrufus.util.outputResult
import com.github.wakingrufus.util.time

fun main(args: Array<String>) {
    listOf(Day1(), Day2(), Day3(), Day4(), Day5(), Day6(), Day7(),
        Day8(), Day9(), Day10(), Day11(), Day12()).forEach {
        it.run {
            val input = readInput()
            time { part1(input) }.also { outputResult(day, 1, it) }
            time { part2(input) }.also { outputResult(day, 2, it) }
        }
    }
}