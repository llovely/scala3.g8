import sbt._

object Dependencies {
  private val scalaCheck =  "org.scalacheck" %% "scalacheck" % "1.17.0"
  private val scalaTest = "org.scalatest" %% "scalatest" % "3.2.15"
  private val scalaTestPlus = "org.scalatestplus" %% "scalacheck-1-17" % "3.2.15.0"

  val testingDeps = Seq(
    scalaCheck,
    scalaTest,
    scalaTestPlus
  ).map(_ % Test)
}
