object Raindrops {


  def convert(n: Int): String = dropping(n) match {
    case "" => n.toString
    case s => s
  }

  def dropping(n: Int): String = {

    def toDrop(i: Int): String = i match {
      case 3 => "Pling"
      case 5 => "Plang"
      case 7 => "Plong"
      case _ => ""
    }

    List(3, 5, 7) filter (p => n % p == 0) map toDrop mkString
  }


}

