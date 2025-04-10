package sandyb;

public class W06 {
	// katanya ga boleh extend karena circular dependency
//	public static class Date extends DateTime {
	public static class Date {
		private int year;
		private int month;
		private int day;

		public Date(int year, int month, int date) {
			this.year = year;
			this.month = month;
			day = date;
		}

		public int getYear() {
			return year;
		}

		public int getMonth() {
			return month;
		}

		public int getDay() {
			return day;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public void addYears(int yearsToAdd) {
			this.year += yearsToAdd;
		}

		public void addMonths(int monthsToAdd) {
			this.month += monthsToAdd;
		}

		public void addDays(int daysToAdd) {
			this.day += daysToAdd;
		}

		@Override
		public String toString() {
			return year + "/" + (month < 10 ? "0" + month : month) + "/" + (day < 10 ? "0" + day : day);
		}

//		@Override
//		public void setDate(int year, int month, int day) {
//			this.year = year;
//			this.month = month;
//			this.day = day;
//		}

		public void addDate(int daysToAdd, int monthsToAdd, int yearsToAdd) {
			this.year += yearsToAdd;
			this.month += monthsToAdd;
			this.day += daysToAdd;
		}
	}

	// katanya ga boleh extend karena circular dependency
//	public static class Time extends DateTime {
	public static class Time {
		private int hour;
		private int minute;
		private int second;

		public Time(int hour, int minute, int second) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}

		public int getHour() {
			return hour;
		}

		public int getMinute() {
			return minute;
		}

		public int getSecond() {
			return second;
		}

		public void setHour(int hour) {
			this.hour = hour;
		}

		public void setMinute(int minute) {
			this.minute = minute;
		}

		public void setSecond(int second) {
			this.second = second;
		}

		public void addHours(int hoursToAdd) {
			addTime(hoursToAdd, 0, 0);
//			this.hour += hoursToAdd;
		}

		public void addMinutes(int minutesToAdd) {
			addTime(0, minutesToAdd, 0);
//			this.minute += minutesToAdd;
		}

		public void addSeconds(int secondsToAdd) {
			addTime(0, 0, secondsToAdd);
//			this.second += secondsToAdd;
		}

		@Override
		public String toString() {
			return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute) + ":"
					+ (second < 10 ? "0" + second : second);
		}

//		@Override
//		public void setTime(int hour, int minute, int second) {
//			this.hour = hour;
//			this.minute = minute;
//			this.second = second;
//		}

		public void addTime(int hoursToAdd, int minutesToAdd, int secondsToAdd) {
			int hoursHandler = this.hour + hoursToAdd;
//			System.out.println(this.hour);
//			System.out.println(hoursHandler);
			int minutesHandler = this.minute + minutesToAdd;
//			System.out.println(this.minute);
//			System.out.println("h " + minutesHandler);
			int secondsHandler = this.second + secondsToAdd;
//			System.out.println(this.second);
//			System.out.println(secondsHandler);

			if (secondsHandler >= 60) {
				this.addMinutes(secondsHandler / 60);
				this.second = (secondsHandler % 60);
				return;
			} else {
				this.second = secondsHandler;
			}

			if (minutesHandler >= 60) {
				this.addHours(minutesHandler / 60);
				this.minute = (minutesHandler % 60);
				return;
			} else {
				this.minute = minutesHandler;
			}

			if (hoursHandler >= 24) {
				this.hour = (hoursHandler % 24);
				return;
			} else {
				this.hour = hoursHandler;
			}

//			this.second += secondsHandler;
//			if (hoursHandler > 24)
//				this.hour = (hoursHandler) % 24;
//			else
//				this.hour += hoursToAdd;
//			this.minute += minutesToAdd;
//			this.second += secondsToAdd;
		}
	}

	public static class DateTime {
		private Date date;
		private Time time;

		public DateTime() {
			this.date = new Date(0, 0, 0);
			this.time = new Time(0, 0, 0);
		}

//		public DateTime(int year, int month, int date, int hour, int minute, int second) {
//			this.date.setYear(year);
//			this.date.setMonth(month);
//			this.date.setDay(date);
//			this.time.setHour(hour);
//			this.time.setMinute(minute);
//			this.time.setSecond(second);
//		}

		public DateTime(int year, int month, int day, int hour, int minute, int second) {
			this.date = new Date(year, month, day);
			this.time = new Time(hour, minute, second);
		}

		public DateTime(Date date, Time time) {
			this.date = date;
			this.time = time;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(int year, int month, int day) {
			this.date.setYear(year);
			this.date.setMonth(month);
			this.date.setDay(day);
		}

		public Time getTime() {
			return time;
		}

		public void setTime(int hour, int minute, int second) {
			this.time.setHour(hour);
			this.time.setMinute(minute);
			this.time.setSecond(second);
		}

		@Override
		public String toString() {
			return date.toString() + " " + time.toString() + " WIB";
		}
	}

	public static class Main {
		public static void main(String[] args) {

			DateTime dt1 = new DateTime(2025, 4, 11, 4, 25, 20);
			System.out.println("First DateTime: " + dt1.toString());

			dt1.getDate().addYears(1);
			dt1.getTime().addHours(2);
			System.out.println("After adding 1 year and 2 hours: " + dt1.toString());

			Date d = new Date(2025, 1, 12);
			Time t = new Time(22, 10, 12);
			DateTime dt2 = new DateTime(d, t);
			System.out.println("Second DateTime: " + dt2.toString());

			dt2.getDate().addYears(5);
			dt2.getTime().addHours(23);
			dt2.getTime().addMinutes(139);
			dt2.getTime().addSeconds(89);
			System.out.println("After adding 5 year, 23 hours, 139 minutes, and 89 seconds: " + dt2.toString());
		}
	}
}
