import sbtghactions.JavaSpec

object Utils {
  /*
   * The `scripted-sbt` library is only available for this version of Scala,
   * so we MUST USE this version of Scala. The `g8Test` task (and `up2date`
   * command) use this library.
   */
  private val scala212 = "2.12.17"

  val scalaVersions = Seq(scala212)
  val javaVersions = Seq("8", "11", "17").map(JavaSpec.temurin)
  val scalaBuildVersion = scala212
}
