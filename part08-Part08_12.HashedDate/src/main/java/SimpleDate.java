
public class SimpleDate {

    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    @Override
    public int hashCode() {
        int baseYear = 1900;
        int daysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int leapYears = (this.year - baseYear) / 4 - (this.year - baseYear) / 100 + (this.year - baseYear + 300) / 400;

        int daysFromYears = (this.year - baseYear) * 365 + leapYears;

        int daysFromMonths = 0;
        for (int i = 0; i < this.month - 1; i++) {
            daysFromMonths += daysInMonth[i];
            if (i == 1 && isLeapYear(this.year)) {
                daysFromMonths += 1;
            }
        }

        int totalDays = daysFromYears + daysFromMonths + this.day;

        return totalDays;
    }

    private boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    public boolean earlier(SimpleDate other) {
        if (this.year < other.year) {
            return true;
        }

        if (this.year == other.year
                && this.month < other.month) {
            return true;
        }

        if (this.year == other.year
                && this.month == other.month
                && this.day < other.day) {
            return true;
        }

        return false;
    }

    public int differenceInYears(SimpleDate other) {
        if (earlier(other)) {
            return other.differenceInYears(this);
        }

        int yearRemoved = 0;

        if (this.month < other.month) {
            yearRemoved = 1;
        } else if (this.month == other.month && this.day < other.day) {
            yearRemoved = 1;
        }

        return this.year - other.year - yearRemoved;
    }

}
