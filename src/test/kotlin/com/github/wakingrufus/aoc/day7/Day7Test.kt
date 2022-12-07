package com.github.wakingrufus.aoc.day7

import com.github.wakingrufus.util.log
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day7Test {
    private val sample1 = """${'$'} cd /
${'$'} ls
dir a
14848514 b.txt
8504156 c.dat
dir d
${'$'} cd a
${'$'} ls
dir e
29116 f
2557 g
62596 h.lst
${'$'} cd e
${'$'} ls
584 i
${'$'} cd ..
${'$'} cd ..
${'$'} cd d
${'$'} ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k"""

    @Test
    fun `test part1`() {
        val instance = Day7()
        assertThat(instance.part1(sample1.lines()))
            .`as`("question example 1")
            .isEqualTo(95437)
    }

    @Test
    fun `test part2`() {
        val instance = Day7()
        assertThat(instance.part2(sample1.lines()))
            .`as`("question example 1")
            .isEqualTo(24933642)
    }

    @Test
    fun `test buildFilesystem`() {
        val actual = buildFilesystem(sample1.lines())
        assertThat(actual.root.children.keys).containsExactly("a", "b.txt", "c.dat", "d")
    }

    @Test
    fun `test findAllDirs`() {
        val actual = buildFilesystem(sample1.lines()).root.findAllDirs()
        actual.forEach {
            log.info("${it.name} ${it.size()}")
        }
        assertThat(actual.map { it.name }).containsExactlyInAnyOrder("/", "a", "e", "d")
    }
}