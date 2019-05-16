import java.{util => ju}
import scala.util.matching.Regex

object RunLengthEncoding {

    def encode(original: String) : String = original match {
        case "" => ""
        case _ => {
            val span = original.span((c :Char) => c.equals(original.head));
            val formatted : String = if (span._1.size == 1) span._1 else span._1.size.toString() + span._1.head
            if (span._2.isEmpty()) formatted
            else formatted ++ encode(span._2)
        }   
    }

    def decode(original: String) : String = {
        def decodePattern(m : Regex.Match) : String = {
            if (m.group(2)!= null)  m.group(3) * (m.group(2).toInt)
            else m.group(1)
        }

        def pattern = """((\d{1,})([a-zA-Z]|\s)|([a-zA-Z]|\s))""".r
        pattern.replaceAllIn(original, decodePattern(_))
    }
}