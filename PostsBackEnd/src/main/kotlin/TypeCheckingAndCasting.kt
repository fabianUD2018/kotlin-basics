class TypeCheckingAndCasrting {

    //hay 2 metodos utiles is as
    // is returna un booleano si es de un tipol
    // as hace el casteo de una
    fun useIsToCast (param: Any) :Any{
        return when(param){
            is String ->{
                //automaticamente hace el casteo a string
                return param.uppercase()
            }
            is User -> {
                println("automatically does the cast to USEr")
                return param
            }
            else -> "invalid data type "
        }
    }

    fun useAsToCast(param:Any) : Any {
        return when (param) {
            param as String ->{
                //automaticamente hace el casteo a string
                return param.uppercase()
            }
            //no lo alcanza por que si no es string genera error
            param as User -> {
                println("automatically does the cast to USEr")
                return param
            }
            else -> "invalid data type "
        }
    }
}

fun main() {
    val test = TypeCheckingAndCasrting()
    val expected =  test.useIsToCast("should be casted to uppercase")
    println(expected)
    val user  = test.useIsToCast(User(nickName = "Jorge 40"))
    println(user)
    val double:Double = 100.0
    val castedDouble = test.useIsToCast(double)
    println(castedDouble)
    println(test.useAsToCast("test"))
    println(test.useAsToCast(user))
}