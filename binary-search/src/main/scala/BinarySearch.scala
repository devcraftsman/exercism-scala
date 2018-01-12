object BinarySearch {
  def find(ints: List[Int], i: Int): Option[Int] = {
    if (ints.isEmpty) None
    else find(ints, i, 0)
  }


  def find(ints: List[Int], i: Int, offset: Int): Option[Int] = {
    val localOffset = ints.size / 2
    val check: Int = ints(localOffset)

    ints.splitAt(localOffset) match {
      case (l :: ls, u :: us) if i < check => find(l :: ls, i, offset)
      case (l :: ls, u :: us) if i > check => find(u :: us, i, offset + localOffset)
      // a List(x) can be splitted in (List(),List(x)) forever so the stop condition is that x != i
      case (Nil, x :: Nil) if !x.equals(i) => None
      // or we have found the result
      case _ => Some(localOffset + offset)

    }


  }

}
