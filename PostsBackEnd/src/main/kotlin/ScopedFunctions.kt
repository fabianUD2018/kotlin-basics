class ScopedFunctions {

    companion object {
    //un caso de uso seria una clase que esta inicializandose se puede usar apply para configurar el objeto
    fun exploreApply () {
        var user = User(nickName = "matamba").apply { this.name = "Something" }
        println(user)
    }

        //se recomienda el uso para funcionalidades de side effect que necesita ser ejecutado despues de que un objeto es creado
        fun exploreAlso() {
            var user = User(nickName = "matamba").also { it.name = "Something" }
            println(user)
        }

        //let no devuelve el objeto sobre el que se aplica, retorna el resultado de la funcion lambda
        fun exploreLet(): String{
            return User(nickName = "sayayin").let { it.nickName.uppercase() }
        }
        //para llamar funciones en el context object como tal
        fun exploreWith(){
            var list = mutableListOf(1,2,3,4,5)
            var result = with(list){
                list.sum()
                sum()//no necesuta usar list
                plus(44)
            }
            println(result)
        }
    }
}

fun main () {
    var name = "juanito"

    //funciones que se ejecutan en el ambito de variables
    //run se puede usar oara inicializar alg y adicionalmente retornar un calculo
    name.run {
        println(this)
    }
ScopedFunctions.exploreApply()
    ScopedFunctions.exploreAlso()
    println( ScopedFunctions.exploreLet())
}