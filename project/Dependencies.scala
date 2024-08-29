import sbt.*

object Dependencies {

  object Versions {
    val scalaTest = "3.2.18"
  }

  object MainDependencies {
    val all: Seq[ModuleID] = Seq()
  }

  object TestDependencies {
    private val scalaTest = "org.scalatest" %% "scalatest" % Versions.scalaTest

    val all: Seq[ModuleID] = Seq(scalaTest).map(_ % Test)
  }

}
