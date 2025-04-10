package sandyb;

public class W06 {
	public static class Date extends DateTime {
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
			return null;
		}

		@Override
		public void setDate(int year, int month, int day) {

		}

		public void addDate(int daysToAdd, int monthsToAdd, int yearsToAdd) {

		}
	}

	public static class Time extends DateTime {
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
			this.hour += hoursToAdd;
		}

		public void addMinutes(int minutesToAdd) {
			this.minute += minutesToAdd;
		}

		public void addSeconds(int secondsToAdd) {
			this.second += secondsToAdd;
		}

		@Override
		public String toString() {
			return null;
		}

		@Override
		public void setTime(int hour, int minute, int second) {

		}

		public void addTime(int hoursToAdd, int minutesToAdd, int secondsToAdd) {

		}
	}

	public static class DateTime {
		private Date date;
		private Time time;

		public DateTime(int year, int month, int date, int hour, int minute, int second) {
			this.date.year = year;
			this.date.month = month;
			this.date.day = date;
			this.time.hour = hour;
			this.time.minute = minute;
			this.time.second = second;
		}

		public DateTime(Date date, Time time) {
			this.date = date;
			this.time = time;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(int year, int month, int day) {
			this.date.year = year;
			this.date.month = month;
			this.date.day = day;
		}

		public Time getTime() {
			return time;
		}

		public void setTime(int hour, int minute, int second) {
			this.time.hour = hour;
			this.time.minute = minute;
			this.time.second = second;
		}

		@Override
		public String toString() {
			return null;
		}
	}

	public static class Main {
		public static void main(String[] args) {

		}
	}
}
