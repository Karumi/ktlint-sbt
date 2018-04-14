package com.karumi

import com.karumi.Keys.{downloadKtlint, ktlint, ktlintSource, ktlintVersion}
import sbt.complete.DefaultParsers.spaceDelimited
import sbt.{AutoPlugin, File}

import scala.sys.process._


object KtlintPlugin extends AutoPlugin {

  private val KTLINT_ERROR = 1

  override def projectSettings: scala.Seq[sbt.Setting[_]] = Seq(
    ktlintSource := Defaults.ivyHomeDirectory,
    ktlintVersion := Defaults.lastKtlintVersion,
    ktlint := {
      val args = spaceDelimited("<arg>").parsed.mkString(" ")
      val ktlintFile = new File(ktlintSource.value, fileName(ktlintVersion.value))
      if (!ktlintFile.exists()) {
        download(ktlintSource.value, ktlintVersion.value)
      }

      val result: Int = s"$ktlintFile $args" !

      println(s"\n")

      if (result == KTLINT_ERROR) {
        throw new IllegalStateException("Filed, some issues to resolve")
      }
    },
    downloadKtlint := { download(ktlintSource.value, ktlintVersion.value) }
  )

  val autoImport: Keys.type = Keys

  private def download(source: File, version: String) {
    println(s"Downloading ktlint-$version dependency...")

    val curl = s"curl -sSLO https://github.com/shyiko/ktlint/releases/download/$version/ktlint" !
    val chmod = "chmod u+x ktlint" !
    val createSourceFolder = s"mkdir -p $source" !
    val res = s"sudo mv ktlint $source/${fileName(version)}" !

    if (curl == 1 || chmod == 1 || res == 1) {
      throw new IllegalStateException("Something went wrong")
    }

    println(s"$source/ktlint-$version downloaded")
  }

  private def fileName(version: String): String = s"ktlint-$version"
}
