object Strain {

  def keep[T](list: Traversable[T], f: T => Boolean): List[T] = {
    (splitOnCondition(list, f) _1) toList
  }

  def discard[T](list: Traversable[T], f: T => Boolean): List[T] = {
    (splitOnCondition(list, f) _2) toList
  }

  private def splitOnCondition[T](list: Traversable[T], f: T => Boolean) = {
    list partition f
  }


}