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
    var orPos: Int
    var orValue: Any
    var type: String?
    var info:String?
    
    var pos: Int = 0
    
    for(item in inputList!!){ // El ciclo recorre toda la lista
        if(item != null){ // En caso de que el item no sea null, se opera
            orPos = pos	// 'pos' es un contador
            orValue = item 
            
            when(item){ // Se analiza el item para las propiedades 'type' e 'info'
                is String -> { //Si el item es String 
                    
                    type = "cadena"
                    val n = item.length
                    info = "L" + n
                }
                
                is Int -> { //Si el item es entero
                    
                    type = "entero"
                    
                    if ((item % 10) == 0)
                    	info = "M10"
                    
                    else if ((item % 5) == 0)
                    	info = "M5"
                    
                    else if ((item % 2) == 0)
                    	info = "M2"
                    
                    else 
                    	info = null
                }
                
                is Boolean -> { // Si el item es boolean
                    
                    type = "booleano"
                    if (item)
                    	info = "verdadero"
                    else 
                    	info = "falso"
                }
                
                else -> { // Si no es ninguno de los tres anteriores
                    type = null
                    info = null
                }
            }
            
            var funres = ItemData(originalPos = orPos, originalValue = orValue, type = type, info = info) // Se inicializa un nuevo itemData
            mylist.add(funres) // Se agrega a la lista
            
        }
        pos++ // Se le suma uno al contador		
    }
    
    return mylist // Se devuelve la lista
	
}