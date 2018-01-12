object Sieve {
  def primes(i: Int): List[Int] = {
    primes((2 to i).toList)
  }

  def primes(remains: List[Int]): List[Int] = remains match {
    /*
      At each run the we take the first element (because it is alway prime) and remove all its multiples.
      multiple of x that are <= l are calculate in the worst case by x * [1 .. l/x + 1)]
      where l is always the last element of the actual range
     */
    case x :: xs => x :: primes(remains.diff((1 to remains.last / x + 1).map(_ * x)))
    // if empty return
    case _ => Nil
  }


}
