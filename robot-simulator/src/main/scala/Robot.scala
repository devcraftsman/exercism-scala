import Bearing._

case class Robot(bearing: Direction,coordinates: (Int,Int)){


  def turnRight() : Robot = {
    Robot(bearing.lookRight(),coordinates)
  }

  def turnLeft() : Robot = {
    Robot(bearing.lookLeft(),coordinates)
  }

  def advance() : Robot = this.bearing match {
    case East=> Robot(East,(this.coordinates._1+1,this.coordinates._2))
    case West=> Robot(West,(this.coordinates._1-1,this.coordinates._2))
    case North =>  Robot(North,(this.coordinates._1,this.coordinates._2+1))
    case South =>  Robot(South,(this.coordinates._1,this.coordinates._2-1))
  }

  def applyDirection(prev: Robot, c: Char): Robot = c match  {
    case 'A' =>  prev.advance();
    case 'L' => prev.turnLeft();
    case 'R' => prev.turnRight()
  }

  def simulate(directions :String) = {
    directions.foldLeft(this)((prev,c) =>applyDirection(prev,c))
  }

}