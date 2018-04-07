# ![Karumi logo][karumilogo] Ktlint Sbt 

Sbt plugin wrapper over [ktlint](https://github.com/shyiko/ktlint) project.

## Add Plugin

To add sbt-stats functionality to your project add the following to your `project/plugins.sbt` file:

```scala
  addSbtPlugin("com.karumi" % "ktlint-sbt" % "1.0.0")
```

## Configuration

Optionally you can specify the ktlint version and the dependency source location to your `build.sbt` file:

```scala
ktlintVersion := "0.21.0"
ktlintSource := new File("lib")
``` 

If you don't configure this the defaults defined in the [Defaults](https://github.com/Karumi/ktlint-sbt/blob/master/src/main/scala/com/karumi/Defaults.scala) object will be used.

## Usage

ktlint is used in the same way to the official one described here: https://github.com/shyiko/ktlint#usage

```
$ sbt
> ktlint "src/**/*.kt" "!src/**/*Test.kt"

or 

$ sbt "ktlint src/**/*.kt !src/**/*Test.kt"
```