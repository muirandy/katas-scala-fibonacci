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

    for (index <- 2 to i) {
      allPairs = calculateNextPair(allPairs) :: allPairs
    }

    return allPairs.head._2
  }

  def calculateNextPair(allPairs: List[(Long, Long)]): (Long, Long) = {
    val left = allPairs.head._1 + 1
    val right = allPairs(0)._2 + allPairs(1)._2
    return (left, right)
  }
}