package com.github.wakingrufus.aoc.day12

import com.github.wakingrufus.aoc.AocDay
import java.util.concurrent.CompletableFuture
import kotlin.math.absoluteValue

class Day12 : AocDay<Int, Int>(12) {

    override fun part1(input: List<String>): Int {
        val board: List<List<Space>> = buildBoard(input)
        return shortestPath(board.flatten().first { it.isStart }, board)
    }

    override fun part2(input: List<String>): Int {
        return buildBoard(input).flatten().filter { it.height == 0 }.map {
            CompletableFuture.supplyAsync {
                val newBoard = buildBoard(input)
                shortestPath(newBoard[it.y][it.x], newBoard)
            }
        }.minOf { it.join() }
    }
}

fun buildBoard(input: List<String>): List<List<Space>> {
    val charRange = ('a'..'z')
    return input.mapIndexed { yIndex, xLine ->
        xLine.mapIndexed { xIndex, c ->
            Space(
                x = xIndex,
                y = yIndex,
                height = if (c == 'S') 0 else if (c == 'E') 25 else charRange.indexOf(c),
                isStart = c == 'S',
                isEnd = c == 'E',
            )
        }
    }
}

data class Space(
    val x: Int, val y: Int, val height: Int, val isStart: Boolean = false, val isEnd: Boolean = false,
    var tentativeDistance: Int = Integer.MAX_VALUE, var visited: Boolean = false
)

fun shortestPath(start: Space, board: List<List<Space>>): Int {
    board.flatten().forEach {
        it.visited = false
        it.tentativeDistance = Integer.MAX_VALUE
    }
    start.tentativeDistance = 0
    val endSpace = board.flatten().first { it.isEnd }
    var currentNode: Space? = start
    while (currentNode != null && !endSpace.visited && board.flatten()
            .any { !it.visited && it.tentativeDistance < Integer.MAX_VALUE }
    ) {
        allNextSpaces(currentNode, board).forEach {
            it.tentativeDistance = minOf(currentNode!!.tentativeDistance + 1, it.tentativeDistance)
        }
        currentNode.visited = true
        currentNode = board.flatten().filter { !it.visited }.minByOrNull { it.tentativeDistance }
    }
    return endSpace.tentativeDistance
}

fun allNextSpaces(space: Space, board: List<List<Space>>): List<Space> {
    return board.flatten()
        .filter {
            val deltaX = (it.x - space.x).absoluteValue
            val deltaY = (it.y - space.y).absoluteValue
            deltaX <= 1 && deltaY <= 1 && (deltaX + deltaY) == 1
        }
        .filter { it.height <= space.height + 1 }
}
