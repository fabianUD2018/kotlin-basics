const val DEFAULT_GREETER = "Staan lee"
val DEFAULT_HEROS : List<String> = listOf("Spiderman", "Wolverine", "IronMan", "Thor", "Hulk")

fun greet(from: String= "Batman", to:String="Robin" ): String {
    return "hello i am $from, is a pleasure to meet you $to "
}

fun greeter(from: String= "Batman", to:List<String> = DEFAULT_HEROS): String {
    val builder : StringBuilder = StringBuilder()
    builder.append("hello i am $from, is a pleasure to meet you ")
    to.forEach { builder.append("Mr $it ") }
    return builder.toString()
}