import Dependencies._

$if(!simple_project.truthy)$
ThisBuild / organization := "$organization;format="lower,package"$"
$endif$
ThisBuild / scalaVersion := "3.2.2"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalacOptions ++= scalacCommonOptions ++ scalacMigrationOptions


lazy val scalacCommonOptions = Seq(
  "-encoding", "UTF-8",
  "-deprecation",
  "-explain",
  "-feature",
  "-language:implicitConversions",
  "-unchecked",
  "-Werror",
  "-Wunused:all",
  "-Yexplicit-nulls",
  "-Ykind-projector",
  "-Ysafe-init",

  /*
   * The compiler will not apply `-indent -new-syntax -rewrite` steps at the
   * same time; two separate compilation passes are needed.
   *
   * Perform `-new-syntax -rewrite` step first, since `-indent` does not work
   * on the classic control structures.
   */
  "-rewrite",       // this WILL rewrite source code, if applicable
  // "-new-syntax", // old syntax isn't used enough to warrant option use
  "-indent",        // prefer to not use braces, if possible
)

// Source migration WILL rewrite source code, if applicable.
lazy val allowSourceMigration = false
lazy val scalacMigrationOptions = {
  lazy val rewriteOption = "-rewrite"
  lazy val sourceMigrationOptions = Seq(
    "-source",
    "future-migration"
  )

  if (allowSourceMigration)
    // Prevents `-rewrite` option from being included more than once.
    if (scalacCommonOptions.contains(rewriteOption))
      sourceMigrationOptions
    else
      rewriteOption +: sourceMigrationOptions
  else
    Seq()
}

lazy val commonSettings = {
  lazy val commonScalacOptions = Seq(
    Compile / console / scalacOptions --= Seq(
      "-Werror",
      "-Wunused:all",
    ),
    Test / console / scalacOptions :=
      (Compile / console / scalacOptions).value,
  )

  lazy val otherCommonSettings = Seq(
    update / evictionWarningOptions := EvictionWarningOptions.empty
  )

  Seq(commonScalacOptions, otherCommonSettings).reduceLeft(_ ++ _)
}

lazy val dependencies = Seq(
  libraryDependencies ++= Seq(
    // Place dependencies here!
    "com.github.scopt" %% "scopt" % "4.1.0",  // command line argument parser
  ) ++ testingDeps
)


/*******************************************************************************
 *                                  Projects
 ******************************************************************************/

lazy val root =
  project
    .in(file("."))
    // .disablePlugins(RevolverPlugin) // disables sbt-revolver auto plugin
    .settings(
      name := "$name$",
      crossScalaVersions := Nil,
    )
    .settings(commonSettings)
    .settings(dependencies)
