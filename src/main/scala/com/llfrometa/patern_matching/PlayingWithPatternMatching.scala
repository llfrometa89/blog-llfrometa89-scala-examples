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

  object Int {
    def unapply(arg: String): Option[Int] = Try(arg.toInt).toOption
  }

}
