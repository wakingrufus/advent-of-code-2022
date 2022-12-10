package com.github.wakingrufus.aoc.day4

import com.github.wakingrufus.aoc.AocDay

class Day4 : AocDay<Int, Int>(4) {
    override fun part1(input: List<String>): Int {
        return input.count { fullyContains(it) }
    }

    override fun part2(input: List<String>): Int {
        return input.count { overlap(it) }
    }
}

fun parseRanges(line: String): Pair<IntRange, IntRange> {
    return line.split(",")
        .map { it.split("-").let { it[0] to it[1] } }
        .map { it.first.toInt()..it.second.toInt() }
        .let { it[0] to it[1] }
}

fun fullyContains(line: String): Boolean {
    val ranges = parseRanges(line)
    return ranges.first.all { ranges.second.contains(it) } || ranges.second.all { ranges.first.contains(it) }
}

fun overlap(line: String): Boolean {
    val ranges = parseRanges(line)
    return ranges.first.any { ranges.second.contains(it) } || ranges.second.any { ranges.first.contains(it) }
}