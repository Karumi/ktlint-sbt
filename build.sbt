name := "ktlint-sbt"

organization := "com.karumi"

version := "1.0.0"

sbtPlugin := true

// scripted
ScriptedPlugin.scriptedSettings
scriptedLaunchOpts := { scriptedLaunchOpts.value ++
  Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
}
scriptedBufferLog := false