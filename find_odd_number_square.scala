/**
this function is used to make an integer list into a list which only contains odd number without using "for loop" or "if, else"
also, this function is used to get the odd number's square and sum them up, return an integer.
*/
object question_2 {
  def find_odd_square(list: List[Int])={
    val odd_list: List[Int]= list.filter(_ %2 !=0)
    val odd_square: List[Double]= odd_list.map(Math.pow(_, 2))
    val sum_odd: Int= odd_square.sum.toInt
    print(sum_odd)
  }

  def main(args:Array[String])={
    val list1=List(1,2,3,4,5,6,7)
    find_odd_square(list1)
  }
}
