package com.github.wakingrufus.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger

interface LoggingContext<T : Any> {
    val T.log: Logger
        get() = getLogger(this::class.java)
}