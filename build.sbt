
// The simplest possible sbt build file is just one line:

scalaVersion := "3.5.2"
// That is, to create a valid sbt build, all you've got to do is define the
// version of Scala you'd like your project to use.

// ============================================================================

// Lines like the above defining `scalaVersion` are called "settings". Settings
// are key/value pairs. In the case of `scalaVersion`, the key is "scalaVersion"
// and the value is "2.13.12"

// It's possible to define many kinds of settings, such as:

name := "hello-world"
organization := "io.github.axelhj"
version := "0.1.1"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "2.3.0",
  "org.scalatest" %% "scalatest" % "3.2.9" % Test
)

// To learn about multi-project builds, head over to the official sbt
// documentation at http://www.scala-sbt.org/documentation.html
