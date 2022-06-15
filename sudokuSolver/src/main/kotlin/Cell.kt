class Cell(val value: String) {
    var currentValue = value
    var isChangeable: Boolean = true
        private set(value){
            field = value
        }



    init {
        // if value equals '-' set isChangeable to false
        if(value != "-"){
            isChangeable = false
        }
    }
}