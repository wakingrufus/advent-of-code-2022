package com.github.wakingrufus.aoc

class Day1 : AocDay<Int>(1) {

    class Elf(val foodItems: List<Int>)

    override fun part1(input: List<String>): Int {
        val elves = processElves(input)
        return elves.maxOf { it.foodItems.sum() }
    }

    private fun processElves(input: List<String>): List<Elf> {
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

    override fun part2(input: List<String>): Int {
        val elves = processElves(input)
        return elves.map { it.foodItems.sum() }.sortedDescending().take(3).sum()
    }
}