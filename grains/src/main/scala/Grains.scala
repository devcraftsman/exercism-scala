object Grains {

  def total: BigInt = (1 to 64).flatMap(square).sum

  def square(i: Int): Option[BigInt] = {
    if (i <= 0 || i > 64) None
    else Some(BigInt(2).pow(i - 1))
  }


}

