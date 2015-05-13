name := """play-cloudinary-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

resolvers += "sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "com.cloudinary" %% "cloudinary-scala-play" % "0.9.7-SNAPSHOT",
  jdbc,
  anorm,
  cache,
  ws
)
