class OnlyOnePossibilityStrategy: CellSolutionStrategy() {
    override fun findApplicableCells(puzzle: Puzzle): Pair<List<Cell>, Any> {

        for (row in puzzle.cells) {
            for(cell in row) {
                if(cell.value == "-"){
                    if(cell.isEditable) {
                        cell.setPossibleValues(puzzle)
                        if (cell.possibleValues.size == 1) {
                            return Pair(listOf(cell), cell.possibleValues.first())
                        }
                    }

                }

            }
        }
        return Pair(listOf(), "")
    }

    override fun applyChanges(puzzle: Puzzle, cells: List<Cell>, manipulationParam: Any): Boolean {

        if(cells.isEmpty()) {
            return false
        }
        val cell = cells.first()
        val value = manipulationParam as String
        if(cell.currentValue == "-") {
            cell.currentValue = value
            //println("Using OnlyOnePossibilityStrategy to set value of cell ${cell.rowIndex} ${cell.columnIndex} to $value")
            return true
        }
        return false

    }
}