class GuessStrategy: CellSolutionStrategy() {
    override fun findApplicableCells(puzzle: Puzzle): Pair<List<Cell>, Any> {
        // find first cell in puzzle.cells who's value is "-"
        for (row in puzzle.cells) {
            for (cell in row) {
                if (cell.value == "-") {
                    return Pair(listOf(cell), cell.value)
                }
            }
        }

        return Pair(listOf(), "")
    }

    override fun applyChanges(puzzle: Puzzle, cells: List<Cell>, manipulationParam: Any): Boolean {
        val cell = cells[0]
        val row = puzzle.rows[cell.rowIndex]
        val col = puzzle.columns[cell.columnIndex]
        val block = puzzle.blocks[cell.blockIndex]


        for (value in puzzle.possibleValues){
            if(row.search(value) && col.search(value) && block.search(value)){
                //println("==========================")
                cell.value = value
                //puzzle.printPuzzle()
                return true
            }
        }


        return false
    }
}