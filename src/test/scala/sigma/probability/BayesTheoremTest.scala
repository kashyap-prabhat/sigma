package sigma.probability

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import sigma.exception.InvalidInputException

class BayesTheoremTest extends AnyFunSuite with Matchers {

  // Tolerance for floating-point comparison
  private val tolerance = 1e-10

  def withinTolerance(expected: Double, actual: Double, tolerance: Double): Boolean = {
    math.abs(expected - actual) <= tolerance
  }

  test("calculatePosteriorProbability should return the correct probability for valid inputs") {
    val probabilityOfBGivenA = 0.9
    val probabilityOfA       = 0.01
    val probabilityOfB       = 0.05

    val result = BayesTheorem.calculatePosteriorProbability(probabilityOfBGivenA, probabilityOfA, probabilityOfB)
    result match {
      case Right(value) => withinTolerance(0.18, value, tolerance) shouldBe true
      case Left(error)  => fail(s"Expected a Right but got Left with error: ${error.getMessage}")
    }
  }

  test("calculatePosteriorProbability should return an error for probabilities less than 0") {
    val probabilityOfBGivenA = -0.1
    val probabilityOfA       = 0.01
    val probabilityOfB       = 0.05

    BayesTheorem.calculatePosteriorProbability(probabilityOfBGivenA, probabilityOfA, probabilityOfB) shouldBe Left(
      InvalidInputException("Probabilities must be between 0 and 1.")
    )
  }

  test("calculatePosteriorProbability should return an error for probabilities greater than 1") {
    val probabilityOfBGivenA = 1.1
    val probabilityOfA       = 0.01
    val probabilityOfB       = 0.05

    BayesTheorem.calculatePosteriorProbability(probabilityOfBGivenA, probabilityOfA, probabilityOfB) shouldBe Left(
      InvalidInputException("Probabilities must be between 0 and 1.")
    )
  }

  test("calculatePosteriorProbability should return an error for zero probability of B") {
    val probabilityOfBGivenA = 0.9
    val probabilityOfA       = 0.01
    val probabilityOfB       = 0.0

    BayesTheorem.calculatePosteriorProbability(probabilityOfBGivenA, probabilityOfA, probabilityOfB) shouldBe Left(
      InvalidInputException("Probability of event B cannot be zero.")
    )
  }
}
