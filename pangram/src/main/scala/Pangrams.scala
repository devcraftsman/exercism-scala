object Pangrams {

  def isPangram(input: String): Boolean = {
    val ascii = "abcdefghijklmnopqrstuvwxyz";
    input.toLowerCase.filter(p => ascii.contains(p)).distinct.length == ascii.length
  }
}

