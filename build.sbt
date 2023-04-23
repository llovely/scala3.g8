import Utils._

lazy val root =
  project
    .in(file("."))
    .settings(
      name := "scala3-template",
      scalaVersion := scalaBuildVersion,
      crossScalaVersions := scalaVersions,
      scriptedBufferLog := false,
      scriptedLaunchOpts ++= Seq(
        "-Xms1024m",
        "-Xmx1024m",
        "-XX:ReservedCodeCacheSize=128m",
        "-Xss2m",
        "-Dfile.encoding=UTF-8",
        "-Dsbt.log.noformat=false"  // enables colored output in logs
      ),

      // In the dependency report, ignore the scala std library FOR sbt.
      dependencyUpdatesFilter -= moduleFilter(
        organization = "org.scala-lang",
        name = "scala-library"
      )
    )
