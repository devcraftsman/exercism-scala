import scala.collection.mutable

/**
  * Created by devcraftsman on 12/29/17.
  * ----------------------------------------------------
  * This software is licensed under the Apache 2 license
  * see: [http://www.apache.org/licenses/LICENSE-2.0]
  **/
object BookStore {

  val cost: Double = 8.0;


  /**
    * Calculate discount % based from number of distinct books
    * @param i
    * @return
    */
  def calculateDiscount(i: Int) = i match {
    case 2 => 0.05
    case 3 => 0.10
    case 4 => 0.20
    case 5 => 0.25
    case _ => 0.0
  }

  /**
    * The price of a list of books can be calculated with:
    *
    *   the sum of distinct groups of books (with discount) + the sum of "duplicate" books (without discount)
    * @param books
    * @return
    */
  def getListPrice(books: List[Int]): Double = books match {
    case x :: Nil => cost
    case x :: xs => {
      val distinct = books.distinct // for discount
      val duplicates = books.diff(distinct) //for full price
      cost * duplicates.size + cost * distinct.size * (1-calculateDiscount(distinct.size))
    }
    case _ => 0.0

  }


  /**
    * To get the total cost split the book list in all the possible combination of groups
    * then sum up each combination costs and choose the minimum.
    * @param books
    * @return
    */
  def total(books: List[Int]): Double = {
    if (books.isEmpty) {
      0.0
    }else{
      val groups :List[List[List[Int]]] = bookPairs(books);
      groups.map(ll =>
        ll.foldLeft(0.0)((c,l) => c + getListPrice(l))
      ).min
    }


  }

  /**
    * The splitting algorith:
    *  1 - if does not exists a group, create a new group (duplicates could never appear in the same group)
    *  2 - if exists a group, that does not contains the book, and it is smaller that the maxLenght, add the book
    *  3 - repeat with all the existing groups
    *  4 - fold all the groups together to get the actual partition of the original book list
    *
    * @param books
    * @param maxL
    * @return
    */
  def splitBooks(books: List[Int], maxL: Int) : List[List[Int]]= {

    def divideElements(b: Int, ll: List[List[Int]]) : List[List[Int]] =
      ll match {
        case Nil => List(b) :: ll
        case x :: xs if (!x.contains(b) && x.size < maxL) => (b :: x) :: xs
        case x :: xs =>  x :: divideElements(b,xs)
    }

    books.foldLeft((List[List[Int]]()))((ll, b) => {
      divideElements(b, ll)
    })
  }

  /**
    * List all the possible groups in which you can divide the book list for each length from 1 to books.length
    * @param books
    * @return
    */
  def bookPairs(books: List[Int]): List[List[List[Int]]] = {
    (1 to books.length).map(len =>splitBooks(books, len)).toList

  }

}
