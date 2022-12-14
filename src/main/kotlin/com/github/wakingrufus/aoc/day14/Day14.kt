package com.github.wakingrufus.aoc.day14

import com.github.wakingrufus.aoc.AocDay
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class Day14 : AocDay<Int, Int>(14) {

    override fun part1(input: List<String>): Int {
        val rocks = input.flatMap { parse(it) }
        val sand = mutableSetOf<Pair<Int, Int>>()
        var currentGrain: Pair<Int, Int>? = 500 to 0
        while (currentGrain != null) {
            currentGrain = if (rocks.none { it.first == currentGrain!!.first && it.second > currentGrain!!.second }
                && sand.none { it.first == currentGrain!!.first && it.second > currentGrain!!.second }) {
                null
            } else {
                val downSpot = currentGrain.copy(second = currentGrain.second + 1)
                val leftSpot = currentGrain.copy(second = currentGrain.second + 1, first = currentGrain.first - 1)
                val rightSpot = currentGrain.copy(second = currentGrain.second + 1, first = currentGrain.first + 1)
                val newSpot = listOf(downSpot, leftSpot, rightSpot).firstOrNull { !rocks.contains(it) && !sand.contains(it) } ?: currentGrain
                if (currentGrain == newSpot) {
                    sand.add(currentGrain)
                    500 to 0
                } else {
                    newSpot
                }
            }
        }
        return sand.size
    }

    override fun part2(input: List<String>): Int {
        val rocks = input.flatMap { parse(it) }
        val sand = mutableSetOf<Pair<Int, Int>>()
        val bottom = rocks.maxOf { it.second } + 2
        var nextSand = listOf(500 to 0)
        while (nextSand.isNotEmpty()) {
            sand.addAll(nextSand)
            nextSand = nextSand
                .flatMap { it.spread() }
                .toSet()
                .filter { !rocks.contains(it) && it.second < bottom }
        }
        return sand.size
    }
}

fun Pair<Int, Int>.spread(): List<Pair<Int, Int>> {
    return listOf(first to second + 1, first - 1 to second + 1, first + 1 to second + 1)
}

fun parse(input: String): Set<Pair<Int, Int>> {
    val pairs = input.split("->")
        .map { it.trim() }
        .map { it.split(",") }
        .map { it[0].toInt() to it[1].toInt() }
    return pairs.zipWithNext { a, b ->
        (minOf(a.first, b.first)..maxOf(a.first, b.first))
            .flatMap { x ->
                (minOf(a.second, b.second)..maxOf(a.second, b.second))
                    .map { y -> x to y }
            }
    }
        .flatten()
        .toSet()
}

