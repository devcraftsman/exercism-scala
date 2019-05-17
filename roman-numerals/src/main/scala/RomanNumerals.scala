
object RomanNumerals{

    val dicts : List[(Int,String)] = List((1000,"M"),(900, "CM"),(500,"D"),(400, "CD"),(100,"C"),(90,"XC"),
    (50,"L"),(40,"XL"),(10,"X"),(9,"IX"),(5,"V"),(4,"IV"),(1,"I"))

    def roman(num : Int) : String = {
        dicts.foldLeft("",num)((acc,dict) => {
            val elm = dict._2 * (acc._2 / dict._1)
            (acc._1 + elm, acc._2 % dict._1)
         }
        )._1        
    }
}