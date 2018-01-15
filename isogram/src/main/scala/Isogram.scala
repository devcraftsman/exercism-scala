object Isogram {
  def isIsogram(str: String): Boolean = {
    str.toLowerCase.filter(c => c.isLetter).groupBy(c => c).count(_._2.length > 1) == 0
  }

}
