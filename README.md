scala3.g8: [Scala 3] SBT Project Template
===================
This is a [Giter8][g8] template for creating a Scala 3 [sbt] project template.

For more information on how to create your own Giter8 template, look
[here][g8-template] (or just clone/fork this repository as your starting point).


Usage
-------------------
Using [sbt][sbt-usage] (preferred method), run:
```
sbt new llovely/scala3.g8
```
Using [Giter8][g8-usage], run:
```
g8 llovely/scala3.g8
```
Either command will generate a Scala 3 sbt project template in one's current
directory.


Maintenance
-------------------
Version information for library dependencies and plugins are **hardcoded** in
this Giter8 template and the generated Scala 3 sbt project template. If an
update for a library dependency and/or plugin is available, and you
**want to** use the updated version, then the version information must be
updated **manually**. Update information for library dependencies and plugins
can be obtained by executing either of the below commands from within the root
directory of one's local repository.

For this Giter8 template, run:
```
sbt up2date
```

For the generated Scala 3 sbt project template, run:
```
sbt up2date template
```

<br/>

Additionally, the [sbt-github-actions] plugin is used to generate the
Github Actions workflows used in this repository, namely:

- .github/workflows/[ci.yml](.github/workflows/ci.yml)
- .github/workflows/[clean.yml](.github/workflows/clean.yml)

It may be necessary to
regenerate these workflows if significant changes happen to the build of this
Giter8 template. From within the root directory of one's local repository, run
the following command:
```
sbt githubWorkflowGenerate
```
to regenerate the above workflows.
Now, simply commit the results.


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
[sbt-github-actions]: https://github.com/sbt/sbt-github-actions
[Scala 3]: https://www.scala-lang.org/
[Luis Love]: https://github.com/llovely/
