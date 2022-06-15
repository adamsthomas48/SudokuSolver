abstract class CellSolutionStrategy {
    var numUses = 0
    var elapsedTime = 0.0
    var startTime: Long = 0L

    fun execute(puzzle: Puzzle): Boolean {
        startTimer()
        val result = findApplicableCells(puzzle)
        val cells = result.first
        var changeMade = false
        val manipulationParam = result.second
        if (cells.isNotEmpty()) {
            numUses++
            changeMade = applyChanges(puzzle, cells, manipulationParam)
        }
        elapsedTime += stopTimer()
        return changeMade

    }

    abstract fun findApplicableCells(puzzle: Puzzle): Pair<List<Cell>, Any>
    abstract fun applyChanges(puzzle: Puzzle, cells: List<Cell>, manipulationParam: Any): Boolean

    fun startTimer() {
        startTime = System.currentTimeMillis()
    }

    fun stopTimer(): Double {
        val endTime = System.currentTimeMillis()
        elapsedTime += (endTime - startTime) / 1000.0
        return (endTime - startTime) / 1000.0
    }
}