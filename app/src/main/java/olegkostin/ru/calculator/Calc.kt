package calc

import java.lang.IllegalArgumentException
import java.lang.StringBuilder
import java.util.*


// фибоначчи
// 1
// 1
// 2
// 3
// 5
fun fib(number : Int) : Int
{
    var ret = 1
    var prev = 1
    var counter = 0
    while(counter++ < number)
    {
        var temp = ret;
        ret += prev
        prev = temp
    }
    return ret
}




// fun List<Int>.sum(): Int = TODO()
// переделать в функцию-расширение для List<Int>



fun List<Int>.sum(): Int
{
    var ret = 0;
    for(i in this)
    {
        ret +=i
    }
    return ret
}

// начинаются с буквы или цифры
// содержать буквы цифры и _
// длина больше 4 символов
fun isValidId(string: String) : Boolean
{
    return string.matches("""[a-zA-Z0-9]\w{4,}""".toRegex())
}

// Goat
// Cow
// Dog
// say
interface Animal
{
    fun say()
}

class Goat : Animal {
    override fun say() = println("Beeee!")
}

class Cow : Animal {
    override fun say() = println("Muuu!")
}

class Dog : Animal {
    override fun say() = println("Bark!")
}


sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()
class Mul(val left: Expr, val right: Expr) : Expr()

fun eval( e: Expr ) : Int {
    return when(e)
    {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        is Mul -> eval(e.left) * eval(e.right)
        //else -> throw IllegalArgumentException("Unknown expression")
    }
}

fun Any.print() : String = when (this) {
    is Int -> "Int: ${this.toString()}"
    is String -> "String: ${this.toString()}"
    else -> "Don't know: ${this.toString()}"
}

fun StringBuilder.lastCharOf() : Char = get(length -1)

var StringBuilder.lastCharOf : Char
    get() = get(length - 1)
    set(value) = setCharAt(length -1 , value)


fun main()
{
    var b = StringBuilder("hello")
    b.lastCharOf = '!'

    println(b)


//    println(
//        eval (
//            Sum (
//                Num (2),
//                Mul(
//                    Num(5),
//                    Num(6)
//                )
//            )
//        )
//    )


//    val farm = listOf<Animal>(Dog(), Cow(), Goat(), Goat())
//    for(animal in farm)
//    {
//        animal.say()
//    }

//    println(isValidId("test1")) // true
//    println(isValidId("")) // false
//    println(isValidId("13")) // false
//    println(isValidId("abc 123")) // false
//    println(isValidId("_abcde")) // false

//    println(listOf(1, 2, 3).sum())
//    println(fib(10))
//    println("123".print())
//    println(123.print())
//    println(12.2f.print())

    val hex = 0x22


    val long : Long = 212
    val int : Int = long.toInt()
    val int1 : Int = "123".toInt()
}
