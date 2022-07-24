// // No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
	var type: String? = null,
    var info: String? = null
)
// -----------------------

fun main() {
    val result = processList(listOf(25, "Hola", null, false))
    println(result)
}

fun processList(inputList: List<Any?>?): List<ItemData>? {
    var mylist = ArrayList<ItemData>()
    if (inputList == null) return null
    for((pos, item) in inputList.withIndex()){ // El ciclo recorre toda la lista
        if(item != null){ 
            when(item){ // Se analiza el item para las propiedades 'type' e 'info'
                is String -> mylist.add(ItemData(pos, item, "cadena", ("L" + item.length)))
                is Int -> { //Si el item es entero
                    val intinfo:String? = if (item % 10 == 0) "M10" else if (item % 5 == 0) "M5" else if (item % 2 == 0) "M2" else null
                    mylist.add(ItemData(pos, item, "entero", intinfo))
                }
                is Boolean -> mylist.add(ItemData(pos, item, "booleano", if(item) "Verdadero" else "Falso"))
                else -> mylist.add(ItemData(pos, item, null, null)) } } } 
    return mylist }