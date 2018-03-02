object PascalsTriangle {

  def rows(dim: Int): List[List[Int]] = {

    def calculateElement(prec: List[Int], i: Int) = i match {
      case n if (n == 0 || n == prec.size) => 1
      case n => prec(n) + prec(n - 1)
    }

    def calculateRow(prec: List[Int]): List[Int] = prec.size match {
      case 0 => List(1)
      case 1 => List(1, 1)
      case index => {
        Range.inclusive(0, index).map(i => calculateElement(prec, i))
          .foldLeft(List(): List[Int])((acc, num) => num :: acc)
      }
    }

    Range(0, dim).foldLeft(List(): List[List[Int]])((acc, _) => {
      acc :+ calculateRow(acc.lastOption.getOrElse(List()))

    })


  }
}
