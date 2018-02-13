name := "thread_stuff"

version := "0.1"

scalaVersion := "2.12.4"

lazy val root = (project in file("."))
  .settings(
    fork := true,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.5.9",
      "com.typesafe.akka" %% "akka-testkit" % "2.5.9" % Test,
      "org.scalatest" %% "scalatest" % "3.0.4" % Test
    )
  )