name := "ktlint-sbt"

organization := "com.karumi"

version := "0.0.2-SNAPSHOT"

sbtPlugin := true

// scripted
ScriptedPlugin.scriptedSettings
scriptedLaunchOpts := { scriptedLaunchOpts.value ++
  Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
}
scriptedBufferLog := false

credentials += Credentials(new File(".credentials"))
publishTo := Some("Sonatype Snapshots Nexus" at "https://oss.sonatype.org/service/local/staging/deploy/maven2/")

licenses := Seq("apache2" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

homepage := Some(url("https://www.karumi.com/"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/Karumi/ktlint-sbt"),
    "scm:git@github.com:Karumi/ktlint-sbt.git"
  )
)

developers := List(
  Developer(
    id    = "karumi",
    name  = "Karumi",
    email = "hello@karumi.com",
    url   = url("https://github.com/Karumi/ktlint-sbt")
  )
)