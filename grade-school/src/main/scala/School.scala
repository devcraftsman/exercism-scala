

class School {
  type DB = Map[Int, Seq[String]]

  var indb: Map[Int, Seq[String]] = Map.empty

  def add(name: String, g: Int) = indb get g match {
    case Some(s : Seq[String]) =>  indb = indb + (g -> (s :+ name))
    case None => indb = indb + ( g -> Seq(name))
  }

  def init(): DB = Map.empty

  def db: DB = indb

  def grade(g: Int): Seq[String] = indb.get(g).map(_.sorted.reverse).getOrElse(Seq.empty)

  def sorted: DB = {
    val s = indb.toSeq.sortBy(_._1)
    Map(s: _*).mapValues(_.sorted)
  }
}