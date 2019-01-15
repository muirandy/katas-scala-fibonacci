package com.github.muirandy.katas.scala.fibonacci

class Efficient {

  def calculateNthSequence(i: Int): Long = i match {
    case 0 => return 0
    case 1 => return 1
    case _ => return calc(i)
  }

  def calc(i: Int): Long = {
    var allPairs = List[(Long,Long)]()
    allPairs = (0L, 1L) :: (0L, 0L) :: allPairs

    return addTuple(allPairs.head)
  }

  def addTuple(pair: (Long, Long)): Long = {
    return pair._1 + pair._2
  }
}