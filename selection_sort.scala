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

//the following code is OOP code example, it may looks complex but which is helpful to learn OOP.

package lec_06022022.sort

/*
  Scala program for selection sort
*/
class MySort()
{
  // Swap the array element
  def swap(arr: Array[Int], x: Int, y: Int): Unit = {
    // x and y are index of array
    var temp: Int = arr(x);
    arr(x) = arr(y);
    arr(y) = temp;
  }
  def selectionSort(arr: Array[Int], n: Int): Unit = {
    var min: Int = 0;
    var i: Int = 0;
    // Execute loop from 0..n
    while (i < n)
    {
      // Get current index
      min = i;
      var j: Int = i + 1;
      while (j < n)
      {
        if (arr(min) > arr(j))
        {
          // Get the minimum element index
          min = j;  // 5=> 0 , -23 =>1
        }
        j += 1;
      }
      if (i != min)
      {
        // Swap minimum element at i index
        swap(arr, i, min);
      }
      i += 1;
    }
  }
  // Display array elements
  def display(arr: Array[Int], n: Int): Unit = {
    var i: Int = 0;
    while (i < n)
    {
      // Display element value
      print(" "+arr(i));
      i += 1;
    }
    print("\n");
  }
}
object Main
{
  def main(args: Array[String]): Unit = {
    var task: MySort = new MySort();
    // Array of integer elements
    var arr: Array[Int] = Array(
      8, 2, 3, 8, 1, 3, 73, 121, 54, 23, 84, 13, 67, 23, 52);
    // Get the size of array
    var n: Int = arr.length;
    println(" Before Sort :");
    task.display(arr, n);
    // Test
    task.selectionSort(arr, n);
    println(" After Sort :");
    task.display(arr, n);
  }
}
