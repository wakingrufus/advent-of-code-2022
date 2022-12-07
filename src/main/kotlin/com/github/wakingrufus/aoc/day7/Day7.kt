package com.github.wakingrufus.aoc.day7

import com.github.wakingrufus.aoc.AocDay

class Day7 : AocDay<Int>(7) {
    override fun part1(input: List<String>): Int {
        val fs = buildFilesystem(input)
        return fs.root.findAllDirs()
            .filter { it.size() < 100_000 }
            .sumOf { it.size() }
    }

    override fun part2(input: List<String>): Int {
        val fs = buildFilesystem(input)
        val spaceToFree = 30_000_000 - (70_000_000 - fs.root.size())
        return fs.root.findAllDirs()
            .filter { it.size() >= spaceToFree }
            .minOf { it.size() }
    }
}

class Filesystem(val root: Directory = Directory("/"))

sealed class FilesystemEntry(val name: String)
class File(name: String, val size: Int) : FilesystemEntry(name)
class Directory(
    name: String,
    val parent: Directory? = null,
    val children: MutableMap<String, FilesystemEntry> = mutableMapOf()
) : FilesystemEntry(name) {
    fun cd(name: String): Directory? {
        val child = children[name]
        return if (child is Directory) {
            child
        } else {
            null
        }
    }

    fun size(): Int {
        return children.values.filterIsInstance<File>()
            .sumOf { it.size } + children.values.filterIsInstance<Directory>().sumOf { it.size() }
    }

    fun findAllDirs(): List<Directory> {
        return listOf(this) + children.values.filterIsInstance<Directory>().flatMap { it.findAllDirs() }
    }
}

fun buildFilesystem(input: List<String>): Filesystem {
    val fs = Filesystem()
    var cwd: Directory? = null
    input.forEach {
        val lineTokens = it.split(" ")
        if (lineTokens[0] == "$") {
            val cmd = lineTokens[1]
            if (cmd == "cd") {
                val path = lineTokens[2]
                if (path.startsWith("/")) {
                    cwd = fs.root
                }
                path.split("/").filter { it.isNotBlank() }.forEach {
                    cwd = if (it == "..") {
                        cwd?.parent
                    } else {
                        cwd?.cd(it)
                    }
                }
            } else if (cmd == "ls") {
            }
        } else if (lineTokens[0] == "dir") {
            cwd?.children?.put(lineTokens[1], Directory(lineTokens[1], cwd))
        } else {
            cwd?.children?.put(lineTokens[1], File(lineTokens[1], lineTokens[0].toInt()))
        }
    }
    return fs
}