package com.github.wakingrufus.aoc.day9

import com.github.wakingrufus.aoc.AocDay
import kotlin.math.abs
import kotlin.math.sign

class Day9 : AocDay<Int>(9) {
    override fun part1(input: List<String>): Int {
        val vistedLocations = mutableSetOf<Location>()
        var hLocation = Location(0, 0)
        var tLocation: Location = Location(0, 0)
        input.forEach {
            val tokens = it.split(" ")
            repeat(tokens[1].toInt()) {
                when (tokens[0]) {
                    "L" -> hLocation = hLocation.moveLeft()
                    "R" -> hLocation = hLocation.moveRight()
                    "U" -> hLocation = hLocation.moveUp()
                    "D" -> hLocation = hLocation.moveDown()
                }
                tLocation = tLocation.chase(hLocation)
                vistedLocations.add(tLocation)
            }
        }
        return vistedLocations.size
    }

    override fun part2(input: List<String>): Int {
        val vistedLocations = mutableSetOf<Location>()
        var rope = (1..10).map { Location(0, 0) }
        input.forEach {
            val tokens = it.split(" ")
            repeat(tokens[1].toInt()) {
                var lastKnot = rope.first()
                rope = rope.mapIndexed { index, location ->
                    (if (index == 0) when (tokens[0]) {
                        "L" -> location.moveLeft()
                        "R" -> location.moveRight()
                        "U" -> location.moveUp()
                        "D" -> location.moveDown()
                        else -> {
                            location
                        }
                    } else location.chase(lastKnot)).also { lastKnot = it }
                }
                vistedLocations.add(rope.last())
            }
        }
        return vistedLocations.size
    }
}

data class Location(val x: Int, val y: Int) {
    fun moveUp(): Location {
        return this.copy(y = y + 1)
    }

    fun moveDown(): Location {
        return this.copy(y = this.y - 1)
    }

    fun moveLeft(): Location {
        return this.copy(x = x - 1)
    }

    fun moveRight(): Location {
        return this.copy(x = x + 1)
    }

    fun chase(otherLocation: Location): Location {
        val xDelta = otherLocation.x - x
        val yDelta = otherLocation.y - y
        if (abs(xDelta) > 1) {
            return Location(
                x = x + xDelta.sign,
                y = y + yDelta.sign
            )
        }
        if (abs(yDelta) > 1) {
            return Location(
                x = x + xDelta.sign,
                y = y + yDelta.sign
            )
        }
        return this
    }
}