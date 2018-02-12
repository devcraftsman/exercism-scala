sealed trait Plant {
  def value: String
}

class Violets extends Plant {
  override def value: String = "V"
}

class Clover extends Plant {
  override def value: String = "C"
}

class Radishes extends Plant {
  override def value: String = "R"
}

class Grass extends Plant {
  override def value: String = "G"
}


object Plant {

  val Violets = new Violets
  val Clover = new Clover
  val Radishes = new Radishes
  val Grass = new Grass

  val plants = List(Clover, Violets, Radishes, Grass)

  def decode(c: Char): Plant = c match {
    case 'V' => Violets
    case 'C' => Clover
    case 'R' => Radishes
    case 'G' => Grass
    case cc => throw new IllegalArgumentException(s"Invalid plant value ${cc}")
  }

}
