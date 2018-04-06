package com.karumi

import com.karumi.Keys.{ktlint, ktlintSource, ktlintVersion, downloadKtlint}
import sbt.Keys.{ivyPaths}
import sbt.complete.DefaultParsers.spaceDelimited
import sbt.{AutoPlugin, File}

import scala.sys.process._


object KtlintPlugin extends AutoPlugin {
  override def projectConfigurations = Nil

  override def globalSettings = Nil

  override lazy val projectSettings = Seq(
    ktlintSource := ivyPaths.value.ivyHome.get,
    ktlintVersion := "0.21.0",
    ktlint := {
      val args = spaceDelimited("<arg>").parsed.mkString(" ")
      val ktlintFile = new File(ktlintSource.value, "ktlin")
      if (!ktlintFile.exists()) {
        download(ktlintSource.value, ktlintVersion.value)
      }

      val result: Int = s"$ktlintFile $args" !

      println(s"\n")

      if (result == 1) {
        throw new IllegalStateException("Filed, some issues to resolve")
      }
    },
    downloadKtlint := { download(ktlintSource.value, ktlintVersion.value) }
  )

  def download(source: File, version: String) {
    println("Downloading ktlint depedencies...")

    val curl = s"curl -sSLO https://github.com/shyiko/ktlint/releases/download/$version/ktlint" !
    val chmod = "chmod a+x ktlint" !
    val res = s"sudo mv ktlint $source" !

    if (curl == 1 || chmod == 1 || res == 1) {
      throw new IllegalStateException("Something went wrong")
    }

    println(s"Ktlint downloaded here $source")
  }

}
