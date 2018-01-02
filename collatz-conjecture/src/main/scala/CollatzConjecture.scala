object CollatzConjecture {


  def steps(i: Int) = {
    def process(t: (Int, Int)) : (Int,Int)= t match {
      case (_,1) => t
      case(i,x) if (x % 2 == 0) => process((i+1,x/2))
      case(i,x) if (x % 2 != 0) => process((i+1,x*3+1))
    }

    if (i<= 0) None
    else {
      val t = (0,i)
      Option(process(t)._1);

    }
  }

}
