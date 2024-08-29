package sigma.probability

import sigma.exception.InvalidInputException

object BayesTheorem {

  /**
    * Calculates the posterior probability using Bayes' Theorem.
    *
    * Bayes' Theorem Formula:
    *
    * P(A|B) = (P(B|A) * P(A)) / P(B)
    *
    * Where:
    *   - P(A|B) is the probability of event A given that event B has occurred.
    *   - P(B|A) is the probability of event B given that event A has occurred.
    *   - P(A) is the prior probability of event A.
    *   - P(B) is the probability of event B.
    *
    * Example: Suppose we want to find the probability of having a certain disease (A) given that a test result is
    * positive (B). Let:
    *   - P(A) = 0.01 (prior probability of having the disease)
    *   - P(B|A) = 0.9 (probability of a positive test result given that you have the disease)
    *   - P(B) = 0.05 (probability of a positive test result) Then: P(A|B) = (P(B|A) * P(A)) / P(B) = (0.9 * 0.01) /
    *     0.05 = 0.18 This means there is an 18% chance of having the disease given a positive test result.
    *
    * @param probabilityOfBGivenA
    *   The probability of event B given event A.
    * @param probabilityOfA
    *   The prior probability of event A.
    * @param probabilityOfB
    *   The probability of event B.
    * @return
    *   Either an error message or the posterior probability P(A|B).
    */
  def calculatePosteriorProbability(
      probabilityOfBGivenA: Double,
      probabilityOfA: Double,
      probabilityOfB: Double
  ): Either[InvalidInputException, Double] = {
    if probabilityOfA < 0 || probabilityOfA > 1 ||
    probabilityOfB < 0 || probabilityOfB > 1 ||
    probabilityOfBGivenA < 0 || probabilityOfBGivenA > 1 then {
      Left(InvalidInputException("Probabilities must be between 0 and 1."))
    } else if probabilityOfB == 0 then {
      Left(InvalidInputException("Probability of event B cannot be zero."))
    } else {
      Right((probabilityOfBGivenA * probabilityOfA) / probabilityOfB)
    }
  }

}
