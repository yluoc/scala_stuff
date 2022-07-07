//this file is also an example I copy from my class.
//Multilevel Inheritance

class Parents
{
  var Name: String = "Aditya"
}
class ChildNo1 extends Parents
{
  var Age: Int = 24
  def details() {
    println("Name: " + Name)
    println("Age: " + Age)
  }
}
class ChildNo2 extends ChildNo1
{
  var Marks: Int = 96
  def detail(){
    println("Name: " +Name)
    println("Age: " +Age)
    println("Marks: " +Marks)
  }
}
object obj2{
  def main(args: Array[String])
  {
    var obj= new ChildNo2()
    obj.detail()

    var obj1= new ChildNo1()
    obj1.details()
  }
}

class A {
  var numA: Int = 0;

  def setA(n: Int) {
    numA = n;
  }
  def printA() {
    printf("numA: %d\n", numA);
  }
}

class B extends A {
  var numB: Int = 0;

  def setB(n: Int) {
    numB = n;
  }
  def printB() {
    printf("numB: %d\n", numB);
  }
}

class C extends B {
  var numC: Int = 0;

  def setC(n: Int) {
    numC = n;
  }
  def printC() {
    printf("numC: %d\n", numC);
  }
}

class D extends A {
  var numD: Int = 0;

  def setD(n: Int) {
    numD = n;
  }
  def printD() {
    printf("numD: %d\n", numD);
  }
}

object obj5 {
  def main(args: Array[String]) {
    var obj1 = new C();
    var obj2 = new D();

    obj1.setA(10);
    obj1.setB(20);
    obj1.setC(30);

    obj1.printA();
    obj1.printB();
    obj1.printC();

    obj2.setA(40);
    obj2.setD(50);

    obj2.printA();
    obj2.printD();
  }
}

//Single Inheritance
class c1{
   var SSN:String="999-32-7869"
   }

class Student extends c1{
   var enrolment_no:String="0812CS141028"
   println("SSN: "+SSN)
   println("Enrolment Number: "+enrolment_no)
   }

object l1 {
  def main(args: Array[String]): Unit = {
    var s1=new Student()
    println(s1)
  }
}

class Parent
{
  var ParentName: String = "Rahul"
}

class Child extends Parent
{
  var Age: Int = 24
  def details()
  {
    println("ParentName: " +ParentName)
    println("Age: " +Age);
  }
}

object obj1
{
  def main(args: Array[String])
  {
    var obj = new Child()
    obj.details()
  }
}

//Polymorphism
class exmp
{
  def func(vehicle:String, category:String)
  {
    println("The Vehicle is:" + vehicle);
    println("The Vehicle category is:" + category);
  }
  def func(name:String, Marks:Int)
  {
    println("Student Name is:" + name);
    println("Marks obtained are:" + Marks);
  }
  def func(a:Int, b:Int)
  {
    var Sum = a + b;
    println("Sum is:" + Sum)
  }
}
object obj6
{
  def main(args: Array[String])
  {
    var A = new exmp();
    A.func("swift", "hatchback");
    A.func("honda-city", "sedan");
    A.func("Ashok", 95);
    A.func(10, 20);
  }
}

//Hierarchical Inheritance
class Par1
{
  var Name1: String = "Rahul"
  var Name2: String = "Shreya"
}
class Child1 extends Par1
{
  var Age: Int = 24
  def details1()
  {
    println(" Name: " +Name1)
    println(" Age: " +Age)
  }
}
class Child2 extends Par1
{
  var Weight: Int = 70

  def details2()
  {
    println(" Name: " +Name2);
    println(" Weight: " +Weight);
  }
}

object obj3{
  def main(args: Array[String])
  {
    val object1 = new Child1()
    val object2 = new Child2()
    object1.details1()
    object2.details2()
  }
}

//HYBRID INHERITANCE
//if the class contains "trait", which si hybrid inheritance
trait Ram {
  def method1()
}
trait Shyam{
  def method2()
}
class pr1 extends Ram with Shyam{

  def method1()
  {
    println("Ram")
  }

  def method2()
  {
    println("Shyam")
  }
}
object obj4{
  def main(args: Array[String])
  {
    var obj = new pr1()
    obj.method1()
    obj.method2()
  }
}
