package com.github.muirandy.katas.scala.fibonacci

import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

class FibSpec extends FlatSpec with Matchers {

  val easyPairs =
    Table(
      ("n", "f"),
      (0, 0L),
      (1, 1L),
      (2, 1L),
//      (3, 2L),
//      (4, 3L),
//      (5, 5L),
//      (6, 8L),
//      (20, 6765L),
//      (25, 75025L)
    )

  val bigPairs =
    Table(
      ("n", "f"),
      (50, 12586269025L)
    )

  it should "inefficient implementation should work" in {
    forAll(easyPairs) { (n: Int, f: Long) =>
      new SimpleButInefficient().calculateNthSequence(n) should equal(f)
    }
  }

  it should "work for efficient implementations" in {
    val implementation = new Efficient()
      forAll(easyPairs) { (n: Int, f: Long) =>
        implementation.calculateNthSequence(n) should equal(f)
      }
  }
}