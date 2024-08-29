package sigma.probability

import sigma.exception.InvalidInputException

object MultiplicationRule {

  /**
    * Calculates the probability of the intersection of two independent events A and B using the Multiplication Rule.
    *
    * Multiplication Rule Formula:
    *
    * P(A ∩ B) = P(A) × P(B)
    *
    * Where:
    *   - P(A ∩ B) is the probability of both events A and B occurring.
    *   - P(A) is the probability of event A occurring.
    *   - P(B) is the probability of event B occurring.
    *
    * Example: Suppose:
    *   - P(A) = 0.4 (probability of event A occurring)
    *   - P(B) = 0.5 (probability of event B occurring) Then: P(A ∩ B) = P(A) × P(B) = 0.4 × 0.5 = 0.2 This means there
    *     is a 20% chance of both event A and event B occurring.
    *
    * @param probabilityOfA
    *   The probability of event A.
    * @param probabilityOfB
    *   The probability of event B.
    * @return
    *   Either an error message or the probability of both events A and B occurring.
    */
  def calculateIntersectionProbability(
      probabilityOfA: Double,
      probabilityOfB: Double
  ): Either[InvalidInputException, Double] = {
    if probabilityOfA < 0 || probabilityOfA > 1 ||
    probabilityOfB < 0 || probabilityOfB > 1 then {
      Left(InvalidInputException("Probabilities must be between 0 and 1."))
    } else {
      Right(probabilityOfA * probabilityOfB)
    }
  }

  def main(args: Array[String]): Unit = {
    // Example usage
    val probabilityOfA = 0.4
    val probabilityOfB = 0.5

    calculateIntersectionProbability(probabilityOfA, probabilityOfB) match {
      case Right(intersectionProbability) => println(f"The probability P(A ∩ B) is: $intersectionProbability%.2f")
      case Left(error)                    => println(s"Error: ${error.getMessage}")
    }
  }
}
