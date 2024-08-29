ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "sigma",
    libraryDependencies ++= Dependencies.MainDependencies.all ++ Dependencies.TestDependencies.all,
    scalacOptions ++= Seq(
      "-deprecation",
      "-explaintypes",
      "-feature",
    ),
    organization := "dev.prabhat",
    developers := Developers.all,
    Test / parallelExecution := false
  )
