//Create a circle class with radius as data member.
// Create two constructors (no argument, and two arguments) and a method to calculate Circumference.
// ######################
class circle{
  var radius: Double= 0.0
  val PI= 3.14
  def circumference(rad: Double): Unit ={
    radius= rad
    val pi= PI
    val circum= rad * pi * 2.0
    printf("circumference: %s\n", circum)
  }
}
object make3{
  def main(agrs:Array[String]): Unit={
    val res= new circle()
    res.circumference(1.0)
  }
}

//Write a program by creating an 'Employee' class having the following methods and print the final salary.
// 1 - 'getInfo()' which takes the salary, number of hours of work per day of employee as parameter
// 2   -'AddSal()'   which   adds   $10   to   salary   of   the   employee   if   it   is   less   than   $500.
// 3 - 'AddWork()' which adds $5 to salary of employee if the number of hours of work per day is more than 6 hours.
// ######################
class Employee{
  def getInfo(salary: Int, work_hour: Int){
    val new_salary = AddSal(salary)
    val new_hour = AddWork(salary, work_hour)
    val totalsalary = new_salary + new_hour
    println(totalsalary)
  }
  def AddSal(sal: Int): Int={
    var newsal = sal
    if(newsal < 500) newsal+=10
    newsal
  }
  def AddWork(sal: Int, hour: Int): Int={
    val newhour = hour
    var new_sal = sal
    if(newhour > 6) new_sal= new_sal -100 +5
    new_sal
  }
}
object make2{
  def main(agrs:Array[String]): Unit={
    val res= new Employee()
    res.getInfo(100, 7)
  }
}

// ##############
//Write a Scala Program in which Create a class called 'Matrix' containing constructor that initializes
//  the number of rows and the number of columns of a new Matrix object. The Matrix class has the following information:
//1 - number of rows of matrix
//2 - number of columns of matrix
//3 - elements of matrix (You can use 2D vector)
//The Matrix class has methods for each of the following:
//  1 - get the number of rows
//  2 - get the number of columns
//  3 - set the elements of the matrix at a given position (i,j)
//  4 - adding two matrices.
//  5 - multiplying the two matrices
//    You can assume that the dimensions are correct for the multiplication and addition
// ######################
class Matrix{
  var row: Int= 2
  var column: Int= 2
  var original_matrix1= Array(
    Array(1, 2),
    Array(3, 4),
  );
  /**Since I will update the o_matrix1 by using set_elements function
   * and I don't know (I am lazy) how to make o_matrix1 into the original form,
   * So, I just copy the o_matrix1 and mark it as o_matrix2, which is used to do the addition and multiplication
   * of the new matrix and old matrix
   */
  var original_matrix2= Array(
    Array(1, 2),
    Array(3, 4),
  );

  var add_matrix = Array.ofDim[Int](2, 2)

  var multiply_matrix = Array.ofDim[Int](2,2)

  def row_number:Unit={
    val rownum= row
    println("number of row is: "+rownum)
  }

  def column_number:Unit={
    val columnnum= column
    println("number of column is: "+columnnum)
  }

  def set_elements(Row_coordinates: Int, Column_coordinates: Int, Corresponding_value: Int): Array[Array[Int]]= {
    original_matrix1(Row_coordinates)(Column_coordinates) = Corresponding_value
    println("value at "+"("+Row_coordinates+")"+"("+Column_coordinates+")"+" has been changed to "+Corresponding_value)
    original_matrix1
  }
//a, b, c is used to iterate. sum is used to multiply two matrix
  var a: Int= 0
  var b: Int= 0
  var c: Int= 0
  var sum: Int= 0

  def matrix_add: Unit={
    println("addition of two matrix: ")
    a= 0
    while(a < 2) {
      b= 0
      while(b < 2){
        add_matrix(a)(b)= original_matrix1(a)(b) + original_matrix2(a)(b)
        printf("%d ", add_matrix(a)(b));
        b+=1
      }
      a+=1
    }
    println()
  }

  def matrix_mult: Unit={
    println("multiplication of two matrix: ")
    a= 0
    while(a < 2){
      b= 0
      while(b < 2){
        c= 0
        while(c < 2){
          sum+= original_matrix1(a)(c) * original_matrix2(c)(b)
          c+=1
        }
        multiply_matrix(a)(b)= sum
        b+=1
      }
      a+=1
    }
    /** if the following function isn't exist, the multiplication will be incorrect
     */
    a= 0
    while (a < 2) {
      b= 0
      while (b < 2) {
        printf("%d ", multiply_matrix(a)(b));
        b+=1
      }
      a+= 1
      println();
    }
  }
}

object make1{
  def main(args:Array[String]): Unit={
    val r=new Matrix
    r.row_number
    r.column_number
    r.set_elements(1,1,5)
    r.matrix_add
    r.matrix_mult
  }
}
