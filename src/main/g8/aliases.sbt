$!
This Giter8 template comment WILL NOT be included in the generated sbt project
template.

NOTE: Dollar signs `$` must be escaped `\$` so as not to be interpreted as
      template fields by Giter8 during string interpolation; backslashes `\`
      also need to be escaped `\\` to preserve their meaning after string
      interpolation. After string interpolation, `\$` and `\\` will be
      converted back into `$` and `\`.
!$
import scala.math.abs

import Utils._

ThisBuild / commands += aliasTable

/*
 * The order in which these aliases are defined will correspond with the order
 * they are listed in the alias table. Any alias defined in interactive mode
 * will appear ABOVE these aliases in the alias table.
 */
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
addCommandAlias("fmtCheck", "scalafmtSbtCheck; scalafmtCheckAll")
addCommandAlias("fmt", "scalafmtSbt; scalafmtAll")


lazy val aliasTableValuePartitionLength = 40
lazy val aliasTableValuePartitionPrefix = hyphenBreakStyled("->")
lazy val aliasTableValuePartitionPostfix = hyphenBreakStyled("-")
lazy val aliasTableHelp = Help(
  "aliasTable",
  "aliasTable" -> "Displays a tabulated list of defined aliases.",
  {
    val n = aliasTableValuePartitionLength
    val prefix = aliasTableValuePartitionPrefix
    val postfix = aliasTableValuePartitionPrefix
    val offset = hyphenBreakStyled("").length
    s"""|aliasTable
    |
    |  Displays a tabulated list of defined aliases. An alias defined (or
    |  one that overrides an existing alias) in interactive mode will appear
    |  above all previously defined aliases.
    |
    |  When an alias' corresponding value exceeds \${n} characters in length,
    |  it will be partitioned into multiple lines; each line is a maximum of
    |  \${n} characters in length. There are prefix and postfix characters used
    |  to denote a partitioned value. The line ending with a postfix symbol
    |  should be CONCATENATED with the line beginning with the prefix symbol.
    |  As an example of a partitioned value (with a max partition length of
    |  10 characters):
    |
    |      \${" " * (prefix.length - offset)}Which came\${postfix}
    |      \${prefix} first, th\${postfix}
    |      \${prefix}e chicken \${postfix}
    |      \${prefix}or the egg\${postfix}
    |      \${prefix}?
    |
    |  should be interpreted as:
    |
    |      Which came first, the chicken or the egg?
    |""".stripMargin
  }
)
lazy val aliasTable = Command.command("aliasTable", aliasTableHelp) { state =>
  case class StyStr(value: String, offset: Int = 0) {
    require(offset >= 0)
    def length: Int = value.length - offset
  }

  def makeTable(header: StyStr, rows: Seq[(String, String)]): String = {
    def pad(s: String, amount: Int, c: Char = ' '): String =
      s"\${s.padTo(amount, c)}"

    val hbsOffset = hyphenBreakStyled("").length
    val hbsPrefix = StyStr(aliasTableValuePartitionPrefix, hbsOffset)
    val hbsPostfix = StyStr(aliasTableValuePartitionPostfix, hbsOffset)
    val sameAliasSep = StyStr(" | ")

    val processedRows = {
      import scala.collection.mutable.{LinkedHashMap, ListBuffer}
      val m = LinkedHashMap.empty[String, ListBuffer[String]]
      rows.foreach { case (ra, rv) =>
        if (!m.contains(rv)) m(rv) = ListBuffer()
        m(rv) += ra
      }

      val groupedRows = m.toSeq.map { case (ra, rv) =>
        (rv.toSeq, ra.grouped(aliasTableValuePartitionLength).toList)
      }

      groupedRows.map { case (ra, rv) =>
        val alias = StyStr(
          ra.map(styled).mkString(sameAliasSep.value),
          ra.length * styled("").length
        )
        val value = rv match {
          case Nil => Seq(StyStr(""))  // this case should NEVER happen
          case x :: Nil => Seq(StyStr(x))
          case (x :: y) :+ z => {
            val start =
              StyStr(" " * hbsPrefix.length + x + hbsPostfix.value, hbsOffset)
            val middle = y.map { s =>
              StyStr(hbsPrefix.value + s + hbsPostfix.value, 2 * hbsOffset)
            }
            val end =
              StyStr(hbsPrefix.value + z, hbsOffset)
            (start :: middle) :+ end
          }
        }
        (alias, value)
      }
    }

    val maxAliasLength =
      if (processedRows.isEmpty) 0
      else processedRows.map(_._1.length).max
    val maxValueLength =
      if (processedRows.isEmpty) 0
      else processedRows.map(_._2.map(_.length)).flatten.max

    val ((rowPadL, rowPadR), (headerPadL, headerPadR)) = {
      /*
       * The `3` accounts for the default table characters in between an alias
       * and value, i.e.,
       *
       *    │ alias │ value │
       *           ^^^
       */
      val headerSectionLength = maxAliasLength + maxValueLength + 3

      val padTotal = abs(header.length - headerSectionLength)
      val l, r = padTotal / 2
      val pad = if (padTotal % 2 == 0) (l, r) else (l, r + 1)

      if (header.length >= headerSectionLength) (pad, (0, 0))
      else ((0, 0), pad)
    }

    /*
     * The `2` accounts for the default space character on either side of an
     * alias and value, i.e.,
     *
     *    │<space>alias<space>│<space>value<space>│
     */
    val aliasBar = pad("", maxAliasLength + rowPadL + 2, '─')
    val valueBar = pad("", maxValueLength + rowPadR + 2, '─')

    val hPadL = pad("", headerPadL)
    val hPadR = pad("", headerPadR)

    var table = "\\n"
    table += s"╭\${aliasBar}─\${valueBar}╮\\n"
    table += s"│ \${hPadL}\${header.value}\${hPadR} │\\n"
    table += s"├\${aliasBar}┬\${valueBar}┤\\n"
    processedRows.zipWithIndex.foreach { case ((ra, rv), i) =>
      // if (i > 0) table += s"├\${aliasBar}┼\${valueBar}┤\\n"
      Seq(ra).zipAll(rv, StyStr(""), StyStr("")).foreach { case (a, v) =>
        val alias = pad(a.value, maxAliasLength + rowPadL + a.offset)
        val value = pad(v.value, maxValueLength + rowPadR + v.offset)
        table += s"│ \${alias} │ \${value} │\\n"
      }
    }
    table += s"╰\${aliasBar}┴\${valueBar}╯"
    table
  }

  val aliases = BasicCommands.allAliases(state)
  val header = s"Defined \${styled("Aliases")}"
  val table = makeTable(StyStr(header, styled("").length), aliases)

  println(table)
  state
}
