val scala3Version = "3.2.2"

lazy val root = 
  project
    .in(file("."))
    .settings(
      name := "scala3-template",
      scalaVersion := scala3Version,
    )
