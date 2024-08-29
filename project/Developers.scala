import sbt.*

object Developers {

  private val PrabhatKashyap: Developer = Developer(
    id = "kashyap-prabhat",
    name = "Prabhat Kashyap",
    email = "",
    url = url("https://prabhat.dev")
  )

  val all: List[Developer] = List(
    PrabhatKashyap
  )


}
