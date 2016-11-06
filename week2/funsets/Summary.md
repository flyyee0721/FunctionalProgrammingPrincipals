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
  2. We can factor out the common pattern into a single method and pass it as a parameter.
  3. Passing functions to high order functions causes the creation of many small functions, such as the cube and fact function.
```scala
def sumCube(a: Int, b:Int): Int = 
    if (a > b) 0 else cube(a) + sumCube(a+1, b)

def sumInts(a: Int, b:Int): Int = 
    if (a > b) 0 else a + sumInts(a + 1, b)
    
def sumFactorial(a: Int, b:Int): Int = 
    if (a > b) 0 else fact(a) + sumFactorial(a + 1, b)
    
def cube(x:Int): Int = x * x * x

def fact(x:Int): Int = if (x == 0) 1 else x * fact(x - 1)

def sum(f:Int => Int, a: Int, b: Int): Int = 
    if (a > b) 0 else f(a) + sum(f, a + 1, b)
    
def newSumCube(a:Int, b:Int): Int = sum(cube, a, b)

def newSumFactorial(a:Int, b:Int): Int = sum(fact, a, b)
```
* **Anonymous Function Syntax**, A.K.A literal function, a function without a given name.
  1. (x: Int) => x * x * x is the anonymous function of sumCube, **(Input parameters separated by comma) => function body** 
  2. The input parameter type can be omitted if the compiler can infer it from the context. 
  3. Anonymous function can take multiple parameters such as (a:Int, b:Int) => a + b
  4. _Anonymous function is syntax sugar but not essential in scala._
```scala
def sumInts(a: Int, b:Int) = sum((x:Int) => x, a, b)
def sumCube(a: Int, b:Int) = sum(x => x * x * x, a, b)
```
* Linear recursion vs tail-recursion 
  1. Sum function in the form of linear recursion takes up O(n) stack space because the after executing the function sum(f)(a + 1, b), the code need to return back to sum(f)(a, b), thus the stack space of  sum(f)(a, b) call cannot be released until the recursive calls are done
```scala
def sum(f: Int => Int)(a:Int, b:Int): Int => {
  if (a > b) 0 else f(a) + sum(f)(a + 1, b)
```
  1. Tail recursion takes O(1) stack space in scala because the compiler is able to translate it into iteration.
