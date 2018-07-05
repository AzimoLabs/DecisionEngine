name := "DecisionEngine"

version := "0.1"

scalaVersion := "2.12.5"

lazy val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.0.4" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
)

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.3",
  "org.typelevel" %% "kittens" % "1.0.0-RC2",
  "joda-time" % "joda-time" % "2.9.9"
) ++ testDependencies