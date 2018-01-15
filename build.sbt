
lazy val commonSettings = Seq(
  scalaVersion := "2.12.1",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)


lazy val accumulate = (project in file("accumulate"))
  .settings(
    commonSettings
  )


lazy val bob = (project in file("bob"))
  .settings(
    commonSettings
  )

lazy val binarySearch = (project in file("binary-search"))
  .settings(
    commonSettings
  )


lazy val bookStore = (project in file("book-store"))
  .settings(
    commonSettings
  )

lazy val collatzConjecture = (project in file("collatz-conjecture"))
  .settings(
    commonSettings
  )

lazy val differenceOfSquares = (project in file("difference-of-squares"))
  .settings(
    commonSettings
  )



lazy val etl = (project in file("etl"))
  .settings(
    commonSettings
  )

lazy val flattenArray = (project in file("flatten-array"))
  .settings(
    commonSettings
  )

lazy val gigasecond = (project in file("gigasecond"))
  .settings(
    commonSettings
  )

lazy val gradeSchool = (project in file("grade-school"))
  .settings(
    commonSettings
  )

lazy val grains = (project in file("grains"))
  .settings(
    commonSettings
  )

lazy val hamming = (project in file("hamming"))
  .settings(
    commonSettings
  )

lazy val helloWorld = (project in file("hello-world"))
  .settings(
    commonSettings
  )

lazy val isogram = (project in file("isogram"))
  .settings(
    commonSettings
  )





lazy val leap = (project in file("leap"))
  .settings(
    commonSettings
  )

lazy val matrix = (project in file("matrix"))
  .settings(
    commonSettings
  )

lazy val pangram = (project in file("pangram"))
  .settings(
    commonSettings
  )

lazy val perfectNumbers = (project in file("perfect-numbers"))
  .settings(
    commonSettings
  )

lazy val phoneNumber = (project in file("phone-number"))
  .settings(
    commonSettings
  )

lazy val raindrops = (project in file("raindrops"))
  .settings(
    commonSettings
  )

lazy val rnaTranscription = (project in file("rna-transcription"))
  .settings(
    commonSettings
  )


lazy val robotName = (project in file("robot-name"))
  .settings(
    commonSettings
  )

lazy val robotSimulator = (project in file("robot-simulator"))
  .settings(
    commonSettings
  )

lazy val scrabbleScore = (project in file("scrabble-score"))
  .settings(
    commonSettings
  )

lazy val secretHandshake = (project in file("secret-handshake"))
  .settings(
    commonSettings
  )

lazy val sieve = (project in file("sieve"))
  .settings(
    commonSettings
  )


lazy val spaceAge = (project in file("space-age"))
  .settings(
    commonSettings
  )

lazy val strain = (project in file("strain"))
  .settings(
    commonSettings
  )

lazy val sumOfMultiples = (project in file("sum-of-multiples"))
  .settings(
    commonSettings
  )

lazy val triangle = (project in file("triangle"))
  .settings(
    commonSettings
  )

