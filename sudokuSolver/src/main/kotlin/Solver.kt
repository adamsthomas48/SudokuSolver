import java.io.File
import java.util.*

class Solver(val inputFileName: String) {
    val file = File(inputFileName)
    val n = file.readLines()[0].toInt()
    var cells = createCellList()
    val possibleValues = setPossibleValues()
    var currentPuzzle: Puzzle = Puzzle(n, cells, possibleValues)
    lateinit var originalPuzzle: Puzzle
    val puzzleStack: Stack<Puzzle> = Stack()
    var result: String = "Puzzle not solvable"
    var isSolvable = true
    var isValid = true
    val onlyOnePossibilityStrategy = OnlyOnePossibilityStrategy()
    //val nakedPairStrategy = NakedPairStrategy()
    val guessStrategy = GuessStrategy()
    var solutionCount = 0
    var solution: String = ""


    fun solve() {

        originalPuzzle = currentPuzzle.deepCopy()
        println()
        puzzleStack.push(currentPuzzle)
        while (!puzzleStack.empty() && !currentPuzzle.isSolved()) {
//            if(onlyOnePossibilityStrategy.execute(currentPuzzle)) {
//                continue
//            }
            if(guessStrategy.execute(currentPuzzle)) {
                // push this version of the puzzle onto the stack
                puzzleStack.push(currentPuzzle.deepCopy())
            } else {

                currentPuzzle = puzzleStack.pop()

            }
            if(currentPuzzle.isSolved()) {
                if(currentPuzzle.getPuzzleString() != solution) {
                    solutionCount++
                    println("Solution $solutionCount:")
                    currentPuzzle.printPuzzle()

                }


                if(solutionCount > 1){
                    isValid = false
                    break
                }
            }

        }
        printResult()

    }




    fun setPossibleValues(): List<String> {
        val possibleValues = mutableListOf<String>()
        file.readLines()[1].forEach {
            if (it != '-' && it != ' ') {
                possibleValues.add(it.toString())
            }
        }
        return possibleValues
    }

    fun printResult() {
        if(!isValid){
            result = "Puzzle is not valid: Has multiple solutions"
        }else if(currentPuzzle.isSolved()) {
            var totalTime = onlyOnePossibilityStrategy.elapsedTime + guessStrategy.elapsedTime
            var solvedResult = ""
            solvedResult += originalPuzzle.getPuzzleString()
            solvedResult += currentPuzzle.getPuzzleString() + "\n"

            solvedResult += "Total time: " + totalTime + "s\n"
            solvedResult += "Only one possibility strategy: " + onlyOnePossibilityStrategy.numUses + " - "
            solvedResult += "Elapsed time: " + onlyOnePossibilityStrategy.elapsedTime + "\n"
            solvedResult += "Guess strategy: " + guessStrategy.numUses + " - "
            solvedResult += "Elapsed time: " + guessStrategy.elapsedTime + "\n"


            result = solvedResult

        }
        println(result)
    }



    fun createCellList(): List<List<Cell>> {
        val cells = mutableListOf<List<Cell>>()
        val n: Int

        //read each character from row 2 onwards and create a cell for each
        for (i in 2 until file.readLines().size) {
            val row = mutableListOf<Cell>()
            file.readLines()[i].forEach {
                if(it != ' ') {
                    val cell = createCell(it.toString(), i - 2, row.size)

                    row.add(cell)
                }
            }
            cells.add(row)
        }

        return cells
    }

    fun createCell(value: String, i: Int, j: Int): Cell {
        val col = j
        val row = i
        //determine what sudoku block the cell is in based on i j and size n
        val block = getBlockIndex(i, j)
        return Cell(value, row, col, block, (value == "-"))

    }

    fun getBlockIndex(i: Int, j: Int): Int {

        val x = Math.floor(j / Math.sqrt(n.toDouble())).toInt()
        val y = Math.floor(i / Math.sqrt(n.toDouble())).toInt()
        return x + (y * Math.sqrt(n.toDouble()).toInt())

    }


}