lazy val scalaVersions = Seq("2.12.17")
lazy val javaVersions = Seq("8", "11", "17").map(JavaSpec.temurin)

lazy val templateName = "scala3-template"

lazy val root = project.in(file("."))
  .settings(
    name := templateName,
    scriptedLaunchOpts ++= Seq(
      "-Xms1024m",
      "-Xmx1024m",
      "-XX:ReservedCodeCacheSize=128m",
      "-Xss2m",
      "-Dfile.encoding=UTF-8"
    ),
    // resolvers += Resolver.typesafeIvyRepo("releases"),
    crossScalaVersions := scalaVersions,
  )

Test / test := (Test / g8Test).toTask("").value

ThisBuild / githubWorkflowPublishTargetBranches := Nil
ThisBuild / githubWorkflowScalaVersions := scalaVersions
ThisBuild / githubWorkflowJavaVersions := javaVersions
ThisBuild / githubWorkflowBuild := Seq(
  // Verifies that the tests in giter8.test pass
  WorkflowStep.Sbt(
    commands = List("g8Test"),
    name = Some("Verifying sbt Project Template Construction")
  ),
  // Verifies that the generated sbt project template runs and passes all tests
  WorkflowStep.Run(
    commands = List(
      s"""|pushd target/sbt-test/${templateName}/scripted &&
          |sbt run test &&
          |popd""".stripMargin.replace("\n", " ")
    ),
    name = Some("Verifying Constructed sbt Project")
  )
)

Global / onChangedBuildSource := ReloadOnSourceChanges
