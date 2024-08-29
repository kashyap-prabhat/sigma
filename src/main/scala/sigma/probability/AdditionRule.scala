package sigma.probability

import sigma.exception.InvalidInputException

object AdditionRule {

  /**
    * Calculates the probability of the union of two events A and B using the Addition Rule.
    *
    * Addition Rule Formula:
    *
    * P(A ∪ B) = P(A) + P(B) - P(A ∩ B)
    *
    * Where:
    *   - P(A ∪ B) is the probability of event A or event B or both occurring.
    *   - P(A) is the probability of event A occurring.
    *   - P(B) is the probability of event B occurring.
    *   - P(A ∩ B) is the probability of both events A and B occurring simultaneously.
    *
    * Example: Suppose:
    *   - P(A) = 0.6 (probability of event A occurring)
    *   - P(B) = 0.5 (probability of event B occurring)
    *   - P(A ∩ B) = 0.3 (probability of both A and B occurring) Then: P(A ∪ B) = P(A) + P(B) - P(A ∩ B) = 0.6 + 0.5 -
    *     0.3 = 0.8 This means there is an 80% chance of either event A or event B or both occurring.
    *
    * @param probabilityOfA
    *   The probability of event A.
    * @param probabilityOfB
    *   The probability of event B.
    * @param probabilityOfAAndB
    *   The probability of both events A and B occurring.
    * @return
    *   Either an error message or the probability of the union of events A and B.
    */
  def calculateUnionProbability(
      probabilityOfA: Double,
      probabilityOfB: Double,
      probabilityOfAAndB: Double
  ): Either[InvalidInputException, Double] = {
    if probabilityOfA < 0 || probabilityOfA > 1 ||
    probabilityOfB < 0 || probabilityOfB > 1 ||
    probabilityOfAAndB < 0 || probabilityOfAAndB > 1 then {
      Left(InvalidInputException("Probabilities must be between 0 and 1."))
    } else if probabilityOfAAndB > probabilityOfA || probabilityOfAAndB > probabilityOfB then {
      Left(InvalidInputException("Probability of intersection cannot be greater than individual probabilities."))
    } else {
      Right(probabilityOfA + probabilityOfB - probabilityOfAAndB)
    }
  }

}
