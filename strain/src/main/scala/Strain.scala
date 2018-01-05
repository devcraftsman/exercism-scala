object Strain {

  def keep[T](list: Traversable[T], f: T => Boolean): List[T] = {
    (list partition f _1) toList
  }

  def discard[T](list: Traversable[T], f: T => Boolean): List[T] = {
    (list partition f _2) toList
  }


}