object Bearing {

  sealed abstract trait Direction {
    def lookLeft() : Direction;
    def lookRight() : Direction
  };

  object North extends Direction {
    override def lookLeft(): Direction =  West
    override def lookRight(): Direction =  East
  }

  object South extends Direction {
    override def lookLeft(): Direction =  East
    override def lookRight(): Direction =  West
  }

  object East extends Direction{
    override def lookLeft(): Direction =  North
    override def lookRight(): Direction =  South
  }

  object West extends Direction{
    override def lookLeft(): Direction =  South
    override def lookRight(): Direction =  North
  }

}
