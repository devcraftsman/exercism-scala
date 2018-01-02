object Etl {
  def transform(m: Map[Int, Seq[String]]) : Map[String,Int] = {
    m.flatMap( e => e._2.map(v =>(v.toLowerCase -> e._1)))
  }

}
