$!
This Giter8 template comment WILL NOT be included in the generated sbt project
template.

NOTE: Dollar signs `$` must be escaped `\$` so as not to be interpreted as
      template fields by Giter8 during variable interpolation. After
      variable interpolation, `\$` will be converted back into `$`.
!$
import Utils._

addCommandAlias("l", "projects")
addCommandAlias("ll", "projects")
addCommandAlias("ls", "projects")
addCommandAlias("cd", "project")
addCommandAlias("root", "cd root")
addCommandAlias("c", "compile")
addCommandAlias("ca", "Test / compile")
addCommandAlias("t", "test")
addCommandAlias("r", "run")
addCommandAlias("rs", "reStart")
addCommandAlias("s", "reStop")
addCommandAlias(
  "styleCheck",
  "scalafmtSbtCheck; scalafmtCheckAll",
)
addCommandAlias(
  "styleFix",
  "scalafmtSbt; scalafmtAll",
)

onLoadMessage +=
  s"""|
      |╭─────────────────────────────────╮
      |│     List of defined \${styled("aliases")}     │
      |├─────────────┬───────────────────┤
      |│ \${styled("l")} | \${styled("ll")} | \${styled("ls")} │ projects          │
      |│ \${styled("cd")}          │ project           │
      |│ \${styled("root")}        │ cd root           │
      |│ \${styled("c")}           │ compile           │
      |│ \${styled("ca")}          │ compile all       │
      |│ \${styled("t")}           │ test              │
      |│ \${styled("r")}           │ run               │
      |│ \${styled("rs")}          │ reStart           │
      |│ \${styled("s")}           │ reStop            │
      |│ \${styled("styleCheck")}  │ fmt check         │
      |│ \${styled("styleFix")}    │ fmt               │
      |╰─────────────┴───────────────────╯""".stripMargin
