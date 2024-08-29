package sigma.probability

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import sigma.exception.InvalidInputException

class ComplementProbabilityTest extends AnyFunSuite with Matchers {

  test("calculateComplementProbability should return the correct probability for valid input") {
    val probabilityOfEvent = 0.4

    ComplementProbability.calculateComplementProbability(probabilityOfEvent) shouldBe Right(0.6)
  }

  test("calculateComplementProbability should return an error for negative probability") {
    val probabilityOfEvent = -0.2

    ComplementProbability.calculateComplementProbability(probabilityOfEvent) shouldBe Left(
      InvalidInputException("Probability of the event must be between 0 and 1.")
    )
  }

  test("calculateComplementProbability should return an error for probability greater than 1") {
    val probabilityOfEvent = 1.2

    ComplementProbability.calculateComplementProbability(probabilityOfEvent) shouldBe Left(
      InvalidInputException("Probability of the event must be between 0 and 1.")
    )
  }

  test("calculateComplementProbability should return 1.0 for a probability of 0") {
    val probabilityOfEvent = 0.0

    ComplementProbability.calculateComplementProbability(probabilityOfEvent) shouldBe Right(1.0)
  }

  test("calculateComplementProbability should return 0.0 for a probability of 1") {
    val probabilityOfEvent = 1.0

    ComplementProbability.calculateComplementProbability(probabilityOfEvent) shouldBe Right(0.0)
  }
}
