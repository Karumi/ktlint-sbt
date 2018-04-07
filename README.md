# ![Karumi logo](https://cloud.githubusercontent.com/assets/858090/11626547/e5a1dc66-9ce3-11e5-908d-537e07e82090.png) Ktlint Sbt 

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

License
-------

    Copyright 2018 Karumi

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.