object FlattenArray {

  def flatten(ls: List[Any]): List[Any] = ls match {
    case (y :: ys) :: yss => flatten(y :: ys) ::: flatten(yss)
    case null :: ys => flatten(ys)
    case y :: ys => y :: flatten(ys)
    case _ => Nil
  }

}
