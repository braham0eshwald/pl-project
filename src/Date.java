import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    // Constructor
    public Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date provided.");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Method to validate a date
    public boolean isValidDate() {
        return isValidDate(this.day, this.month, this.year);
    }

    private boolean isValidDate(int day, int month, int year) {
        if (year < 0 || month < 1 || month > 12 || day < 1) return false;

        Calendar calendar = new GregorianCalendar(year, month - 1, 1);
        int maxDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        return day <= maxDayOfMonth;
    }

    // Method to update the date
    public void updateDate(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date provided.");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Method to get the day of the week
    public String getDayOfWeek() {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return days[dayOfWeek - 1];
    }

    // Method to calculate the difference in days between two dates
    public int calculateDifference(Date otherDate) {
        Calendar cal1 = new GregorianCalendar(this.year, this.month - 1, this.day);
        Calendar cal2 = new GregorianCalendar(otherDate.year, otherDate.month - 1, otherDate.day);

        long diffInMillis = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        return (int) (diffInMillis / (1000 * 60 * 60 * 24));
    }

    // Method to print the date in a readable format
    public void printDate() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        System.out.println(months[this.month - 1] + " " + this.day + ", " + this.year);
    }

    // Implementing Comparable interface for sorting
    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        } else if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        } else {
            return Integer.compare(this.day, other.day);
        }
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}