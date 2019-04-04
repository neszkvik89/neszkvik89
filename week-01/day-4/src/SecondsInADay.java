public class SecondsInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;
        int totalseconds = 24 * 60 * 60;
        int secondsPassed = currentSeconds + currentMinutes * 60 + currentHours * 60 * 60;
        int secondsRemaining = totalseconds - secondsPassed;

        System.out.println(secondsRemaining);

        // Write a program that prints the remaining seconds (as an integer) from a
        // day if the current time is represented by the variables
    }
}
