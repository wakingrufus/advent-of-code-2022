package com.github.wakingrufus.aoc.day6

import com.github.wakingrufus.aoc.AocDay

class Day6 : AocDay<Int, Int>(6) {
    override fun part1(input: List<String>): Int {
        return findMarker(input.first(), 4)
    }

    fun findMarker(signal: String, numberOfDistinct: Int): Int {
        val unique = mutableListOf<Char>()
        signal.toCharArray().forEachIndexed { index, c ->
            while (unique.contains(c)) {
                unique.removeAt(0)
            }
            unique.add(c)
            if (unique.size == numberOfDistinct) {
                return index + 1
            }
        }
        return -1
    }

    override fun part2(input: List<String>): Int {
        return findMarker(input.first(), 14)
    }
}