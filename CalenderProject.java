import java.util.Scanner;

public class CalenderProject {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter year: ");
		int year = input.nextInt();
		System.out.print("Enter the month in integers: ");
		int month = input.nextInt();
		
		// declare variables
		int dayInput = 1;
		int day = dayOfWeek(month, dayInput, year);
		String header;
		header = "";
		
		// get name of the month
		switch (month){
			case 1: header += "January "; break;
			case 2: header += "February "; break;
			case 3: header += "March "; break;
			case 4: header += "April "; break;
			case 5: header += "May "; break;
			case 6: header += "June "; break;
			case 7: header += "July "; break;
			case 8: header += "August "; break;
			case 9: header += "September "; break;
			case 10: header += "October "; break;
			case 11: header += "November "; break;
			case 12: header += "December "; break;
		}
		
		//print outline
		System.out.println(
				"\n\t\t   " + header + year +
				"\n-----------------------------------------------\n " +
				"Sun    Mon    Tue    Wed    Thu    Fri    Sat");

			// line the first row of numbers
			day %= 7;
			for (int b = 0; b <= day * 7; b++) {
				System.out.print(" ");
			}

			// Compute last day of present month
			int lastDay = 0;
			if ( month == 1 || month == 3  || month == 5 || month == 7 ||
				  month == 8 || month == 10 ||month == 12)
				lastDay += 31;
			else if (month == 4 || month == 6 || month == 9 || month == 11)
				lastDay += 30;
			else { // Test for leap year
				if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
					lastDay += 29;
				else
					lastDay += 28;
			}

			// Display calender for current month
			for (int d = 1; d <= lastDay; d++) {
				// Add a black space before numbers less than 10
				if (d < 10) 
					System.out.print(" ");
				// Start new line after satuarday
				if (day % 7 == 6)
					System.out.print(d + "\n ");
				else {
					System.out.print(d + "     ");
					// After last day of the month go to new line
					if (d == lastDay) 
						System.out.println();
				}
				day++; // increment day

			}
			System.out.println();
	}
	
	public static int dayOfWeek(int month, int dayInput, int year) {
		 //calculate Ge
		 int y = year - (14 - month) / 12;
		 int x = y + y/4 - y/100 + y/400;
		 int m = month + 12 * ((14 - month) / 12) - 2;
		 //calculate with day of the week a given day falls on
		 int d = (dayInput + x + (31*m)/12) % 7;
		 return d; //return the day of the week
    }
}
	
	

