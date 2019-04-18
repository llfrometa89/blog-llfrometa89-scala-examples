package com.llfrometa.patern_matching

import scala.util.{Random, Try}

object PlayingWithPatternMatching extends App {

  val ZERO = "zero"
  val ONE  = "one"
  val TWO  = "two"
  val MANY = "many"

  val number: Int    = Random.nextInt(6)
  val numberAsString = numberAsLiteralString(number)
  val numberByString = matchingNumberByString(number.toString)

  println(s"==>  numberAsLiteralString: $numberAsString")
  println(s"==> matchingNumberByString: $numberByString")

  def numberAsLiteralString(value: Int): String = value match {
    case 0 => ZERO
    case 1 => ONE
    case 2 => TWO
    case _ => MANY
  }

  def matchingNumberByString(value: String): Int = value match {
    case ZERO   => 0
    case ONE    => 1
    case TWO    => 2
    case Int(i) => i
    case _      => throw new RuntimeException()
  }

  val value: Int = 2
  val result: String = value match {
    case 2 => "two"
    case 3 => "three"
  }

  val result2: String = value match {
    case _ => "any"
  }

  val result3: String = value match {
    case foo => s"My value is $foo"
  }

  trait Person {
    val name: String
    val age: Int
  }

  case class Student(name: String, age: Int, averageScore: Double) extends Person

  case class Teacher(name: String, age: Int, totalOfClasses: Int) extends Person

  val person: Person = Student("Martin", 17, 4.75)
  val result4: String = person match {
    case Student(name, _, averageScore) => s"The student $name has a average score $averageScore"
    case Teacher("John", age, _)        => s"The teacher John has $age years old"
  }

  val valueAny: Any = "2"
  val result5: String = valueAny match {
    case v: Int    => s"The value $v is a Int"
    case v: String => s"The value $v is a String"
  }

  val sequence: Iterable[Int] = List(1, 2, 3, 4)
  val result6: String = sequence match {
    case List(0, _, _)      => "A three element list with 0 as the first element"
    case list @ List(1, _*) => s"A list beginning with 1, having any number of elements [$list]"
    case Vector(1, _*)      => "A vector beginning with 1 and having any number …"
  }

  val tuple: Any = (1, 2)
  val result7: String = tuple match {
    case (a, b)       => s"A 2 elem tuple, with values $a, and $b"
    case (a, b, c)    => s"A 3 elem tuple, with values $a, $b, and $c"
    case (a, b, c, _) => s"A 4 elem tuple: got $a, $b, $c and more element"
  }

  println(
    s"==> (result, result2, result3, result4, result5, result6, result7) = ($result, $result2, $result3, $result4, $result5, $result6, $result7)")

  object Int {
    def unapply(arg: String): Option[Int] = Try(arg.toInt).toOption
  }

}
