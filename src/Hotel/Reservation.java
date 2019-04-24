package Hotel;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.List;

public class Reservation implements Reservationy {

    String DowBooking;
    String CodeBooking;

    public Reservation() {
        StringBuilder sb = new StringBuilder();
        List<String> dow = new ArrayList<>();
        dow.add("MON");
        dow.add("TUE");
        dow.add("WED");
        dow.add("THU");
        dow.add("FRI");
        dow.add("SAT");
        dow.add("SUN");

        DowBooking = dow.get((int) (Math.random() * dow.size()));

        char [] codeChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E' , 'F', 'G', 'H',
                              'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < 8; i++) {
            sb.append(codeChars[(int) (Math.random() * (codeChars.length - 1))]);
        }
        CodeBooking = sb.toString();
    }

    @Override
    public String getDowBooking() {
        return DowBooking;
    }

    @Override
    public String getCodeBooking() {
        return CodeBooking;
    }

    public static void main(String[] args) {
        List<Reservation> myHotel = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            myHotel.add(new Reservation());
        }

        for (int i = 0; i < myHotel.size(); i++) {
            System.out.println("Booking# " + myHotel.get(i).getCodeBooking() + " for " + myHotel.get(i).getDowBooking());
        }
    }
}
