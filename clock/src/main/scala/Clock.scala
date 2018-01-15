import java.time.{Duration, LocalTime}

case class Clock(private val _time: LocalTime) {

  def +(clock: Clock) = Clock.compose(this, clock, _ + _)

  def -(clock: Clock) = Clock.compose(this, clock, _ - _)

}

object Clock {

  def compose(clock: Clock, clock1: Clock, combine: (Int, Int) => Int): Clock = Clock(combine(clock._time.getHour, clock1._time.getHour), combine(clock._time.getMinute, clock1._time.getMinute))

  def apply(hour: Int, minutes: Int): Clock = {
    /* Because LocalTime.of(hours,minutes) check that hours =< 24 and minutes =<60
      while LocalTime.plus accept any long and calculate exact time by itself
     */
    val time: LocalTime = LocalTime.of(0, 0)
    val hoursDuration: Duration = Duration.ofHours(hour);
    val minutesDuration: Duration = Duration.ofMinutes(minutes)
    new Clock(time.plus(hoursDuration).plus(minutesDuration));
  }

  def apply(minutes: Int): Clock = {
    Clock(0, minutes);
  }
}
