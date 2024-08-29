package sigma.probability

import sigma.exception.InvalidInputException

object BasicProbability {

  /**
    * Calculates the probability of an event. P(A) = Number of favorable outcomes / Total number of outcomes
    *
    * @param favorableOutcomes
    *   The number of favorable outcomes.
    * @param totalOutcomes
    *   The total number of possible outcomes.
    * @return
    *   Either an error message or the probability of the event.
    */
  def calculateProbability(favorableOutcomes: Int, totalOutcomes: Int): Either[InvalidInputException, Double] = {
    if totalOutcomes <= 0 then {
      Left(InvalidInputException("Total number of outcomes must be greater than zero."))
    } else {
      Right(favorableOutcomes.toDouble / totalOutcomes)
    }
  }

}
