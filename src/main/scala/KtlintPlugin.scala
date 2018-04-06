import Keys._
import sbt.Keys.dependencyCacheDirectory
import sbt.complete.DefaultParsers.spaceDelimited
import sbt.{AutoPlugin, File}

import scala.sys.process._


object KtlintPlugin extends AutoPlugin {

  override lazy val projectSettings = Seq(
    ktlintSource := dependencyCacheDirectory.value,
    ktlintVersion := "0.21.0",
    ktlint
  )

  ktlint := {
    val args = spaceDelimited("<arg>").parsed.mkString(" ")
    val ktlintFile = new File(ktlintSource.value, "ktlin")
    if (!ktlintFile.exists()) {
      downloadKtlint()
    }

    val result: Int = s"$ktlintFile $args" !

    println(s"\n")

    if (result == 1) {
      throw new IllegalStateException("Filed, some issues to resolve")
    }
  }

  private def downloadKtlint() {
    println("Downloading ktlint depedencies...")

    val curl = s"curl -sSLO https://github.com/shyiko/ktlint/releases/download/${ktlintVersion.value}/ktlint" !
    val chmod = "chmod a+x ktlint" !
    val res = s"sudo mv ktlint $ktlintSource" !

    if (curl == 1 || chmod == 1 || res == 1) {
      throw new IllegalStateException("Something went wrong")
    }

    println(s"Ktlint downloaded here $ktlintSource")
  }

}
