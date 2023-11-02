import java.util.UUID

fun main(args: Array<String>) {
    println("Hello World!")
    println (greet("Superman", "Lex luthor"))
    println(greet())
    println(greet(to="Spiderman", from ="Mr oscorp"))
    println(greet(to=DEFAULT_GREETER, from ="Mr oscorp"))
    println(greeter( from ="Mr oscorp"))

    val missclick  = CreateUserInput(UUID.randomUUID().toString(), "missclick", "fabian@gmail.com", "1234")
    val missclickCopy = missclick.copy(userId = UUID.randomUUID().toString())
    println(missclick)
    println(missclickCopy)
}