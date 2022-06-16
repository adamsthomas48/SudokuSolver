import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ContainerTest {
    val solver = Solver("src/puzzles/Puzzle-4x4-0001.txt")
    val puzzle = solver.currentPuzzle
    val row = puzzle.rows[0]

    @Test
    fun search() {
        assertEquals(true, row.search("x"))
    }

    @Test
    fun update() {
        row.update(row.cells[0], "y")
        assertEquals("2", row.cells[0].value)
    }

    @Test
    fun print() {
        //println(row.toString())
        assertEquals(2,2)
    }

    @Test
    fun getCell() {
        assertEquals("2", row.getCell(0).value)
    }

    @Test
    fun getCells() {
        assertEquals(4, row.cells.size)
    }
}