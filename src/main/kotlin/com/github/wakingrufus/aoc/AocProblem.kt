package com.github.wakingrufus.aoc

interface AocProblem<O> {
    fun processInput(): List<String>
    fun part1(input: List<String>): O
    fun part2(input: List<String>): O
}