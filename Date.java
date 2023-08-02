public class Date {
    private int Day;
    private int Month;
    private int Year;

    public int getDay() {
        return Day;
    }

    public int getMonth() {
        return Month;
    }

    public int getYear() {
        return Year;
    }

    public void setDay(int Day) {
        if (Day > 0 && Day <= 31) {
            this.Day = Day;
        } else {
            System.out.print("\033[H\033[2J");
            System.out.println("\n\n\t\t\t\t\t\tUnvalid date");
            Main.main(null);
        }
    }

    public void setMonth(int Month) {
        if (Month > 0 && Month <= 12) {
            this.Month = Month;
        } else {
            System.out.print("\033[H\033[2J");
            System.out.println("\n\n\t\t\t\t\t\tUnvalid date");
            Main.main(null);
        }

    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public String toString() {
        return String.format("%02d/%02d/%04d", Month, Day, Year);
    }
}