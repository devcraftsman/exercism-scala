import scala.math.BigDecimal.RoundingMode

object SpaceAge {

  type OrbitalPeriod = Double;

  /*
  Earth: orbital period 365.25 Earth days, or 31557600 seconds
  Mercury: orbital period 0.2408467 Earth years
  Venus: orbital period 0.61519726 Earth years
  Mars: orbital period 1.8808158 Earth years
  Jupiter: orbital period 11.862615 Earth years
  Saturn: orbital period 29.447498 Earth years
  Uranus: orbital period 84.016846 Earth years
  Neptune: orbital period 164.79132 Earth years
   */

  val earthPeriod: OrbitalPeriod = 31557600;
  val mercuryPeriod = periodFromOrbitalRatio(0.2408467);
  val venusPeriod = periodFromOrbitalRatio(0.61519726);
  val marsPeriod = periodFromOrbitalRatio(1.8808158);
  val jupiterPeriod = periodFromOrbitalRatio(11.862615);
  val saturnPeriod = periodFromOrbitalRatio(29.447498);
  val uranusPeriod = periodFromOrbitalRatio(84.016846);
  val neptunePeriod = periodFromOrbitalRatio(164.79132)

  def periodFromOrbitalRatio(orbitalRatio: Double): OrbitalPeriod = {
    return earthPeriod * orbitalRatio;
  }

  def getYears(d: Double, planetOrbit: OrbitalPeriod): Double = BigDecimal(d / planetOrbit).setScale(2, RoundingMode.HALF_UP).toDouble


  def onNeptune(d: Double): Double = getYears(d, neptunePeriod);

  def onUranus(d: Double): Double = getYears(d, uranusPeriod)

  def onSaturn(d: Double): Double = getYears(d, saturnPeriod);

  def onJupiter(d: Double): Double = getYears(d, jupiterPeriod)

  def onMars(d: Double): Double = getYears(d, marsPeriod)

  def onVenus(d: Double): Double = getYears(d, venusPeriod)

  def onMercury(d: Double): Double = getYears(d, mercuryPeriod)

  def onEarth(d: Double): Double = getYears(d, earthPeriod)

}
