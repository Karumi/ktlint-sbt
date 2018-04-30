package com.karumi

import sbt._

object Keys {

  val ktlintSource = SettingKey[File]("ktlint-source", "Ktlint dependency source")
  val ktlintVersion = SettingKey[String]("ktlint-version", "Ktlint version to use")

  lazy val ktlint = inputKey[Unit]("Kotlin linter with built-in formatter")
  lazy val downloadKtlint = taskKey[Unit]("Download ktlint dependency")

}
