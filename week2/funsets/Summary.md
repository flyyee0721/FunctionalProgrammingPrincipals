# <a> Week Two Notes </a>


###2.1 Higher-order Functions, 
* Definition: Functions that take other functions as parameters or that return functions as results.
* First order function acts on simple data types such as int, long and string.
* Functions are treated as first class values in scala.
* Any functions can be passed as a parameter and return a value.
* What is Function Type? 
  1. Like other data types, function type A => B is to denote the type of a function by its input and output data type.
  2. Function type A=>B takes type A and return type B.
* Example as below:
  1. We have three functions sumCube, sumInts and sumFactorial that sum up values f(x) for x in the range [a, b]
```scala
def sumCube(a: Int, b:Int): Int = 
    if (a > b) 0 else cube(a) + sumCube(a+1, b)

def sumInts(a: Int, b:Int): Int = 
    if (a > b) 0 else a + sumInts(a + 1, b)
    
def sumFactorial(a: Int, b:Int): Int = 
    if (a > b) 0 else fact(a) + sumFactorial(a + 1, b)
    
def cube(x:Int): Int = x * x * x
def fact(x:Int): Int = if (x == 0) 1 else x * fact(x - 1)
```
  2. we can factor out the common pattern into a single method and pass it as a parameter.
```scala
def sum(f:Int => Int, a: Int, b: Int): Int = 
    if (a > b) 0 else f(a) + sum(f, a + 1, b)
    
def sumCube(a:Int, b:Int): Int = sum(cube, a, b)
def sumFactorial(a:Int, b:Int): Int = sum(fact, a, b)
```
  3. Passing functions to high order functions causes the creation of many small functions, such as the cube and fact function.
* **Anonymous Function Syntax**, A.K.A literal function, a function without a given name.
* 
* 
* 
