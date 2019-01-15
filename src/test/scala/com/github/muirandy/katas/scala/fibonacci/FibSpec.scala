package com.github.muirandy.katas.scala.fibonacci

import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

class FibSpec extends FlatSpec with Matchers {

  val easyPairs =
    Table(
      ("n", "f"),
      (0, BigInt(0)),
      (1, BigInt(1)),
      (2, BigInt(1)),
      (3, BigInt(2)),
      (4, BigInt(3)),
      (5, BigInt(5)),
      (6, BigInt(8)),
      (20, BigInt(6765)),
      (25, BigInt(75025))
    )

  val bigPairs =
    Table(
      ("n", "f"),
      (50, BigInt("12586269025"))
    )

  it should "inefficient implementation should work" in {
    forAll(easyPairs) { (n: Int, f: BigInt) =>
      new SimpleButInefficient().calculateNthSequence(n) should equal(f)
    }
  }

  it should "work for efficient implementations" in {
    val implementation = new Efficient()
      forAll(easyPairs) { (n: Int, f: BigInt) =>
        implementation.calculateNthSequence(n) should equal(f)
      }
      forAll(bigPairs) { (n: Int, f: BigInt) =>
        implementation.calculateNthSequence(n) should equal(f)
      }
  }
}