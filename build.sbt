organization := "org.hyper.data"

name := "hyper-data"

version := "0.1"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % scalaVersion.value,
  "io.undertow" % "undertow-core" % "1.2.0.Beta3",
  "org.spire-math" %% "jawn-parser" % "0.7.1",
  "org.json4s" %% "json4s-native" % "3.2.11"
)

resolvers ++= Seq(
  Resolver.mavenLocal,
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

incOptions := incOptions.value.withNameHashing(true)
