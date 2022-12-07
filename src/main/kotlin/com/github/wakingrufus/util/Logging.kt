package com.github.wakingrufus.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.LoggerFactory.getLogger
import java.util.concurrent.ConcurrentHashMap

val rootLogger = LoggerFactory.getLogger("root")
val map: MutableMap<Class<*>, Logger> = ConcurrentHashMap()
val Any.log: Logger
    get() = map.computeIfAbsent(this::class.java) { getLogger(this::class.java) }