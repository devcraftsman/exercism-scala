
object RomanNumerals{

    val dict : List[(Int,String)] = List((1000,"M"),(900, "CM"),(500,"D"),(400, "CD"),(100,"C"),(90,"XC"),
    (50,"L"),(40,"XL"),(10,"X"),(9,"IX"),(5,"V"),(4,"IV"),(1,"I"))

    def roman(num : Int) : String = {
        def toRoman(n : Int, ds: List[(Int,String)]) : String = ds match {
            case Nil => ""
            case _ => {
                val d = ds.head;
                d._2 * (n / d._1) + toRoman(n % d._1, ds.tail) 
            }
        }
        toRoman(num, dict)
    }
}