/*
 * For more information about programming in Scala, visit
 * https://docs.scala-lang.org/
 */

$if(!simple_project.truthy)$
package $package;format="lower,package"$
package $name;format="lower,word"$

$endif$
import scala.language.strictEquality

// A few possibly useful imports
import scala.compiletime.uninitialized
import scala.util.CommandLineParser.FromString // Typeclass

@main
def main(args: String*): Unit =
  println("Hello, World!")
