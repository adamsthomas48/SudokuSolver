import com.google.gson.Gson

class Cell(var value: String, val rowIndex: Int, val columnIndex: Int, val blockIndex: Int, val isEditable: Boolean) {
    var currentValue = value
    val possibleValues = mutableListOf<String>()

    fun setPossibleValues(puzzle: Puzzle) {
        possibleValues.clear()
        val row = puzzle.rows[rowIndex]
        val col = puzzle.columns[columnIndex]
        val block = puzzle.blocks[blockIndex]


        for (value in puzzle.possibleValues){
            if(row.search(value) && col.search(value) && block.search(value)){
                possibleValues.add(value)
            }
        }

    }

    fun deepCopy(): Cell {
        return Gson().fromJson(Gson().toJson(this), this.javaClass)
    }





}