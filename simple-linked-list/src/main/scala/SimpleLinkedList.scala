

trait SimpleLinkedList[T] {
  def isEmpty: Boolean
  def value: T
  def add(item: T): SimpleLinkedList[T]
  def next: SimpleLinkedList[T]
  def reverse: SimpleLinkedList[T]
  def toSeq: Seq[T]
}

case class Terminal[T]() extends SimpleLinkedList[T]{
  def isEmpty: Boolean = true
  def value: T = throw new UnsupportedOperationException("Terminal has no value")
  def add(item: T): SimpleLinkedList[T] = Element(item, this)
  def next: SimpleLinkedList[T] = throw new UnsupportedOperationException("Terminal has no child")
  def reverse: SimpleLinkedList[T] = this
  def toSeq: Seq[T] = Seq()
}


case class Element[T](private val _elm : T, private val _next : SimpleLinkedList[T]) extends SimpleLinkedList[T] {

  def add(item: T): SimpleLinkedList[T] = Element(_elm, _next.add(item))
  def isEmpty: Boolean =  false
  def next: SimpleLinkedList[T] = _next 
  def reverse: SimpleLinkedList[T] =  SimpleLinkedList.fromSeq(this.toSeq.reverse)
  def toSeq: Seq[T] = Seq(_elm) ++ _next.toSeq
  def value: T = _elm

}




object SimpleLinkedList{

  def apply[T]() : SimpleLinkedList[T] = Terminal()

  def apply[T](t :T ) : SimpleLinkedList[T] = Element(t,Terminal())

  def apply[T](xs : T*) : SimpleLinkedList[T] = fromSeq(xs)


  /*
    @see: https://stackoverflow.com/questions/10199171/matcherror-when-match-receives-an-indexedseq-but-not-a-linearseq
    Because you cannot use :: with vector and test generators use vectors
    */
  object +: {
    def unapply[T](s: Seq[T]) =
      s.headOption.map(head => (head, s.tail))
  }

  def fromSeq[T](xs : Seq[T]) : SimpleLinkedList[T] =  xs match {
    case Nil => Terminal()
    case head +: tl => Element(head,fromSeq(tl))
  }

}




