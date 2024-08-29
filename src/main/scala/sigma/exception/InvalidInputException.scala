package sigma.exception

/**
  * Exception for invalid input.
  * @param message
  *   The exception message.
  */
case class InvalidInputException(message: String) extends Exception(message)
