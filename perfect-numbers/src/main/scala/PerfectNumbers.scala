import NumberType.{Abundant, Deficient, Perfect}

object PerfectNumbers {
  def sumFactors(i: Int) : Int= {
    var s = 0
    for (n <- Range(1,i))  {
      if (i % n == 0) s += n
    }
     s
  }


  def classify(i: Int) : Either[String,NumberType]= i match {
    case _ if i <= 0 => Left("Classification is only possible for natural numbers.")
    case _ if i == sumFactors(i) => Right(Perfect)
    case _ if i < sumFactors(i) => Right(Abundant)
    case _ if i > sumFactors(i) => Right(Deficient)
  }


}


