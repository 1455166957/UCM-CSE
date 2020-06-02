import java.util.Scanner;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(Scanner line) {
        month = line.nextInt();
        day = line.nextInt();
        year = line.nextInt();
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

    public int dayOfYear() {
        int totalDays = 0;
        switch (month) {
            case 12: totalDays += 30;
            case 11: totalDays += 31;
            case 10: totalDays += 30;
            case 9 : totalDays += 31;
            case 8 : totalDays += 31;
            case 7 : totalDays += 30;
            case 6 : totalDays += 31;
            case 5 : totalDays += 30;
            case 4 : totalDays += 31;
            case 3 : totalDays += 28;
            case 2 : totalDays += 31;
        }
        totalDays += day;
        return totalDays;
    }

    public int compare(Date dt) {
        int daysDifference = Math.abs(dayOfYear() - dt.dayOfYear());
        int yearsDifferenceInDays = Math.abs(year - dt.getYear()) * 365;
        int totalDifference = Math.abs(daysDifference - yearsDifferenceInDays);
        int monthsDifference = totalDifference / 30;
        if (monthsDifference >= 60)
            return 60;
        else
            return monthsDifference;
    }

}
