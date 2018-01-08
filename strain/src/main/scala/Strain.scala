object Strain {

  def keep[T](traversable: Traversable[T], f: T => Boolean): List[T] = filter(traversable, f)

  def discard[T](traversable: Traversable[T], f: T => Boolean): List[T] = filter(traversable, (x: T) => !f(x))


  private def filter[A](traversable: Traversable[A], test: A => Boolean): List[A] = traversable match {
    case x :: Nil if test(x) => List(x)
    case x :: xs if test(x) => x :: filter(xs, test)
    case _ :: xs => filter(xs, test)
    case _ => List.empty[A]
  }


}