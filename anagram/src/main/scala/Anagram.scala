object Anagram {
  def anagrams(str: String, anagrams: List[String]): List[String] = {

    def isAnagramOf(anagram: String, original: String) = {
      val name = original.toLowerCase
      var lower = anagram.toLowerCase
      lower.diff(name).isEmpty && name.diff(lower).isEmpty && !lower.equals(name)
    }

    for {
      anagram <- anagrams; if (isAnagramOf(anagram, str))
    } yield anagram
  }

}

