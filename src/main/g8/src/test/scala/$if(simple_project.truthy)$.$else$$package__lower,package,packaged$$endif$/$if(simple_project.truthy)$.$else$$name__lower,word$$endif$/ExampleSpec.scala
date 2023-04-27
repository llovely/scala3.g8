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
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

final class ExampleSpec extends AnyFreeSpec, Matchers, ScalaCheckPropertyChecks:
  "A Set" - {
    "when empty" - {
      "should have size 0" in { Set.empty should have size 0 }
      "should produce NoSuchElementException when head is invoked" in {
        assertThrows[NoSuchElementException] { Set.empty.head }
      }
    }
  }

end ExampleSpec
