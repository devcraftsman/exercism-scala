
case class Triangle(private val typ: TriangleType) {

  val equilateral: Boolean = typ.equals(Equilateral)

  val isosceles: Boolean = typ.equals(Isosceles) || typ.equals(Equilateral)

  val scalene: Boolean = typ.equals(Scalene)
}


object Triangle {

  def apply(l1: Double, l2: Double, l3: Double): Triangle = {
    if (
      l1 == 0 || l2 == 0 || l3 == 0
        || l1 + l2 < l3
        || l2 + l3 < l1
        || l1 + l3 < l2
    ) new Triangle(Invalid)
    else if (!l1.equals(l2) && !l2.equals(l3) && !l1.equals(l3)) new Triangle(Scalene)
    else if (l1.equals(l2) && l2.equals(l3)) new Triangle(Equilateral)
    else new Triangle(Isosceles)
  }

}




