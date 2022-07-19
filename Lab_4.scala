/**
Write a Scala code to print Fibonacci series till n input. The code should be using
recursion.
*/
object question_1 {
  def fib(input : Int): Int= {
    if(input <= 0)
      return 0
    if(input== 1 || input== 2)
      return 1
    return fib(input-2) + fib(input-1);
  }

  def result(num: Int)={
    var i: Int= 0
    for(i <- 1 to num)
      print(fib(i)+" ")
  }

  def main(args: Array[String])={
    result(9)
  }
}
/**
Write a Scala program to print factorial from 1 to 20 using recursion.
*/
object question_2 {
  def factorial_num(input: Int): BigInt ={
    if (input <= 1)
      return 1
    return input* factorial_num(input -1)
  }

  def result(number: Int)={
    var i: Int=0
    for(i <- 0 to number)
      println(factorial_num(i))
  }

  def main(args: Array[String])={
    result(20)
  }
}
/**
Write a Scala code for merge sort and print the output list.
*/
object question_3 {
  def mergeSort(ls: List[Int]): List[Int] = {
    def merge(l: List[Int], r: List[Int]): List[Int] = (l, r) match {
      case (Nil, _) => r
      case (_, Nil) => l
      case (lHead :: lTail, rHead :: rTail) =>
        if (lHead < rHead)
          lHead :: merge(lTail, r)
        else
          rHead :: merge(l, rTail)
    }
    val n = ls.length / 2
    if (n == 0)
      ls
    else {
      val (a, b) = ls splitAt n
      merge(mergeSort(a), mergeSort(b))
    }
  }
  def main(args: Array[String])={
    println(mergeSort(List(1,2,44,5,-1)))
  }
}
