class Puzzle(val n: Int, val cells: List<List<Cell>>) {

    fun printAttributes(){
        println("n: $n")
        //print value of cells
        for (row in cells) {
            for (cell in row) {
                print("${cell.value} ")
            }
            println()
        }
    }


}