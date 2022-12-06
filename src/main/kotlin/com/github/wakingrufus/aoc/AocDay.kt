package com.github.wakingrufus.aoc

import com.github.wakingrufus.util.inputFileToLines

abstract class AocDay<O>(val day: Int) : AocProblem<O> {
    override fun readInput(): List<String> {
        return inputFileToLines("input-day$day.txt")
            .map {
                //        log.debug(it)
                it
            }
    }
}