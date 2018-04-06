import sbt.complete.DefaultParsers.spaceDelimited

InputKey[Unit]("exists-ktlint") := {
  val ktlintVersion = spaceDelimited("<arg>").parsed.head
  val ktlintSource = "lib"
  val ktlintFile = new File(ktlintSource, s"ktlint-$ktlintVersion")

  if(!ktlintFile.exists()) {
    throw new IllegalStateException(s"ktlint-$ktlintVersion should have downloaded")
  }
}
