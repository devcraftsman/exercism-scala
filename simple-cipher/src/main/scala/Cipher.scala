import scala.util.Random

case class Cipher(key : String){

    def encode(plain : String) : String = translate(plain, (_+_))

    def decode(encoded : String) : String = translate(encoded, (_-_))

    private def translate(value :String, acc : (Int,Int) => Int) = value.zipWithIndex.map(translateSingle(_,acc)).mkString

    private def translateSingle(p : (Char,Int), distance : (Int,Int) => Int) : Char = {
        val keyIndex = Cipher.alphabet.indexOf(key.charAt(p._2))
        val charIndex = Cipher.alphabet.indexOf(p._1)
        Cipher.alphabet.charAt(distance(charIndex,keyIndex) % Cipher.alphabet.size)
    }

}


object Cipher {

    private val alphabet = "abcdefghijklmnopqrstuvwxyz"
    private val rnd = new Random()

    def apply(key : Option[String]) = key match {
        case None => new Cipher(generateKey())
        case Some(value) if isValid(value) => new Cipher(value)
        case _ => throw new IllegalArgumentException
    }

    private def generateKey() : String = (1 to 100).map(i => alphabet.charAt(rnd.nextInt(alphabet.size))).mkString

    private def isValid(input : String) : Boolean = !(input.isEmpty) && input.foldLeft(true)((b,c) => b && alphabet.contains(c))


}