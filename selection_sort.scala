/**
some example code may use class, object to write it, but I just use object because I think this is time-saving. 
However, it's not clear, OOP is always clear to see what is going on.
*/
object question_1 {
  def select_sort (input: Array[Int])={
    println("Given array:\n"+input.mkString(" "))
    for (  i <- 0 to input.length-2) {
      var min =input(i)//first element of input array
      var ind = i//index of first element
      for ( j <- i to input.length-1)
        if (min> input(j)) {
          min = input(j)
          ind = j
        }
      if (input(i) != min) {
        val temp =input(ind)
        input(ind) =input(i)
        input(i) = temp
      }
      println(s"Array after $i iteration:\n"+input.mkString(" "))//this line code is used to print the sorted array after ith iteration 
    }
  }

  def main (args: Array[String])={
    select_sort(Array(32, 4, 5, 3, 7, 16, 5, 25, 10, 17))
  }
}
