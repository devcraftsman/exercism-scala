object Series {

  /* Manual solution with tail recursion and patternMatching

  def slices(n: Int, str: String) : List[List[Int]]= str match {
      case r if r.length < n => List()
      case s1 => s1.take(n).map(c =>c.asDigit).toList :: slices(n,s1.drop(1))
    } */


  def slices(n: Int, str: String) = {
    str.map(_.asDigit).sliding(n).toList
  }


}
