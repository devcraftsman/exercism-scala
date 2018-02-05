import Allergen.Allergen

object Allergies {
  def list(i: Int): List[Allergen] = Allergen.allergens.filter(allergicTo(_, i))


  def allergicTo(allergen: Allergen, i: Int): Boolean = (i & allergen) == allergen

}
