case class Matrix(data : String) {

  val listOfRows : Vector[Vector[Int]] = data.split("\n").map(s => (s.split("\\s").map(_.toInt).to[Vector])).to[Vector]

  def rows(i: Int) :Vector[Int]= {
    listOfRows.take(i+1).last
  }

  def cols(i: Int) :Vector[Int]= {
    listOfRows.map(v => v.take(i+1).last)
  }


}
