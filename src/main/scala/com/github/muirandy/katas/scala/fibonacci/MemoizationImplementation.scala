package com.github.muirandy.katas.scala.fibonacci

class MemoizationImplementation {

  def calculateNthSequence(i: Int): BigInt = i match {
    case 0 => return BigInt(0)
    case 1 => return BigInt(1)
    case _ => return calc(i)
  }

  def calc(i: Int): BigInt = {
    return BigInt(1)
  }
}