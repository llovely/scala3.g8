lazy val `meta-root` =
  project
    .in(file("."))
    .settings(
      // In the dependency report, ignore the scala std library FOR sbt.
      dependencyUpdatesFilter -= moduleFilter(
        organization = "org.scala-lang",
        name = "scala-library"
      )
    )

/*
 * If updating the version number of the `sbt-updates` plugin, DO NOT FORGET
 * to also update the version number in `./project/plugins.sbt`.
 */
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.6.4")
addSbtPlugin("com.timushev.sbt" % "sbt-rewarn" % "0.1.3")
addSbtPlugin("io.spray" % "sbt-revolver" % "0.10.0")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.0")
addDependencyTreePlugin
