//I copy this code from Github, I think this code is really interesting, the man who write this code is really smart.
//I also get a lot of inspiration from this code.
object question_3 {

  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  def result(input: Int) {
    println("Pascal's Triangle")
    for (row <- 0 to input-1) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  def main(args: Array[String])={
    result(4)
  }
}
