package com.github.muirandy.katas.scala.fibonacci

class Efficient {

  def calculateNthSequence(i: Int): BigInt = i match {
    case 0 => return BigInt(0)
    case 1 => return BigInt(1)
    case _ => return calc(i)
  }


  def calc(i: Int): BigInt = {
    var allPairs = List[(BigInt,BigInt)]()
    allPairs = (BigInt(0), BigInt(1)) :: (BigInt(0), BigInt(0)) :: allPairs

    for (index <- 2 to i) {
      allPairs = calculateNextPair(allPairs) :: allPairs
    }

    return allPairs.head._2
  }

  def calculateNextPair(allPairs: List[(BigInt, BigInt)]): (BigInt, BigInt) = {
    val left = allPairs.head._1 + 1
    val right = allPairs(0)._2 + allPairs(1)._2
    return (left, right)
  }
}