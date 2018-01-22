case class WordCount(str: String) {

  val countwords: Map[String, Int] = WordCount.count(str)

}


object WordCount {

  val word = "(\\w+\\'?\\w+)|\\d+".r // a word (possibly with aphostrophe) or a number

  def count(phrase: String): Map[String, Int] = word
    .findAllIn(phrase.toLowerCase).toSeq
    .groupBy(s => s).mapValues(_.size)
}
