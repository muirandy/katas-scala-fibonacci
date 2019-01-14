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

  val implementations =
    Table(
      ("implementation"),
      (new SimpleButInefficient())
    )

  it should "work for all implementations" in {
    forAll(implementations) { (implementation: FibonacciImplementation) =>
      allPairsShouldWork(implementation)
    }
  }

  private def allPairsShouldWork(implementation: FibonacciImplementation) = {
    forAll(pairs) { (n: Int, f: Int) =>
      implementation.calculateNthSequence(n) should equal(f)
    }
  }
}