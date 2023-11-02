class HighOrderFunctions {
    companion object {

        fun calculate (numberA: Int, numberB:Int, lambdaFunction : (a:Int,b:Int)->Int) : Int{
            return lambdaFunction(numberA, numberB)
        }
    }




}

fun main (){
    val holdsSum  =  {
        numeroA:Int, numerob:Int -> numeroA+numerob
    }

    println(HighOrderFunctions.calculate(10,10, holdsSum))
    
    println(HighOrderFunctions.calculate(10,10, lambdaFunction = { dividendo:Int, divisor:Int -> dividendo/divisor}))

    //si se tiene la lambda como ultimo parametro se pueden pasar fuera de el parentesis
    println(HighOrderFunctions.calculate(10,10) { base: Int, potencia:Int-> Math.pow(base.toDouble(),
        potencia.toDouble()
    ).toInt()})
}