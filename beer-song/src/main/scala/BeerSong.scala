
object BeerSong {

  def verses(first: Int, last: Int): String = (first to last by -1) map verse mkString "\n"

  def verse(i: Int): String = BeerVerse(i).play
}

