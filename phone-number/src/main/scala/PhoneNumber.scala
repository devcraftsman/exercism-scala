object PhoneNumber {

  private val phoneNumber = "^(?:\\+?1)?\\s*\\(?([2-9]\\d{2})\\)?(?:\\.|-|\\s*)([2-9]\\d{2})(?:\\.|-|\\s*)(\\d{4})\\s*$".r

  def clean(str: String): Option[String] = str match {
    case phoneNumber(areaCode, exchangeCode, subscriberNumber) => Some(areaCode + exchangeCode + subscriberNumber)
    case _ => None
  }

}
