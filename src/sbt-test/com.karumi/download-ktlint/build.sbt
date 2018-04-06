lazy val root = (project in file("."))
  .enablePlugins(KtlintPlugin)
  .settings(
    version := "0.1",
    scalaVersion := "2.10.6"
  )

ktlintSource := new File("lib")