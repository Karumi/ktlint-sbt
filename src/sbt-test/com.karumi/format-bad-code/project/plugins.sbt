{
  val ver = System.getProperty("plugin.version")
  if (ver == null)
    throw new IllegalStateException("""
                                 |The system property 'plugin.version' is not defined.
                                 |Specify this property using scriptedLaunchOpts -Dplugin.version."""
      .stripMargin)
  else addSbtPlugin("com.karumi" % "ktlint-sbt" % ver)
}
