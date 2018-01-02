object Bob {

  def response(statement: String): String = {
    val s = statement.trim
    if (s.isEmpty) "Fine. Be that way!"
    else if (s.endsWith("?") && !(isYelling(s))) "Sure."
    else if (isYelling(s)) "Whoa, chill out!"
    else "Whatever."

  }

  private def isYelling(statement: String) = {
    val s = statement.replaceAll("[1-9\\s,;:()\\^%\\*\\$@#\\?]", " ");
    s.trim.length > 0 && s.equals(s.toUpperCase)
  }
}