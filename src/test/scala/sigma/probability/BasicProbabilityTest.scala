package sigma.probability

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import sigma.exception.InvalidInputException

class BasicProbabilityTest extends AnyFunSuite with Matchers {

  test("calculateProbability should return the correct probability for valid inputs") {
    val favorableOutcomes = 3
    val totalOutcomes     = 10

    BasicProbability.calculateProbability(favorableOutcomes, totalOutcomes) shouldBe Right(0.3)
  }

  test("calculateProbability should return an error when total outcomes is zero") {
    val favorableOutcomes = 3
    val totalOutcomes     = 0

    BasicProbability.calculateProbability(favorableOutcomes, totalOutcomes) shouldBe Left(
      InvalidInputException("Total number of outcomes must be greater than zero.")
    )
  }

  test("calculateProbability should return an error when total outcomes is negative") {
    val favorableOutcomes = 3
    val totalOutcomes     = -5

    BasicProbability.calculateProbability(favorableOutcomes, totalOutcomes) shouldBe Left(
      InvalidInputException("Total number of outcomes must be greater than zero.")
    )
  }

  test("calculateProbability should return probability as 1 for favorable outcomes equal to total outcomes") {
    val favorableOutcomes = 5
    val totalOutcomes     = 5

    BasicProbability.calculateProbability(favorableOutcomes, totalOutcomes) shouldBe Right(1.0)
  }

  test("calculateProbability should return probability as 0 for zero favorable outcomes") {
    val favorableOutcomes = 0
    val totalOutcomes     = 10

    BasicProbability.calculateProbability(favorableOutcomes, totalOutcomes) shouldBe Right(0.0)
  }
}
