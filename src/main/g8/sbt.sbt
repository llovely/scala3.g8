$!
This Giter8 template comment WILL NOT be included in the generated sbt project
template.

NOTE: Dollar signs `$` must be escaped `\$` so as not to be interpreted as
      template fields by Giter8 during variable interpolation. After
      variable interpolation, `\$` will be converted back into `$`.
!$
import Utils._

Global / onChangedBuildSource := ReloadOnSourceChanges
Global / excludeLintKeys ++= Set(
  autoStartServer,
  turbo,
  evictionWarningOptions,
)

Test / parallelExecution := false
Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-oSD")
Test / turbo := true // enables optional performance features

ThisBuild / autoStartServer := insideCI.value
ThisBuild / includePluginResolvers := true
ThisBuild / turbo := true // enables optional performance features

ThisBuild / watchBeforeCommand := Watch.clearScreen
ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger
ThisBuild / watchForceTriggerOnAnyChange := true

ThisBuild / shellPrompt := { state => s"\${prompt(projectName(state))}> " }
ThisBuild / watchStartMessage := {
  case (iteration, ProjectRef(build, projectName), commands) =>
    Some {
      s"""|~\${commands.map(styled).mkString(";")}
          |Monitoring source files for \${prompt(projectName)}...""".stripMargin
    }
}
ThisBuild / commands ++= Seq(up2date)


lazy val up2dateHelp = Help(
  "up2date",
  "up2date" -> "Lists potential dependency updates for the ENTIRE project.",
  """|up2date
     |
     |  Lists potential dependency updates for the ENTIRE project.
     |""".stripMargin
)
lazy val up2date = Command.command("up2date", up2dateHelp){ state =>
  "reload plugins" ::
  "dependencyUpdates" ::
  "reload return" ::
  "dependencyUpdates" ::
  state
}
