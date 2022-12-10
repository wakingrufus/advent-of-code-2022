package com.github.wakingrufus.aoc.day3

import com.github.wakingrufus.aoc.AocDay

class Day3 : AocDay<Int, Int>(3) {
    val charString = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    override fun part1(input: List<String>): Int {
        return input.map { findCommonItem(it) }.sumOf { charString.indexOf(it) }
    }

    override fun part2(input: List<String>): Int {
        return input.chunked(3).map { findBadgeItem(it) }.sumOf { charString.indexOf(it) }
    }
}

fun findCommonItem(rucksack: String): Char {
    val compartments = rucksack.substring(0 until (rucksack.length / 2)) to rucksack.substring(rucksack.length / 2)
    return compartments.first.toCharArray().first { compartments.second.contains(it) }
}

fun findBadgeItem(rucksack: List<String>): Char {
    return rucksack.first().toCharArray().first { rucksack[1].contains(it) && rucksack[2].contains(it) }
}