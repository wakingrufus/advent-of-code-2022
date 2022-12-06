package com.github.wakingrufus.util

import java.time.Duration
import java.time.Instant

fun inputFileToLines(fileName: String): List<String> {
    val resource = ClassLoader.getSystemResourceAsStream(fileName)
        ?: throw RuntimeException("input file $fileName is missing")
    return resource.bufferedReader()
        .use { it.readLines() }
}

class TimedResult<T>(val duration: Duration, val result: T)

fun <T> time(function: () -> T): TimedResult<T> {
    val startTime = Instant.now()
    val result = function()
    val endTime = Instant.now()
    return TimedResult(duration = Duration.between(startTime, endTime), result = result)
}

fun <T> outputResult(day: Int, part: Int, timedResult: TimedResult<T>) {
    timedResult.also {
        println("Day $day Part $part Time: ${it.duration.toMillis()} ms (${it.duration.toNanos().div(1000)} μs) \tResult: ${it.result}")
    }
}