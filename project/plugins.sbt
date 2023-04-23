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
addSbtPlugin("org.foundweekends.giter8" %% "sbt-giter8" % "0.16.1")
addSbtPlugin("com.codecommit" % "sbt-github-actions" % "0.14.2")
addDependencyTreePlugin
