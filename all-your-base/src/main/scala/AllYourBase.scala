object AllYourBase {
  def rebase(startBase: Int, repr: List[Int], endBase: Int): Option[List[Int]] = {
    if (startBase <= 1 || repr.isEmpty || repr.head == 0
      || !repr.filter(_ < 0).isEmpty || !repr.filter(_ >= startBase).isEmpty
      || endBase <= 1) {
      None
    } else {
      val decimal = encodeToDecimal(startBase, repr);
      val decoded = decodeFromDecimal(decimal, endBase)
      Some(decoded)
    }


  }

  def encodeToDecimal(startBase: Int, repr: List[Int]): Int = {
    repr.reverse.zipWithIndex.map(p => {
      p._1 * Math.pow(startBase, p._2).toInt
    }).sum
  }

  def decodeFromDecimal(decimal: Int, endBase: Int): List[Int] = {

    def decode(q: Int, b: Int): List[Int] = q match {
      case n if (n == 0) => Nil
      case n => decode(n / b, b) :+ n % b
    }

    decode(decimal, endBase);


  }

}
