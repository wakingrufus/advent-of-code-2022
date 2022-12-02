package com.github.wakingrufus.aoc

class Day2 : AocDay<Int>(2) {

    override fun part1(input: List<String>): Int {
        val rounds = input.map {
            Shape.fromLetter(it[0]) to Shape.fromLetter(it[2])
        }
        return rounds.sumOf { scoreRound(it) + it.second.points }
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

    override fun part2(input: List<String>): Int {
        val rounds = input.map {
            val otherMove = Shape.fromLetter(it[0])
            otherMove to chooseShape(otherMove, Outcome.fromLetter(it[2]))
        }
        return rounds.sumOf { scoreRound(it) + it.second.points }
    }
}

fun chooseShape(otherShape: Day2.Shape, outcome: Day2.Outcome): Day2.Shape {
    return when (outcome) {
        Day2.Outcome.DRAW -> otherShape
        Day2.Outcome.LOSE -> when (otherShape) {
            Day2.Shape.ROCK -> Day2.Shape.SCISSORS
            Day2.Shape.PAPER -> Day2.Shape.ROCK
            Day2.Shape.SCISSORS -> Day2.Shape.PAPER
        }

        Day2.Outcome.WIN -> when (otherShape) {
            Day2.Shape.ROCK -> Day2.Shape.PAPER
            Day2.Shape.PAPER -> Day2.Shape.SCISSORS
            Day2.Shape.SCISSORS -> Day2.Shape.ROCK
        }
    }
}

fun scoreRound(round: Pair<Day2.Shape, Day2.Shape>): Int {
    return when (round.first) {
        round.second -> 3
        Day2.Shape.ROCK -> if (round.second == Day2.Shape.PAPER) 6 else 0
        Day2.Shape.PAPER -> if (round.second == Day2.Shape.SCISSORS) 6 else 0
        Day2.Shape.SCISSORS -> if (round.second == Day2.Shape.ROCK) 6 else 0
    }
}