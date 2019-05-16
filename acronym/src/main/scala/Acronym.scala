import scala.util.matching.Regex
object Acronym {
  def abbreviate(phrase: String): String = {
    val pattern : Regex = """(\w)[\'\w*|\w*]*\W*""".r
    pattern.replaceAllIn(phrase, m => (m.group(1).toUpperCase()))
  }
}
