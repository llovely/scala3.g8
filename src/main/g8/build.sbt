val scala3Version = "3.2.2"

lazy val root = 
  project
    .in(file("."))
    .settings(
      name := "$name$",
      version := "0.1.0-SNAPSHOT",

      scalaVersion := scala3Version,

      libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "3.2.15" % Test
        )
    )
