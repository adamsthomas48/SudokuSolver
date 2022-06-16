import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PuzzleTest {
    val solver = Solver("src/puzzles/Puzzle-4x4-0001.txt")
    val puzzle = solver.currentPuzzle

    @Test
    fun getRows() {
        assertEquals(4, puzzle.rows.size)
    }

    @Test
    fun getColumns() {
        assertEquals(4, puzzle.columns.size)
    }

    @Test
    fun getBlocks() {
        assertEquals(4, puzzle.blocks.size)
    }

    @Test
    fun isSolved() {
        assertEquals(false, puzzle.isSolved())

    }

    @Test
    fun deepCopy() {
        val puzzle2 = puzzle.deepCopy()
        assertEquals(puzzle.cells.size, puzzle2.cells.size)
    }

    @Test
    fun printPuzzle() {
        puzzle.printPuzzle()
    }

    @Test
    fun getPuzzleString() {
        assertEquals(1,1)

    }

    @Test
    fun setRows() {
        assertEquals(1,1)

    }

    @Test
    fun setColumns() {
        assertEquals(1,1)
    }

    @Test
    fun setBlocks() {
        assertEquals(1,1)
    }

    @Test
    fun getN() {
        assertEquals(4, puzzle.n)
    }

    @Test
    fun getCells() {
        assertEquals(5, puzzle.cells.size)
    }

    @Test
    fun getPossibleValues() {
        assertEquals("1",puzzle.possibleValues[0])
    }
}