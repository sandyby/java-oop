package week02.sandy.id.ac.umn;

import java.util.Scanner;

public class Tugas1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a month (1-12): ");
		int month = scanner.nextInt();
		if (month > 12 || month < 1) {
			System.out.println("Please enter a valid month!\n\n@sandyb________");
			scanner.close();
			System.exit(0);
		}
		MonthDaysPair monthDaysPair = MonthDaysPair.values()[month - 1];
		System.out.println(
				monthDaysPair.getMonthName() + " has " + monthDaysPair.getDaysOfMonth() + " days\n\n@sandyb________");
	}

	/*
	 * public static void main(String[] args) { Scanner scanner = new
	 * Scanner(System.in); System.out.print("Enter a month (1-12): "); int month =
	 * scanner.nextInt(); scanner.close(); switch (month) { case 1:
	 * System.out.println("January has 31 days"); break; case 2:
	 * System.out.println("February has 28 days"); break; case 3:
	 * System.out.println("March has 31 days"); break; case 4:
	 * System.out.println("April has 30 days"); break; case 5:
	 * System.out.println("May has 31 days"); break; case 6:
	 * System.out.println("June has 30 days"); break; case 7:
	 * System.out.println("July has 31 days"); break; case 8:
	 * System.out.println("August has 31 days"); break; case 9:
	 * System.out.println("September has 30 days"); break; case 10:
	 * System.out.println("October has 31 days"); break; case 11:
	 * System.out.println("November has 30 days"); break; case 12:
	 * System.out.println("December has 31 days"); break; default:
	 * System.out.println("Please enter a valid month!"); }
	 * System.out.println("\n@sandyb________"); }
	 */
}

enum MonthDaysPair {
	JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31), JUNE(30), JULY(31), AUGUST(31), SEPTEMBER(30),
	OCTOBER(31), NOVEMBER(30), DECEMBER(31);

	private int totalDays;

	MonthDaysPair(int totalDays) {
		this.totalDays = totalDays;
	}

	public String getMonthName() {
		return name().substring(0, 1) + name().substring(1).toLowerCase();
	}

	public int getDaysOfMonth() {
		return totalDays;
	}
}