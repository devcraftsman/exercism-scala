
object AtbashCipher{

    private val alphabet = "abcdefghijklmnopqrstuvwxyz"

    private val chipher : Map[Char,Char] = alphabet.zip(alphabet.reverse).foldLeft(Map[Char,Char]())(_ + _)

    private def encodeChar(c :Char) : Option[Char] = c.toLower match {
        case c if c.isLetter => chipher.get(c)
        case c if c.isDigit => Some(c)
        case _ => None
        }

    private def isDigitOrLetter(c : Char) : Boolean =  c.isLetter || c.isDigit   

    def encode(s : String) : String = {
        s.filter(isDigitOrLetter)
        .sliding(5,5).map((s) => s.flatMap(encodeChar(_))).mkString(" ") 
    }
    
    def decode(s :String) :  String = s.filter(isDigitOrLetter).flatMap(encodeChar(_))
    
}