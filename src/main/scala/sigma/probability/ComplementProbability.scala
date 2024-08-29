package sigma.probability

import sigma.exception.InvalidInputException

object ComplementProbability {

  /**
    * Calculates the probability of the complement of an event.
    *
    * @param probabilityOfEvent
    *   The probability of the event A.
    * @return
    *   Either an error message or the probability of the complement of the event.
    */
  def calculateComplementProbability(probabilityOfEvent: Double): Either[InvalidInputException, Double] = {
    if probabilityOfEvent < 0 || probabilityOfEvent > 1 then {
      Left(InvalidInputException("Probability of the event must be between 0 and 1."))
    } else {
      Right(1.0 - probabilityOfEvent)
    }
  }

}
