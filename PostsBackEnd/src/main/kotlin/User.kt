import java.util.*

open class User(var name: String) {//primary constructor

    private val useUppercaseInTheFirstLetter = {
            firstLetter : Char-> firstLetter.uppercase()
    }

    open var isSuperUser: Boolean = false //variable sobreescribible

    //los modificadores de acceso soin basicamente lois mismos que en jaava
    //public protected private, internal->utl para librerias
    var nickName: String = ""
        get() = field //custom getter
        set(value) { //custom setter
            field = value.replaceFirstChar(useUppercaseInTheFirstLetter)

            //field = value.replaceFirstChar( firstChar : Char -> firstChar)
        }
    //secundary constructor
    constructor(name: String = "NN", nickName: String) : this(name) {
        this.nickName = nickName
    }

    //correr codigo de inicializacion durante la creacion de la instancia
    init {
        println("Executing super class init method")
    }

    //open significa que la funcuin se puede extender
    open fun login() {//funcion sobreescribible
        println("Hello i am mr $name")
    }


    //definir cosas estaticas de una clase, equivalente a static en java
    companion object {
        const val STATIC_STUDENT_ID: String = "Student a"

        fun staticDepartment() {
            println("Enginering")
        }
    }
}

fun main() {
    val mainConstructor = User("juanito")
    mainConstructor.nickName="juancho"
    println("the main is ${mainConstructor.name} and the nickname is ${mainConstructor.nickName}")

    val secundaryConstructor = User(nickName = "chiquito malo")

    println("The secundary constructor is ${secundaryConstructor.nickName} and its name is ${secundaryConstructor.name}")
}