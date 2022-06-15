import com.google.gson.Gson

data class Cell(var value: String, val rowIndex: Int, val columnIndex: Int, val blockIndex: Int, val isEditable: Boolean) {
    var currentValue = value



}