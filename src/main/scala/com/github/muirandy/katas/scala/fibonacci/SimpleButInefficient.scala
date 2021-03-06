package com.github.muirandy.katas.scala.fibonacci

class SimpleButInefficient()  {
  def calculateNthSequence(i: Int): Long = i match {
    case 0 => return 0
    case 1 => return 1
    case _ => return calculateNthSequence(i-1) + calculateNthSequence(i-2)
  }
}
