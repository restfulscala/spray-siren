import com.typesafe.sbt.SbtGit._

versionWithGit

git.baseVersion := "0.1.0"

name := "spray-siren"

organization := "org.restfulscala"

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies ++= Seq(
  "com.yetu" %% "siren-scala" % "0.4.0",
  "io.spray" %% "spray-httpx" % "1.3.2",
  "com.typesafe.akka" %% "akka-actor" % "2.3.6" % "provided",
  "io.spray" %%  "spray-json" % "1.2.6" % "provided",
  "com.typesafe.play" %% "play-json" % "2.3.4" % "provided",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)

scalaVersion := "2.11.4"

licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT"))

bintray.Plugin.bintraySettings

bintray.Keys.bintrayOrganization in bintray.Keys.bintray := Some("restfulscala")

bintray.Keys.packageLabels in bintray.Keys.bintray := Seq("scala", "rest", "spray")

scoverage.ScoverageSbtPlugin.instrumentSettings

org.scoverage.coveralls.CoverallsPlugin.coverallsSettings
