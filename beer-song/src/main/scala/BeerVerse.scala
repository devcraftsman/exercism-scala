

case class BeerVerse(private val _actual: Int, private val _verseTemplate: String) {

  val play: String = if (_actual > 0) _verseTemplate.replaceAll("%current%", _actual.toString).replaceAll("%next%", (_actual - 1).toString) else _verseTemplate
}

object BeerVerse {

  val common = "%current% bottles of beer on the wall, %current% bottles of beer.\nTake one down and pass it around, %next% bottles of beer on the wall.\n"

  val verse2 = "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n"

  val verse1 = "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n"

  val verse0 = "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"

  def apply(verse: Int) = verse match {
    case 0 => new BeerVerse(-1, verse0)
    case 1 => new BeerVerse(-1, verse1)
    case 2 => new BeerVerse(-1, verse2)
    case v => new BeerVerse(v, common)
  }

}
