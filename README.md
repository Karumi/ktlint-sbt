# ![Karumi logo](https://cloud.githubusercontent.com/assets/858090/11626547/e5a1dc66-9ce3-11e5-908d-537e07e82090.png) Ktlint sbt 

sbt plugin wrapper over [ktlint](https://github.com/shyiko/ktlint) project.

## Add Plugin

To add this functionality to your project add the following to your `project/plugins.sbt` file:

```scala
  addSbtPlugin("com.karumi" % "ktlint-sbt" % "0.0.1")
```

## Configuration

Optionally, you can specify the ktlint version and the dependency source location in your `build.sbt` file:

```scala
  ktlintVersion := "0.21.0"
  ktlintSource := new File("lib")
``` 

If you don't add these values yourself the plugin will use the ones defined in [Defaults](https://github.com/Karumi/ktlint-sbt/blob/master/src/main/scala/com/karumi/Defaults.scala)

## Usage

This plugin is used in the exact same way you'd use ktlint directly. If you want to know more about all the tool options you can visit [the official documentation](https://github.com/shyiko/ktlint#usage) 

Run linter
```
$ sbt
> ktlint "src/**/*.kt" "!src/**/*Test.kt"
```

Run linter with autoformat 

```
$ sbt "ktlint -F src/**/*.kt !src/**/*Test.kt"
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