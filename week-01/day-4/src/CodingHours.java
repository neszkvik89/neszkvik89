public class CodingHours {
    public static void main(String[] args) {
        // An average Green Fox attendee codes 6 hours daily
        // The semester is 17 weeks long
        //
        // Print how many hours is spent with coding in a semester by an attendee,
        // if the attendee only codes on workdays.
        //
        // Print the percentage of the coding hours in the semester if the average
        // work hours weekly is 52

        int dailyAvg = 6;
        int semesterLength  = 17;
        int weekdays = 5;
        int weeklyWorkHours = 52;

        int totalCodingTime = dailyAvg * semesterLength * weekdays;
        double codingPercentage = (double) totalCodingTime / (weeklyWorkHours * semesterLength) * 100;

        System.out.println(totalCodingTime);
        System.out.println(codingPercentage + "%");

    }
}
