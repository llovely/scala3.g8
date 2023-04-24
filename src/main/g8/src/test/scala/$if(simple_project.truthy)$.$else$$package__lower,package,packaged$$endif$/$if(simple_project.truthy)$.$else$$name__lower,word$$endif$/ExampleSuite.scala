/*
 * For more information on writing tests using ScalaCheck and ScalaTest,
 * visit:
 *
 * _ https://github.com/typelevel/scalacheck/blob/main/doc/UserGuide.md
 * - https://www.scalatest.org/user_guide
 * - https://www.scalatest.org/user_guide/property_based_testing
 */

$if(!simple_project.truthy)$
package $package;format="lower,package"$
package $name;format="lower,word"$

$endif$
import scala.math.pow

import org.scalacheck.Gen
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

final class ExampleSuite
  extends AnyFunSuite, Matchers, ScalaCheckPropertyChecks:

  private val validInts =
    for n <- Gen.choose(Int.MinValue, Int.MaxValue) yield n

  test("Integers, when squared, should always be nonnegative") {
    forAll((validInts, "n")) { (n: Int) =>
      pow(n, 2) should be >= 0D
    }
  }

end ExampleSuite
