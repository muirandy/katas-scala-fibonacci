package com.github.muirandy.katas.scala.fibonacci

import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.prop.TableDrivenPropertyChecks._

class FibSpec extends FlatSpec with Matchers {

  val pairs =
    Table(
      ("n", "f"),
      (0, 0),
      (1, 1),
      (2, 1),
      (3, 2),
      (4, 3),
      (5, 5),
      (6, 8)
    )

  it should "work" in {
    val fib = new Fib()

    forAll(pairs) { (n: Int, f: Int) =>
      fib.calculateNthSequence(n) should equal(f)
    }
  }
}