object Grains {

  def total: BigInt = (1 to 64).map(i => square(i)).foldLeft(BigInt(0))((acc, b) => b.map(_ + acc).getOrElse(0))

  def square(i: Int): Option[BigInt] = {
    if (i <= 0 || i > 64) None
    else Some(BigInt(2).pow(i - 1))
  }


}

