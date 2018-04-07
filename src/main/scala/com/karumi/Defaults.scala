package com.karumi

import sbt.File
import sbt.Keys.ivyPaths

object Defaults {

  val ivyHomeDirectory: File = ivyPaths.value.ivyHome.get
  val lastKtlintVersion: String = "0.21.0"

}
