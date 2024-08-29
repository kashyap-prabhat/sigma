package sigma.probability

import sigma.exception.InvalidInputException

object ConditionalProbability {

  /**
    * Calculates the conditional probability of event A given that event B has occurred.
    *
    * The formula used is:
    *
    * P(A|B) = P(A ∩ B) / P(B)
    *
    * Where:
    *   - P(A|B) is the probability of event A given that event B has occurred.
    *   - P(A ∩ B) is the joint probability that both events A and B occur.
    *   - P(B) is the probability of event B.
    *
    * This method calculates the probability of A occurring given that B has already happened. It is useful in scenarios
    * where you want to understand how the probability of one event is influenced by the occurrence of another event.
    *
    * For example:
    *   - Suppose you have a deck of cards, and you want to find the probability of drawing a heart (event A) given that
    *     the card drawn is red (event B). If the probability of drawing a red card (event B) is 0.5 and the probability
    *     of drawing a heart (event A ∩ B) is 0.25, then:
    *
    * P(A|B) = P(A ∩ B) / P(B) = 0.25 / 0.5 = 0.5
    *
    * @param probabilityOfAandB
    *   The probability of both A and B occurring.
    * @param probabilityOfB
    *   The probability of event B occurring.
    * @return
    *   Either an error message or the conditional probability P(A|B).
    */
  def calculateConditionalProbability(
      probabilityOfAandB: Double,
      probabilityOfB: Double
  ): Either[InvalidInputException, Double] = {
    if probabilityOfB <= 0 || probabilityOfB > 1 then {
      Left(InvalidInputException("Probability of event B must be between 0 and 1 and greater than 0."))
    } else if probabilityOfAandB < 0 || probabilityOfAandB > 1 then {
      Left(InvalidInputException("Probability of A and B must be between 0 and 1."))
    } else {
      Right(probabilityOfAandB / probabilityOfB)
    }
  }

}
