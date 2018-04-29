package com.karumi

import com.karumi.Keys.{downloadKtlint, ktlint, ktlintSource, ktlintVersion}
import sbt.complete.DefaultParsers.spaceDelimited
import sbt.{AutoPlugin, File}

import scala.sys.process._


object KtlintPlugin extends AutoPlugin {

  private val error = 1
  private type Command = String

  override def projectSettings: scala.Seq[sbt.Setting[_]] = Seq(
    ktlintSource := Defaults.ktlintLibDirectory,
    ktlintVersion := Defaults.lastKtlintVersion,
    ktlint := {
      val args = spaceDelimited("<arg>").parsed.mkString(" ")
      val ktlintFile = new File(ktlintSource.value, fileName(ktlintVersion.value))
      if (!ktlintFile.exists()) {
        download(ktlintSource.value, ktlintVersion.value)
      }

      val ktlintResult = s"$ktlintFile $args" !

      println(s"\n")

      if (ktlintResult == error) {
        throw new IllegalStateException("Filed, some issues to resolve")
      }
    },
    downloadKtlint := {
      download(ktlintSource.value, ktlintVersion.value)
    }
  )

  val autoImport: Keys.type = Keys

  private def download(source: File, version: String) {
    println(s"Downloading ktlint-$version dependency...")

    run(
      s"curl -sSLO https://github.com/shyiko/ktlint/releases/download/$version/ktlint",
      "chmod u+x ktlint",
      s"mkdir -p $source",
      s"mv ktlint $source/${fileName(version)}"
    )

    println(s"$source/ktlint-$version downloaded")
  }

  private def fileName(version: String): String = s"ktlint-$version"

  private def run(commands: Command*) {
    commands.foreach(command => {
      if ((command !) == error) {
        throw new IllegalStateException("Something went wrong")
      }
    })
  }
}