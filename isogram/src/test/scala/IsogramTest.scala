import org.scalatest.{FunSuite, Matchers}

/** @version 1.1.0 */
class IsogramTest extends FunSuite with Matchers {

  test("empty string") {
    Isogram.isIsogram("") should be(true)
  }

  test("isogram with only lower case characters") {
    Isogram.isIsogram("isogram") should be(true)
  }

  test("word with one duplicated character") {

    Isogram.isIsogram("eleven") should be(false)
  }

  test("longest reported english isogram") {

    Isogram.isIsogram("subdermatoglyphic") should be(true)
  }

  test("word with duplicated character in mixed case") {

    Isogram.isIsogram("Alphabet") should be(false)
  }

  test("hypothetical isogrammic word with hyphen") {

    Isogram.isIsogram("thumbscrew-japingly") should be(true)
  }

  test("isogram with duplicated non letter character") {

    Isogram.isIsogram("Hjelmqvist-Gryb-Zock-Pfund-Wax") should be(true)
  }

  test("made-up name that is an isogram") {

    Isogram.isIsogram("Emily Jung Schwartzkopf") should be(true)
  }

  test("duplicated character in the middle") {

    Isogram.isIsogram("accentor") should be(false)
  }
}