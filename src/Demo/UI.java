package Demo;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UI {
    private static WorldClock clock;

    public static void main(String[] args) throws Throwable {
        clock = new WorldClock();
        //clock.addCity("Beijing","UTC+8");
/*      clock.addCity("London","UTC+0");
        clock.addCity("Moscow","UTC+4");
        clock.addCity("Sydney","UTC+10");
        clock.addCity("New York","UTC-5");*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("********************");
        System.out.println("Welcome to use the Worldclock.");
        System.out.println("********************");
        String lastOption = "";
        while (!lastOption.equalsIgnoreCase("X")) {
            lastOption = displayMenu(scanner);
        }
        System.out.println("\nThanks for your using.\n");
    }

    public static String displayMenu(Scanner scanner) throws Throwable {
        System.out.println("Please choose:");
        System.out.println("1.Show main cities' local time.");
        System.out.println("2.Correct the time");
        System.out.println("X.quit");
        System.out.print("Your choice is:");
        String option = scanner.next();
        switch (option) {
            case "1":
                performAllTime();
                return option;
            case "2":
                resetTime();
                return option;
            default:
                System.out.println("You have entered invalid value, please select again.");
                return option;
        }
    }

    private static void performAllTime() throws Throwable {
        System.out.println("\n\nMain cities' local time is:");
        for (CityLocalTime cityLocalTime : clock.getCityLocalTimes()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String localTime = formatter.format(cityLocalTime.getCityTime());
            System.out.println(String.format("%s:%s\t\t", cityLocalTime.getCityName(), localTime));
            //System.out.println(cityLocalTime.getCityName().toString());
            //System.out.println(cityLocalTime.getCityTime().toString());
        }
        System.out.print("Press any key to co1ntinue...");
        System.in.read();
    }

    private static void resetTime() throws Throwable {
        clock = new WorldClock();
        clock.addCity("Beijing", "UTC+8");
        clock.addCity("London", "UTC+0");
        clock.addCity("Moscow", "UTC+4");
        clock.addCity("Sydney", "UTC+10");
        clock.addCity("New York", "UTC-5");
        System.out.println("The system time has been reset.");
        System.out.print("Press any key to co1ntinue...");
        System.in.read();
    }
}
