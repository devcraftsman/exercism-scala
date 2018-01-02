object Hamming {
  def distance(str: String, str1: String) :Option[Int] = {
    if (str.length != str1.length) None
    else {
      Some(str.zip(str1).count(t => !t._1.equals(t._2)))
    }
  }
}
