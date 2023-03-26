# scala3.g8: [Scala 3] Project Template

This is a [Giter8][g8] template for creating a Scala 3 [sbt] project.

---

## Usage

Using [sbt] (preferred method), do:
```
sbt new llovely/scala3.g8
```
Using [Giter8][g8-usage], do:
```
g8 new llovely/scala3.g8
```
Either command will generate the sbt project template in the user's current
directory.

---

## Maintenance

Version information for library dependencies and plugins are **hardcoded** in
this template. If an update for a library dependency and/or plugin is
available, and you **want to** use the updated version, then version information
**must be** updated manually.

The following files are listed for reference (mostly for convenience) when
needing to update version information:

### Library Dependencies:
- **ScalaTest** ([releases](https://github.com/scalatest/scalatest/releases))
  - ./src/main/g8/[build.sbt]()

### Plugins:
- **Scalafmt** ([releases](https://github.com/scalameta/sbt-scalafmt/releases))
  - ./src/main/g8/project/[plugins.sbt]()
- **Giter8** ([releases](https://github.com/foundweekends/giter8/releases))
  - ./project/[plugins.sbt]()

### Others:
- **sbt Version** ([releases](https://github.com/sbt/sbt/releases))
  - ./project/[build.properties]()
  - ./src/main/g8/project/[build.properties]()
- **Scalafmt** ([releases](https://github.com/scalameta/scalafmt/releases))
  - ./src/main/g8/[.scalafmt.conf]()

---

## Template license

Written in 2023 by [Luis Love]

To the extent possible under law, the author(s) have dedicated all copyright
and related and neighboring rights to this template to the public domain
worldwide. This template is distributed without any warranty. See
<http://creativecommons.org/publicdomain/zero/1.0/>.


[g8]: https://www.foundweekends.org/giter8/
[g8-usage]: https://www.foundweekends.org/giter8/usage.html
[sbt]: https://www.scala-sbt.org/
[sbt-usage]: https://www.scala-sbt.org/1.x/docs/sbt-new-and-Templates.html
[Scala 3]: https://www.scala-lang.org/
[Luis Love]: https://github.com/llovely/
