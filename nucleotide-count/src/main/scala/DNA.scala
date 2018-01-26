case class DNA(sequence: String) {

  val nucleotideCounts = DNA.count(sequence)
}


object DNA {

  def count(sequence: String): Either[Unit, Map[Char, Int]] = {
    val map = sequence.foldLeft(Map('A' -> 0, 'C' -> 0, 'G' -> 0, 'T' -> 0))((m, c) => m + (c -> (m.getOrElse(c, 0) + 1)))
    if (map.keys.filterNot("ACGT".contains(_)).isEmpty) Right(map) else Left()
  }
}





