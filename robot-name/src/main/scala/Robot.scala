
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

case class Robot() {

  var name = "";

  def reset() = {
    name = Robot.newName()
  }

  reset()


}

object Robot {

  val robots: ArrayBuffer[String] = {
    val names = for {
      c1 <- (65 to 90).map(i => i.toChar)
      c2 <- (65 to 90).map(i => i.toChar)
      i1 <- (0 to 9)
      i2 <- (0 to 9)
      i3 <- (0 to 9)
    } yield "" + c1 + c2 + i1 + i2 + i3

    ArrayBuffer() ++ names
  }

  def newName(): String = {
    val index = Random.nextInt(robots.size)
    val name = robots(index)
    robots.remove(index)
    name
  }
}
