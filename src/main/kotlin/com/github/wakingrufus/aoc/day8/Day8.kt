package com.github.wakingrufus.aoc.day8

import com.github.wakingrufus.aoc.AocDay

class Day8 : AocDay<Int>(8) {
    override fun part1(input: List<String>): Int {
        val grid = input.map {
            it.toCharArray().map { it.digitToInt() }
        }
        val height = grid.size
        val width = grid.first().size
        return (grid.indices).flatMap { y ->
            (0 until width).map { x ->
                val currentValue = grid[y][x]
                val sightLines = listOf((0 until y).map { grid[it][x] },
                    (0 until x).map { grid[y][it] },
                    (y + 1 until height).map { grid[it][x] },
                    (x + 1 until width).map { grid[y][it] }
                )
                sightLines.any { it.none { it >= currentValue } }
            }
        }.count { it }
    }

    override fun part2(input: List<String>): Int {
        val grid = input.map {
            it.toCharArray().map { it.digitToInt() }
        }
        val height = grid.size
        val width = grid.first().size
        return (grid.indices).flatMap { y ->
            (0 until width).map { x ->
                val currentValue = grid[y][x]
                val sightLines = listOf((0 until y).map { grid[it][x] }.reversed(),
                    (0 until x).map { grid[y][it] }.reversed(),
                    (y + 1 until height).map { grid[it][x] },
                    (x + 1 until width).map { grid[y][it] }
                )
                sightLines.map { sightLine ->
                    sightLine.firstOrNull { it >= currentValue }
                        ?.let { sightLine.indexOf(it) + 1 } ?: sightLine.size
                }.reduce { a, b -> a * b }
            }
        }.max()
    }
}