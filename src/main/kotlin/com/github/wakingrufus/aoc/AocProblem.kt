package com.github.wakingrufus.aoc

interface AocProblem<O,P> {
    fun readInput(): List<String>
    fun part1(input: List<String>): O
    fun part2(input: List<String>): P
}