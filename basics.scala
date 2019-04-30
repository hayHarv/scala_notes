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


/**Functions (also called methods...?)
 * 
 * use def keyword
 * 
 * Differences from python:
 * - Return statement is implied
 * - Types are required
 * 
 * def fn_name(arg: Type): ReturnType = {
 *  do_stuff
 * }
 * 
 **/
 
def dubble(x: Int): Int = {
  x*2
}

// prints 8
println(dubble(4))

/**aside: interesting print behavior
 * println on an empty string doesn't advance the line
 * 
 **/
 
// doesn't advance
println("")

// does advance
println(" ")



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
 println(" ")
 
 // Wildcard syntax
 
val wild_anon = (_:Int)+(_:Int)
println("wild_anon result: " + wild_anon(1,2))
println(" ")

/** Partial application
* Uses "_" wildcard character
* 
* partial f(x,y):
* f(1, _) 
* f(2)
**/


def greet(salutation: String, name: String) = {
  println(salutation + ", " + name)
}

val part_salutation = greet(_:String, "Buddy")

val part_name = greet("Hello", _:String)

// More on collections later, but Lists are immutable in Scala
val salutations: List[String] = List("Bonjour", "Hola", "Hello")

val names: List[String] = List("Annie", "Vidya", "Mitch")

names.foreach(part_name(_))
println(" ")

salutations.foreach(part_salutation(_))
println(" ")

/**Variable Length Arguments
 * 
 * We can specify a function to act on arbitrary numbers of arguments of the same type
 * 
 * Syntax: add a * after type annotation and .map{} to apply the function
 * 
 * Like Python's *args
 **/
 
 def allcapsAll(args: String*) = {
   args.map { 
     arg => arg.toUpperCase
   }
 }
 
 // we can unpack a collection with the following syntax
 val unpack_list = allcapsAll(names: _*)
 println(unpack_list)
 println(" ")
 
 // This gives a WrappedArray and I'll need to figure wut that is
 val varargs = allcapsAll("words","lots","of","words")
 println(varargs)
 println(" ")
 

/** Currying arguments
* For when u want to apply arguments to a function step-by-step
* 
* curried f(x,y) allows f(1) f(2) to be applied on different lines
*   and be evaluated same as f(1,2)
**/


def lame_adder(x: Int, y: Int) = x + y

val curriedAdd = (lame_adder _).curried

val addTwo = curriedAdd(2)

println(addTwo(3))
println(" ")

// Variable 


/** Classes
 * 
 * Worth noting:
 * Methods are the same as you'd see in Python
 * 
 * Class construtors are just any code that's 
 * outside of a method definition
 * 
 * Classes are instantiated with the "new" keyword
 **/
 
 class Pet(name: String) {
   /**Just a lil pet
    * name: name of pet
    **/
    
    // here's a constructor
    def poop = println(name + " just pooped")
 }
 
 val skippy = new Pet("Skippy")
 skippy.poop
 println(" ")
 
 /** Class inheritance
  * uses "extends" keyword
  **/
  
class Dog(breed: String, name: String) extends Pet(name) {
  
  def speak = println("woof!")
  
  def admire = println("My, what a beautiful " + breed)
}

val lassie = new Dog(breed="Rough Collie", name="Lassie")

lassie.speak
println(" ")
lassie.admire
println(" ")
lassie.poop
println(" ")
 

