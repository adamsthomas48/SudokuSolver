class GuessStrategy: CellSolutionStrategy() {
    override fun findApplicableCells(puzzle: Puzzle): Pair<List<Cell>, Any> {
        // find first cell in puzzle.cells who's value is "-"
        val cells = mutableListOf<Cell>()
        for (row in puzzle.cells) {
            for (cell in row) {
                if (cell.currentValue == "-" && cell.isEditable) {
                    cells.add(cell)
                    return Pair(cells, cell.value)
                }
            }
        }

        return Pair(listOf(), "")
    }

    override fun applyChanges(puzzle: Puzzle, cells: List<Cell>, manipulationParam: Any): Boolean {
        val cell1 = cells[0]
        val row = puzzle.rows[cell1.rowIndex]
        val col = puzzle.columns[cell1.columnIndex]
        val block = puzzle.blocks[cell1.blockIndex]

//        println("Cell 1: ${cell1.rowIndex}, ${cell1.columnIndex}, ${cell1.blockIndex}")
//        print("row: ")
//        row.print()


        for (value in puzzle.possibleValues){
            if(row.search(value) && col.search(value) && block.search(value)){
                //println("==========================")
                println("Guess: ${cell1.rowIndex} ${cell1.columnIndex} ${cell1.currentValue}")
                print("Current Row: ")
                print(row.print())
                cell1.currentValue = value
                //puzzle.setCell(cell1)

                puzzle.printPuzzle()
                return true
            }
        }


        return false
    }
}