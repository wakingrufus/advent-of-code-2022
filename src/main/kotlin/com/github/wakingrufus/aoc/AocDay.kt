package com.github.wakingrufus.aoc

import com.github.wakingrufus.util.inputFileToLines

abstract class AocDay<O,P>(val day: Int) : AocProblem<O,P> {
    override fun readInput(): List<String> {
        return inputFileToLines("input-day$day.txt")
            .map {
                //        log.debug(it)
                it
            }
    }
}