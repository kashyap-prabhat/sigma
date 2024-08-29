package sigma.probability

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import sigma.exception.InvalidInputException

class MultiplicationRuleTest extends AnyFunSuite with Matchers {

  // Tolerance for floating-point comparison
  private val tolerance = 1e-10

  def withinTolerance(expected: Double, actual: Double, tolerance: Double): Boolean = {
    math.abs(expected - actual) <= tolerance
  }

  test("calculateIntersectionProbability should return the correct probability for valid inputs") {
    val probabilityOfA = 0.4
    val probabilityOfB = 0.5

    val result = MultiplicationRule.calculateIntersectionProbability(probabilityOfA, probabilityOfB)
    result match {
      case Right(value) => withinTolerance(0.2, value, tolerance) shouldBe true
      case Left(error)  => fail(s"Expected a Right but got Left with error: ${error.getMessage}")
    }
  }

  test("calculateIntersectionProbability should return an error for probabilities less than 0") {
    val probabilityOfA = -0.1
    val probabilityOfB = 0.5

    MultiplicationRule.calculateIntersectionProbability(probabilityOfA, probabilityOfB) shouldBe Left(
      InvalidInputException("Probabilities must be between 0 and 1.")
    )
  }

  test("calculateIntersectionProbability should return an error for probabilities greater than 1") {
    val probabilityOfA = 0.4
    val probabilityOfB = 1.1

    MultiplicationRule.calculateIntersectionProbability(probabilityOfA, probabilityOfB) shouldBe Left(
      InvalidInputException("Probabilities must be between 0 and 1.")
    )
  }
}
