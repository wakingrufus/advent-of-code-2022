package com.github.wakingrufus.aoc.day2

import com.github.wakingrufus.aoc.AocDay

class Day2 : AocDay<Int, Int>(2) {
    override fun part1(input: List<String>): Int {
        val rounds = input.map {
            Shape.fromLetter(it[0]) to Shape.fromLetter(it[2])
        }
        return rounds.sumOf { scoreRound(it) + it.second.points }
    }

    override fun part2(input: List<String>): Int {
        val rounds = input.map {
            val otherMove = Shape.fromLetter(it[0])
            otherMove to chooseShape(otherMove, Outcome.fromLetter(it[2]))
        }
        return rounds.sumOf { scoreRound(it) + it.second.points }
    }
}

enum class Outcome(val char: Char) {
    LOSE('X'), DRAW('Y'), WIN('Z');

    companion object {
        fun fromLetter(letter: Char): Outcome {
            return Outcome.values().first { letter == it.char }
        }
    }
}

enum class Shape(val points: Int, val letters: List<Char>) {
    ROCK(1, listOf('A', 'X')), PAPER(2, listOf('B', 'Y')), SCISSORS(3, listOf('C', 'Z'));

    companion object {
        fun fromLetter(letter: Char): Shape {
            return Shape.values().first { it.letters.contains(letter) }
        }
    }
}

fun chooseShape(otherShape: Shape, outcome: Outcome): Shape {
    return when (outcome) {
        Outcome.DRAW -> otherShape
        Outcome.LOSE -> when (otherShape) {
            Shape.ROCK -> Shape.SCISSORS
            Shape.PAPER -> Shape.ROCK
            Shape.SCISSORS -> Shape.PAPER
        }

        Outcome.WIN -> when (otherShape) {
            Shape.ROCK -> Shape.PAPER
            Shape.PAPER -> Shape.SCISSORS
            Shape.SCISSORS -> Shape.ROCK
        }
    }
}

fun scoreRound(round: Pair<Shape, Shape>): Int {
    return when (round.first) {
        round.second -> 3
        Shape.ROCK -> if (round.second == Shape.PAPER) 6 else 0
        Shape.PAPER -> if (round.second == Shape.SCISSORS) 6 else 0
        Shape.SCISSORS -> if (round.second == Shape.ROCK) 6 else 0
    }
}