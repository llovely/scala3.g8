import sbt.complete.DefaultParsers._

Global / onChangedBuildSource := ReloadOnSourceChanges
Global / autoStartServer := false
Global / excludeLintKeys ++= Set(autoStartServer)
Global / commands ++= Seq(up2date)

addCommandAlias("test", "g8Test")

lazy val up2dateHelp = Help(
  "up2date",
  "up2date" -> (
    "Lists potential dependency updates for this Giter8 template " +
    "and/or generated Scala 3 sbt project template."
  ),
  // Detailed help message is modeled after `reload` help message.
  """|up2date
     |
     |  Lists potential dependency updates for this Giter8 template.
     |
     |up2date template
     |
     |  Lists potential dependency updates in the generated Scala 3 sbt project
     |  template.
     |""".stripMargin
)
lazy val up2dateParser = (state: State) => token(Space ~> "template") ?? ";"
lazy val up2dateAction = (state: State, arg: String) =>
  arg match {
    // Reusing the `g8Test` task with a different `test` script.
    case "template" => {
      val script = s"${state.configuration.baseDirectory}/src/test/g8/up2date"
      val newState = Project.extract(state).appendWithSession(
        Seq(g8TestScript := new java.io.File(script)),
        state
      )

      Command.process("g8Test", newState)
      state
    }
    case ";" => {
      "reload plugins" ::
      "dependencyUpdates" ::
      "reload return" ::
      "dependencyUpdates" ::
      state
    }
    case _ => state.fail
  }
lazy val up2date = Command("up2date", up2dateHelp)(up2dateParser)(up2dateAction)
