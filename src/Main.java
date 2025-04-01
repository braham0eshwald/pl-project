import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        try {
            // Create valid Date objects
            Date date1 = new Date(15, 8, 2023);
            Date date2 = new Date(1, 1, 2023);
            Date date3 = new Date(31, 12, 2022);

            // Print the dates
            System.out.print("Date 1: ");
            date1.printDate();
            System.out.print("Date 2: ");
            date2.printDate();
            System.out.print("Date 3: ");
            date3.printDate();

            // Update a date
            System.out.println("\nUpdating Date 1 to February 29, 2024...");
            date1.updateDate(29, 2, 2024);
            date1.printDate();

            // Get the day of the week
            System.out.println("\nDay of the week for Date 1: " + date1.getDayOfWeek());

            // Calculate the difference between two dates
            System.out.println("\nDifference between Date 1 and Date 2: " +
                    date1.calculateDifference(date2) + " days");

            // Sorting an ArrayList of Date objects
            ArrayList<Date> dates = new ArrayList<>();
            dates.add(new Date(15, 8, 2023));
            dates.add(new Date(1, 1, 2023));
            dates.add(new Date(31, 12, 2022));

            System.out.println("\nBefore sorting:");
            for (Date d : dates) {
                System.out.println(d);
            }

            Collections.sort(dates);

            System.out.println("\nAfter sorting:");
            for (Date d : dates) {
                System.out.println(d);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}