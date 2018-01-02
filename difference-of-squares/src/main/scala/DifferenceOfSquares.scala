
object DifferenceOfSquares {

  def differenceOfSquares(n: Int): Int = squareOfSum(n) - sumOfSquares(n)

  def sumOfSquares(n: Int): Int = 1 to n map (i => i * i) sum

  def squareOfSum(n: Int): Int = scala.math.pow(1 to n sum, 2).toInt
}
