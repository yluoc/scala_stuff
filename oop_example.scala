//Write a Scala program and use an abstract class to define a student that is required to have a name of type String,
//and an age of type Int. Each Student type should also have a printName() method with Unit as the return type. 
//Thereafter create two sub classes of the Student class, namely, a PrimaryStudent, and a SecondaryStudent. 
//  Each sub class should provide its own implementation of the printName() method. 
//You should also define the respective companion objects for the PrimaryStudent and the SecondaryStudent types. 
//Next, create the following students:
//  - John who is a primary student and is 8 years old.
//  - Jill who is a primary student and is 10 years old.
//  - James who is a secondary student and is 13 years old.
//  - Joe who is a secondary student and is 14 years old.
//  - Jack who is a secondary student and is 11 years old.
//  Next, use an appropriate data structure to store the above-mentioned students. And, 
//create a method name listStudents that will have input your collection of students and call the printName() name for each one.
abstract class Student(name: String, age: Int) {
  def printName(): Unit
}
class PrimaryStudent(name: String, age: Int) extends Student(name, age) {
  override def printName(): Unit = println(s"name = $name, age = $age")
}
object PrimaryStudent {
  def apply(name: String, age: Int): PrimaryStudent = new PrimaryStudent(name, age)
}
class SecondaryStudent(name: String, age: Int) extends Student(name, age) {
  override def printName(): Unit = println(s"name = $name, age = $age")
}
object SecondaryStudent {
  def apply(name: String, age: Int): SecondaryStudent = new SecondaryStudent(name, age)
}
object Test_class_one {
  def main(arg: Array[String]): Unit = {
    val pStudentJohn = PrimaryStudent("John", 8)
    val pStudentJill = PrimaryStudent("Jill", 10)
    val sStudentJames = SecondaryStudent("James", 13)
    val sStudentJoe = SecondaryStudent("Joe", 14)
    val sStudentJack = SecondaryStudent("Jack", 11)
    val students = List(pStudentJill, pStudentJohn, sStudentJack, sStudentJames, sStudentJoe)
    def listStudents(students: List[Student]): Unit = {
      students.foreach(student => student.printName())
    }
    listStudents(students)
  }
}

//Write a Scala program and use a trait to define a Vehicle type with an abstract method named printName() that has no return type.
//Using this new Vehicle type, create a new class named Car with a name property of type String that is a sub-class of
//the former Vehicle type. Likewise, use this new Car type to create two subsequent classes, namely, a BmwCar,
//and a MazdaCar class. In addition, create a new type named Bike with a name property of type String that is a sub-class of the
//Vehicle trait. Using this new Bike class, create two further sub-classes, namely, a HondaBike, and a BmwBike, class.
//Next, create a class named VehicleMaker which has a type parameter V that acts as a constraint to the Vehicle type, and therefore,
//also has a vehicle of type V as its constructor argument. The VehicleMaker class should have a make() method with a
//generic return type V - that is, of course, based from and relative to its class type parameter. In the body of the make() method,
//you can simply access and call the printName() method for a given Vehicle type. With the above defined and in scope,
//use a List data structure to create a "bmw car 5 series" and a "mazda car 3 series". Similarly, create another List
//data structure with a "honda bike firestorm" and a "bmw bike r 2000". Thereafter, merge the two List data structures
//  into a single one and use Scala's built-in map() method to call the VehicleMaker's make() method for each vehicle in the List.
trait Vehicle {
  def printName(): Unit
}
class Car(name: String) extends Vehicle {
  override def printName(): Unit = println(name)
}
class BmwCar(name: String) extends Car(name) {
  override def printName(): Unit = println(name)
}
class MazdaCar(name: String) extends Car(name) {
  override def printName(): Unit = println(name)
}
class Bike(name: String) extends Vehicle{
  override def printName(): Unit = println(name)
}
class HondaBike(name: String) extends Bike(name) {
  override def printName(): Unit = println(name)
}
class BmwBike(name: String) extends Bike(name) {
  override def printName(): Unit = println(name)
}
class VehicleMaker[V <: Vehicle](val vehicle: V) {
  //An upper type bound V <: Vehicle declares that type variable V refers to a subtype of type Vehicle
  // <: "must be a subtype of"
  def make(): V = {
    print("Making vehicle = ")
    vehicle.printName()
    vehicle
  }
}
object prb2 {
  def main(arg: Array[String]): Unit = {
    val carsToMake = List(new BmwCar("bmw car 5 series"), new MazdaCar("mazda car 3 series"))
    val bikesToMake = List(new HondaBike("honda bike firestorm"), new BmwBike("bmw bike r 2000"))
    //    val vehiclesToMake = carsToMake ++ bikesToMake
    val vehiclesToMake = carsToMake ::: bikesToMake
    vehiclesToMake.map { v => new VehicleMaker[Vehicle](v).make() }
    println(vehiclesToMake)
  }
}

//import java.awt.Rectangle
// multiple inheritance
// Interfaces : A set of method or properties that an implementing class must have -> java; python can do multiple inheritance
abstract class Polygon {
  def area: Double
}
//abstract class Shape {
//  def area: Double
//}
trait Shape {  // partially implemented interfaces, may contain abstract or non abstract method, at least one should be abstract method
  def color : String
}
class Rectangle ( var width: Double, var height: Double) extends Polygon with Shape {
  override def area : Double = width * height
//  override def color : String = " Green"
  def color : String = " Green"
}
class Triangle ( var width: Double, var height: Double) extends Polygon with Shape{
  override def area : Double = 0.5 * width * height
//  override def color : String = " Red"
  def color : String = " Red"
}
object  Polygon {
  def main(arg: Array[String]): Unit = {
    var rect = new Rectangle(10.0,20.0)
    println("Area "+ rect.area)
    println("Color "+ rect.color)
    var tri = new Triangle(10.0,20.0)
    println("Area " + tri.area)
    println("Color "+ tri.color)
  }
}

//In Scala, type parameters and abstract type members may be constrained by a type bound. 
//Such type bounds limit the concrete values of the type variables and possibly reveal more information
// about the members of such types.
//  An upper type bound T <: A declares that type variable T refers to a subtype of type A. 
//Here is an example that demonstrates upper type bound for a type parameter of class PetContainer
abstract class Animal {
  def name: String
}
abstract class Pet extends Animal {}
class Cat extends Pet {
  override def name: String = "Cat"
}
class Dog extends Pet {
  override def name: String = "Dog"
}
class Lion extends Animal {
  override def name: String = "Lion"
}
class PetContainer[P <: Pet](p: P) {
  def pet: P = p
}
object  type_param {
  def main(arg: Array[String]): Unit = {
    val dogContainer = new PetContainer[Dog](new Dog)
    val catContainer = new PetContainer[Cat](new Cat)
    // this would not compile
//    val lionContainer = new PetContainer[Lion](new Lion)
  }
}
