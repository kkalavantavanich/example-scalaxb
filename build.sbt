lazy val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.2.0"
lazy val scalaParser = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"
lazy val dispatchV = "1.1.3"
lazy val dispatch = "org.dispatchhttp" %% "dispatch-core" % dispatchV

lazy val root = (project in file(".")).
  enablePlugins(ScalaxbPlugin).
  settings(inThisBuild(List(
    organization  := "com.example",
    scalaVersion  := "2.13.2",
    crossScalaVersions := Seq("2.13.2", "2.12.12")
  ))).
  settings(
    name          := "test-scalaxb",
    libraryDependencies ++= Seq(dispatch, scalaXml, scalaParser)
  ).
  settings(
    scalaxbDispatchVersion in (Compile, scalaxb) := dispatchV,
    scalaxbPackageName in (Compile, scalaxb)     := "generated",
    scalaxbPackageNames in (Compile, scalaxb)    := Map(uri("http://www.webserviceX.NET/") -> "microsoft.serialization"),
    logLevel in (Compile, scalaxb) := Level.Debug
  )
