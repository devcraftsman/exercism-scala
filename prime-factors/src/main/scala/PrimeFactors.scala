object PrimeFactors {

  def factors(i: Int): List[Int] = factors(i.toLong)

  def factors(i: Long): List[Int] = {
    def factorize(n: Long, f: Int): List[Int] = n match {
      case n if (n == 1) => Nil
      case n if (n % f == 0) => f :: factorize(n / f, f)
      case n => factorize(n, f + 1)
    }

    factorize(i, 2)
  }

}
