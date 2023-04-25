$!
This Giter8 template comment WILL NOT be included in the generated sbt project
template.

NOTE: Dollar signs `$` must be escaped `\$` so as not to be interpreted as
      template fields by Giter8 during string interpolation; backslashes `\`
      also need to be escaped `\\` to preserve their meaning after string
      interpolation. After string interpolation, `\$` and `\\` will be
      converted back into `$` and `\`.
!$
import scala.util.Try
import scala.io.AnsiColor
import scala.sys.process._

import sbt._

object Utils {
  def styled(o: Any): String =
    makeStyled(o)

  private def makeStyled(
    o: Any,
    start: String = AnsiColor.CYAN,
    end: String = AnsiColor.RESET
  ): String =
    start + o + end

  def prompt(projectName: String): String =
    gitInfo.fold(projectPrompt(projectName)) { g =>
      val pp = s"\${projectPrompt(projectName)}".trim()
      s"\n\${pp} \$g\n"
    }

  private def projectPrompt(projectName: String): String =
    s"\nsbt: \${makeStyled(projectName, start=AnsiColor.BOLD+AnsiColor.MAGENTA)}\n"

  def projectName(state: State): String =
    Project
      .extract(state)
      .currentRef
      .project

  private def gitInfo(): Option[String] =
    for {
      b <- branch.map(makeStyled(_))
      h <- hash.map(makeStyled(_, start=AnsiColor.YELLOW))
    } yield s"(\$b|\$h)"

  private def branch(): Option[String] =
    run("git rev-parse --abbrev-ref HEAD")

  private def hash(): Option[String] =
    run("git rev-parse --short HEAD")

  private def run(command: String): Option[String] =
    Try(
      command
        .split(" ")
        .toSeq
        .!!(noopProcessLogger)
        .trim
    ).toOption

  private val noopProcessLogger: ProcessLogger =
    ProcessLogger(_ => (), _ => ())
}
