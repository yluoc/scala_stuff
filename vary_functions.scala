package lec_06022022.functions


  object sort {
    def main(args: Array[String]): Unit = {

      
//Call a function on each elements of a List
//• Only use for the side-effects
//• Ie. Not too useful when embracing immutability (no var)
      val words: List[String] = List("zero", "one", "two", "three")
      words.foreach(println)
      
      val filteredWords: List[String] = words.filter(_.length > 3)
      filteredWords.foreach(println)

      // map
      /**
      Takes a function of the data type of the List and returns
another data type
• Returns a new List containing the return values of the
function with each element as an input
The map method takes 2 type parameters
• We can provide a function that "maps" the elements to a
different type
• The types can be inferred by the the types of the provided
function
*/
//      val numbers: List[Double] = List(1.0, 2.0, 3.0, 4.0, 5.0)
//      val numbersSquared: List[Double] = numbers.map(Math.pow(_, 2.0))
//      numbersSquared.foreach(println)
//
//      val words: List[String] = List("zero", "one", "two", "three")
//      val wordLengths: List[Int] = words.map(_.length)
//      wordLengths.foreach(println)


      // yield
      /**
      As alternate syntax to map, we can use the yield keyword
• Add the keyword yield before the body of a loop
• The last expression of the loop body will be "collected" at
each iteration
Using yield will create a data structure of the same type as the one
being iterated over
• It's not always possible to match the type exactly
• Scala will default to a certain data structure
• Use toList to convert the default type to a List
      */
//      val numbers: List[Double] = List(1.0, 2.0, 3.0, 4.0, 5.0)
//      val numbersSquared: List[Double] = for(number <- numbers) yield {
//        Math.pow(number, 2.0)
//      }
//      numbersSquared.foreach(println)


      val numbersSquared: List[Double] = (for(number <- 1 to 5) yield {
        Math.pow(number, 2.0)
      }).toList
      numbersSquared.foreach(println)


//      val numbers: List[Double] = List(1.0, 2.0, 3.0, 4.0, 5.0)
//      val sumSquares: (Double, Double) => Double = (acc: Double, b: Double) => acc + Math.pow(b, 2.0)
//      val sumOfSquares: Double = numbers.reduce(sumSquares)
//      println(sumOfSquares)
//
      /**
      Takes a function that combines two values of the data type into a single value of that
type
• Calls this function on all elements
• Combines the data into a single value
• The first parameter of the function is the accumulator
• Stores the total value accumulated so far
• Initialized as the first element (Note: This example breaks if 1.0 is not the first element
We can use the _ shorthand with two parameters
• The order of appearance of the _'s is the parameter order
• Cannot use _ shorthand if you need to use an input twice
      */
      val numbers1: List[Double] = List(1.0, 2.0, 3.0, 4.0, 5.0)
      val sumOfSquares1: Double = numbers1.reduce(_ + Math.pow(_, 2.0))
      println(sumOfSquares1)

// fold
      /**
      Similar to reduce
• Use fold if you need to initialize your accumulator
• Use fold if your list might be empty (Return value is the
initialized value)
• Reduce will throw an error if the input list is empty
To accumulate to a type different than the data type
• Use the left/right version of fold (or reduce)
• Initial value and function return type determine the
accumulator type
Using fold/reduce defaults to foldLeft/reduceLeft
• Start with the first (left-most) element
• To accumulate from the end of the List use foldRight/reduceRight
• Must reverse the parameter order when using foldRight/reduceRight
• Accumulator is second parameter, data is first element
      */
//      val numbers: List[Double] = List(2.0, 2.0, 3.0, 4.0, 5.0)
//      val mult: Double = numbers.fold(2.0)(_ * _)
//      println(mult)
//
//      val words: List[String] = List("zero", "one", "two", "three")
//      val totalLength: Int = words.foldLeft(0)(_ + _.length)
//      val totalLength2: Int = words.foldRight(0)(_.length + _)
//      println(totalLength)
//      println(totalLength2)

      val numbers: List[String] = List("zero", "one", "one", "three")
      val distinctElements: List[String] = numbers.distinct
      println(distinctElements)
    }
}
