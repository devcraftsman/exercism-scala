class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = for {elm <- list} yield f(elm)
}
