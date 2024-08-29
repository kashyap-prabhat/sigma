package sigma.probability

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import sigma.exception.InvalidInputException

class AdditionRuleTest extends AnyFunSuite with Matchers {

  // Tolerance for floating-point comparison
  private val tolerance = 1e-10

  def withinTolerance(expected: Double, actual: Double, tolerance: Double): Boolean = {
    math.abs(expected - actual) <= tolerance
  }

  test("calculateUnionProbability should return the correct probability for valid inputs") {
    val probabilityOfA     = 0.6
    val probabilityOfB     = 0.5
    val probabilityOfAAndB = 0.3

    val result = AdditionRule.calculateUnionProbability(probabilityOfA, probabilityOfB, probabilityOfAAndB)
    result match {
      case Right(value) => withinTolerance(0.8, value, tolerance) shouldBe true
      case Left(error)  => fail(s"Expected a Right but got Left with error: ${error.getMessage}")
    }
  }

  test("calculateUnionProbability should return an error for probabilities less than 0") {
    val probabilityOfA     = -0.1
    val probabilityOfB     = 0.5
    val probabilityOfAAndB = 0.3

    AdditionRule.calculateUnionProbability(probabilityOfA, probabilityOfB, probabilityOfAAndB) shouldBe Left(
      InvalidInputException("Probabilities must be between 0 and 1.")
    )
  }

  test("calculateUnionProbability should return an error for probabilities greater than 1") {
    val probabilityOfA     = 0.6
    val probabilityOfB     = 1.1
    val probabilityOfAAndB = 0.3

    AdditionRule.calculateUnionProbability(probabilityOfA, probabilityOfB, probabilityOfAAndB) shouldBe Left(
      InvalidInputException("Probabilities must be between 0 and 1.")
    )
  }

  test(
    "calculateUnionProbability should return an error for intersection probability greater than individual probabilities"
  ) {
    val probabilityOfA     = 0.6
    val probabilityOfB     = 0.5
    val probabilityOfAAndB = 0.7

    AdditionRule.calculateUnionProbability(probabilityOfA, probabilityOfB, probabilityOfAAndB) shouldBe Left(
      InvalidInputException("Probability of intersection cannot be greater than individual probabilities.")
    )
  }
}
