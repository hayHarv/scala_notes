/** Scala basics
 * 
 * Working through some examples of basic syntax...
 * Good overviews: 
 * https://twitter.github.io/scala_school/basics.html
 * 
 **/

// values (immutable)
val two = 1+1

// variables (mutable)
var three = 2+1



// functions
// use type annotation in arguments
def dubble(x: Int): Int = {
  x*2
}

// prints 8
println(dubble(4))


/** Anonymous functions
 * 
 * There are two ways of doing this:
 * 
 * Transformer Syntax:
 * Using the transformer "=>"
 * 
 * >> (z: Int, y:Int) => z*y
 * 
 * Wildcard Syntax:
 * Using wildcard character "_"
 * (_:Int)*(_:Int)
 * 
 * you can save anonymous functions to val keywords
 * */
 
 // Transformer syntax
 val anon_add = (z: Int, y: Int) => z+y
 println("anon_add result:" + anon_add(1,3))
 
 // Wildcard syntax
 
val wild_anon = (_:Int)+(_:Int)
println("wild_anon result: " + wild_anon(1,2))

// Partial application
// Uses "_" wildcard character
def greet(salutation: String, name: String) = {
  println(salutation + ", " + name)
}

val part_salutation = greet(_:String, "Buddy")

val part_name = greet("Hello", _:String)

// More on collections later, but Lists are immutable in Scala
val salutations: List[String] = List("Bonjour", "Hola", "Hello")

val names: List[String] = List("Annie", "Vidya", "Mitch")

names.foreach(part_name(_))

salutations.foreach(part_salutation(_))
