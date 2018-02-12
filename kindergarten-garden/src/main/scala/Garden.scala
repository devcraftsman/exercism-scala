case class Garden(children: List[String], seeds: String) {

  val sortedChildren = children.sorted

  def plants(child: String): List[Plant] = {

    def childsSeeds(idx: Int) = {
      seeds.split("\n")
        .map(_.grouped(2).toSeq(idx))
        .mkString.map(c => Plant.decode(c))
    }

    sortedChildren.zipWithIndex.filter(_._1.equals(child))
      .flatMap(p => childsSeeds(p._2))

  }

}


object Garden {

  val children = List("Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry")

  def defaultGarden(seeds: String): Garden = new Garden(children, seeds)

}
