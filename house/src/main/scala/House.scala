object House {

  val start = "This is";

  val lines = List(
    "the house that Jack built.\n\n",
    "the malt\nthat lay",
    "the rat\nthat ate",
    "the cat\nthat killed",
    "the dog\nthat worried",
    "the cow with the crumpled horn\nthat tossed",
    "the maiden all forlorn\nthat milked",
    "the man all tattered and torn\nthat kissed",
    "the priest all shaven and shorn\nthat married",
    "the rooster that crowed in the morn\nthat woke",
    "the farmer sowing his corn\nthat kept",
    "the horse and the hound and the horn\nthat belonged to")


  def verses(i: Int, i1: Int): String = (i to i1).foldLeft("")((acc, index) => acc + verse(index))

  def verse(i: Int): String = (i - 1 to 0 by -1).foldLeft("This is")((acc: String, index: Int) =>
    index match {
      case 0 if i > 1 => acc + " in " + lines(index)
      case _ => acc + " " + lines(index)
    });

}
