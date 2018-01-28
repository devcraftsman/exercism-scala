import java.time.{DayOfWeek, LocalDate}

import Schedule.Schedule

case class Meetup(month: Int, year: Int) {

  def day(dayOfWeek: Int, schedule: Schedule): LocalDate = schedule match {
    case Schedule.Teenth => {
      getRelativeDate(dayOfWeek, 13)
    }
    case Schedule.First => {
      getRelativeDate(dayOfWeek, 1)
    }
    case Schedule.Second => {
      getRelativeDate(dayOfWeek, 8)
    }
    case Schedule.Third => {
      getRelativeDate(dayOfWeek, 15)
    }
    case Schedule.Fourth => {
      getRelativeDate(dayOfWeek, 22)
    }
    case Schedule.Last => {
      /* The last weeks start exaclty 6 days before the last daz of the month.
         So after calculating that day we can use the same algorithms as for the other.
       */
      val lastDayOfMonth = LocalDate.of(year, month, 1).plusMonths(1).minusDays(1)
      val firstDayOfLastWeek = lastDayOfMonth.minusDays(6)
      getRelativeDate(dayOfWeek, firstDayOfLastWeek.getDayOfMonth)
    }
  }


  private def getRelativeDate(dayOfWeek: Int, startDay: Int) = {
    val startDate = LocalDate.of(year, month, startDay)
    val startDayOfTheWeek = startDate.getDayOfWeek.getValue;
    // if the desired day of the week is already over I have to check one week later
    if (dayOfWeek < startDayOfTheWeek) startDate.plusDays(7 + dayOfWeek - startDayOfTheWeek)
    // otherwise it is in the same week
    else startDate.plusDays(dayOfWeek - startDayOfTheWeek)
  }
}

object Schedule extends Enumeration {
  type Schedule = Value
  val Teenth, First, Second, Third, Fourth, Last = Value
}

object Meetup {
  val Mon = DayOfWeek.MONDAY.getValue
  val Tue = DayOfWeek.TUESDAY.getValue
  val Wed = DayOfWeek.WEDNESDAY.getValue
  val Thu = DayOfWeek.THURSDAY.getValue
  val Fri = DayOfWeek.FRIDAY.getValue
  val Sat = DayOfWeek.SATURDAY.getValue
  val Sun = DayOfWeek.SUNDAY.getValue
}
