//equivalent to singleton , cannot inject constructor arguments
//object keyword crea la clase y al  mismo tiempo la instancia
object Authenticate {

    fun authenticate (name: String, password:String){
        println("Authenticating with singleton $name $password")
    }
}

fun main() {
    Authenticate.authenticate("test", "test")
}