object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int =  factors.flatMap(f => (1 to (limit-1) / f).map(_ * f)).sum
}

