package sigma.probability

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import sigma.exception.InvalidInputException

class ConditionalProbabilityTest extends AnyFunSuite with Matchers {

  test("calculateConditionalProbability should return the correct probability for valid inputs") {
    val probabilityOfAandB = 0.2
    val probabilityOfB     = 0.4

    ConditionalProbability.calculateConditionalProbability(probabilityOfAandB, probabilityOfB) shouldBe Right(0.5)
  }

  test("calculateConditionalProbability should return an error for probability of B less than or equal to 0") {
    val probabilityOfAandB = 0.2
    val probabilityOfB     = 0.0

    ConditionalProbability.calculateConditionalProbability(probabilityOfAandB, probabilityOfB) shouldBe Left(
      InvalidInputException("Probability of event B must be between 0 and 1 and greater than 0.")
    )
  }

  test("calculateConditionalProbability should return an error for probability of B greater than 1") {
    val probabilityOfAandB = 0.2
    val probabilityOfB     = 1.2

    ConditionalProbability.calculateConditionalProbability(probabilityOfAandB, probabilityOfB) shouldBe Left(
      InvalidInputException("Probability of event B must be between 0 and 1 and greater than 0.")
    )
  }

  test("calculateConditionalProbability should return an error for probability of A and B less than 0") {
    val probabilityOfAandB = -0.2
    val probabilityOfB     = 0.4

    ConditionalProbability.calculateConditionalProbability(probabilityOfAandB, probabilityOfB) shouldBe Left(
      InvalidInputException("Probability of A and B must be between 0 and 1.")
    )
  }

  test("calculateConditionalProbability should return an error for probability of A and B greater than 1") {
    val probabilityOfAandB = 1.2
    val probabilityOfB     = 0.4

    ConditionalProbability.calculateConditionalProbability(probabilityOfAandB, probabilityOfB) shouldBe Left(
      InvalidInputException("Probability of A and B must be between 0 and 1.")
    )
  }
}
