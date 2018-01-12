object RnaTranscription {

  /*
  * `G` -> `C`
  * `C` -> `G`
  * `T` -> `A`
  * `A` -> `U`
   */

  def toRna(str: String): Option[String] = {
    val op: List[Option[String]] = str.toList.map(transcript(_))
    if (op.contains(None)) None
    else op.foldLeft(None: Option[String])((acc, o) => o.map(s => acc.getOrElse("") + s))
  }

  def transcript(c: Char): Option[String] = c match {
    case 'G' => Some("C")
    case 'C' => Some("G")
    case 'T' => Some("A")
    case 'A' => Some("U")
    case _ => None
  }

}
