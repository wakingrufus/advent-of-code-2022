package com.github.wakingrufus.aoc.day1

import com.github.wakingrufus.aoc.AocDay

class Day1 : AocDay<Int>(1) {
    override fun part1(input: List<String>): Int {
        val elves = processElves(input)
        return elves.maxOf { it.foodItems.sum() }
    }

    override fun part2(input: List<String>): Int {
        val elves = processElves(input)
        return elves.map { it.foodItems.sum() }.sorted().takeLast(3).sum()
    }
}

class Elf(val foodItems: List<Int>)

fun processElves(input: List<String>): List<Elf> {
    val elves = mutableListOf<Elf>()
    var tempList = mutableListOf<Int>()
    input.forEach {
        if (it.isBlank()) {
            elves.add(Elf(tempList.toList()))
            tempList = mutableListOf()
        } else {
            tempList.add(it.toInt())
        }
    }
    if (tempList.isNotEmpty()) {
        elves.add(Elf(tempList.toList()))
    }
    return elves
}