package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1)  + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    var stack = new scala.collection.mutable.Stack[Char]
    def balanceHelper(chars: List[Char]): Boolean = {
      if (chars.isEmpty) stack.isEmpty
      else if (chars.head != '(' && chars.head != ')') balanceHelper(chars.tail)
      else if (chars.head == '(') {
        stack.push(chars.head)
        balanceHelper(chars.tail)
      } else !(stack.isEmpty) && stack.pop() == '(' &&  balanceHelper(chars.tail)
    }
    balanceHelper(chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeHelper(money: Int, index: Int): Int = {
      if (money == 0) 1
      else if (index == coins.length) 0
      else {
        var ret = 0
        for (i <- 0 to money/coins(index)) ret += countChangeHelper(money - i * coins(index), index + 1)
        ret
      }
    }
    countChangeHelper(money, 0)
  }
}
