object ProteinTranslation {

  val terminals: List[String] = List("UAA", "UAG", "UGA")

  val codonsTranslations: Map[String, String] = Map(
    "AUG" -> "Methionine",
    "UUU" -> "Phenylalanine",
    "UUC" -> "Phenylalanine",
    "UUA" -> "Leucine",
    "UUG" -> "Leucine",
    "UCU" -> "Serine",
    "UCC" -> "Serine",
    "UCA" -> "Serine",
    "UCG" -> "Serine",
    "UAU" -> "Tyrosine",
    "UAC" -> "Tyrosine",
    "UGU" -> "Cysteine",
    "UGC" -> "Cysteine",
    "UGG" -> "Tryptophan"
  )

  def translate(str: String): Seq[String] = {

    def translateCodons(codons: List[String]): List[String] = codons match {
      case codon :: _ if isTerminal(codon) => Nil
      case codon :: codons => translateProtein(codon) :: translateCodons(codons)
      case _ => Nil
    }

    translateCodons(str.grouped(3).toList)
  }

  def translateProtein(codon: String): String = codonsTranslations.getOrElse(codon, "")

  def isTerminal(codon: String): Boolean = terminals.contains(codon)

}
