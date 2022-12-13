package com.github.wakingrufus.aoc.day13

import com.github.wakingrufus.aoc.AocDay
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

class Day13 : AocDay<Int, Int>(13) {

    override fun part1(input: List<String>): Int {
        return input.asSequence().filter { it.isNotBlank() }
            .chunked(size = 2)
            .map { it.first() to it.last() }
            .mapIndexed { i, p ->
                if (inRightOrder(p.first, p.second).also {
                        //   logger.info { "sample $i is $it" }
                    }) i + 1 else 0
            }
            .sum()
    }

    override fun part2(input: List<String>): Int {
        val divider1 = "[[2]]"
        val divider2 = "[[6]]"
        val sorted = (input.filter { it.isNotBlank() } + listOf(divider1, divider2)).sortedWith { a, b ->
            if (inRightOrder(a, b)) -1 else 1
        }
        return (sorted.indexOf(divider1) + 1) * (sorted.indexOf(divider2) + 1)
    }
}

fun inRightOrder(leftSignal: String, rightSignal: String): Boolean {
    var lSignal = leftSignal
    var rSignal = rightSignal
    while (lSignal.isNotEmpty() && rSignal.isNotEmpty()) {
        lSignal = lSignal.removePrefix(",")
        rSignal = rSignal.removePrefix(",")
        if (lSignal[0] == ']' && rSignal[0] == ']') {
            lSignal = lSignal.removePrefix("]")
            rSignal = rSignal.removePrefix("]")
        } else if (lSignal[0] == '[' && rSignal[0] == '[') {
            lSignal = lSignal.removePrefix("[")
            rSignal = rSignal.removePrefix("[")
        } else if (rSignal[0] == ']') {
            return false
        } else if (lSignal[0] == ']') {
            return true
        } else if (lSignal[0] == '[') {
            val rNumber = rSignal.getNumber()
            rSignal = "[" + rNumber + "]" + rSignal.removePrefix(rNumber.toString())
        } else if (rSignal[0] == '[') {
            val lNumber = lSignal.getNumber()
            lSignal = "[" + lNumber + "]" + lSignal.removePrefix(lNumber.toString())
        } else {
            val lNumber = lSignal.getNumber()
            val rNumber = rSignal.getNumber()
            if (lNumber > rNumber) {
                return false
            } else if (rNumber > lNumber) {
                return true
            } else {
                rSignal = rSignal.removePrefix(rNumber.toString())
                lSignal = lSignal.removePrefix(lNumber.toString())
            }
        }
    }
    if (rSignal.isEmpty() && lSignal.isNotEmpty()) {
        return false
    }
    return true
}

fun String.getNumber(): Int {
    return if (all { it.isDigit() }) {
        toInt()
    } else {
        substring(0, indexOfFirst { !it.isDigit() }).toInt()
    }
}


