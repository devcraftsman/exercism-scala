object SecretHandshake {
  def commands(secret: Int) : List[String]= {
    val validCommands : List[Command] = List(Wink,DoubleWink,CloseYourEyes,Jump)
    val decripted = validCommands.filter(c => (secret & c.code).equals(c.code)).map(command => command.message)

    // reverse
    if ((secret & 16) != 16){
      decripted
    }else{
      decripted.reverse
    }
  }

}

/*
1 = wink
10 = double blink
100 = close your eyes
1000 = jump


10000 = Reverse the order of the operations in the secret handshake.
 */

sealed abstract class Command(_code: Int, _message:String){
  val code = _code;
  val message = _message
}

object Wink extends Command(1,"wink")
object DoubleWink extends Command(2,"double blink")
object CloseYourEyes extends Command(4,"close your eyes")
object Jump extends Command(8,"jump")
