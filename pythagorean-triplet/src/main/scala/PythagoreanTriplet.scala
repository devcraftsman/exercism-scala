object PythagoreanTriplet {
  def pythagoreanTriplets(i: Int, i1: Int): Seq[(Int, Int, Int)] = {
    for {
      t1 <- Range.inclusive(i, i1)
      t2 <- Range.inclusive(t1, i1)
      t3 <- Range.inclusive(t2, i1) if isPythagorean((t1, t2, t3))
    } yield (t1, t2, t3)
  }

  def isPythagorean(tuple: (Int, Int, Int)): Boolean = (math.pow(tuple._1, 2) + math.pow(tuple._2, 2) == math.pow(tuple._3, 2)) ||
    (math.pow(tuple._1, 2) + math.pow(tuple._3, 2) == math.pow(tuple._2, 2)) ||
    (math.pow(tuple._3, 2) + math.pow(tuple._2, 2) == math.pow(tuple._1, 2))


}
