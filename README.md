scala3.g8: [Scala 3] Project Template
===================
This is a [Giter8][g8] template for creating a Scala 3 [sbt] project.

For more information on how to create your own Giter8 template, look
[here][g8-template] (or just clone/fork this repository as your starting point).


Usage
-------------------
Using [sbt][sbt-usage] (preferred method), do:
```
sbt new llovely/scala3.g8
```
Using [Giter8][g8-usage], do:
```
g8 llovely/scala3.g8
```
Either command will generate the sbt project template in the user's current
directory.


Maintenance
-------------------
Version information for library dependencies and plugins are **hardcoded** in
this template. If an update for a library dependency and/or plugin is
available, and you **want to** use the updated version, then version information
**must be** updated manually.

The following files are listed for reference (mostly for convenience) when
needing to update version information:

### Library Dependencies:
- **ScalaTest** ([releases](https://github.com/scalatest/scalatest/releases))
  - ./src/main/g8/[build.sbt](src/main/g8/build.sbt)

### Plugins:
- **Scalafmt** ([releases](https://github.com/scalameta/sbt-scalafmt/releases))
  - ./src/main/g8/project/[plugins.sbt](src/main/g8/project/plugins.sbt)
- **Giter8** ([releases](https://github.com/foundweekends/giter8/releases))
  - ./project/[plugins.sbt](project/plugins.sbt)
- **sbt-github-actions** ([releases](https://github.com/sbt/sbt-github-actions/releases))
  - ./project/[plugins.sbt](project/plugins.sbt)

### Others:
- **Scala 3 Version** ([releases](https://github.com/lampepfl/dotty/releases))
  - ./[build.sbt](build.sbt)
  - ./src/main/g8/[build.sbt](src/main/g8/build.sbt)
- **sbt Version** ([releases](https://github.com/sbt/sbt/releases))
  - ./project/[build.properties](project/build.properties)
  - ./src/main/g8/project/[build.properties](src/main/g8/project/build.properties)
- **Scalafmt** ([releases](https://github.com/scalameta/scalafmt/releases))
  - ./src/main/g8/[.scalafmt.conf](src/main/g8/.scalafmt.conf)

<br/>

Additionally, the sbt-github-actions plugin is being used to generate the
Github Actions workflows used in this repository. It may be necessary to
regenerate these workflows if significant changes happen to the build of this
Giter8 template. Run the following commmand:
```
sbt githubWorkflowGenerate
```
from within this Giter8 template project to regenerate the workflows.
Now, commit the results.


Template license
-------------------
Written in 2023 by [Luis Love]

To the extent possible under law, the author(s) have dedicated all copyright
and related and neighboring rights to this template to the public domain
worldwide. This template is distributed without any warranty. See
<http://creativecommons.org/publicdomain/zero/1.0/>.


[g8]: https://www.foundweekends.org/giter8/
[g8-usage]: https://www.foundweekends.org/giter8/usage.html
[g8-template]: https://www.foundweekends.org/giter8/template.html
[sbt]: https://www.scala-sbt.org/
[sbt-usage]: https://www.scala-sbt.org/1.x/docs/sbt-new-and-Templates.html
[Scala 3]: https://www.scala-lang.org/
[Luis Love]: https://github.com/llovely/
