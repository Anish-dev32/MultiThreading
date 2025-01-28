package Enum;

public class Main {
    String day = String.valueOf(DAYS.MONDAY);

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.day);

        DAYS[] days = DAYS.values();
        DAYS monday = DAYS.valueOf("MONDAY");

        for(int i=0; i< days.length; i++){
            System.out.println(days[i]);
        }

        for(DAYS day: days){
            System.out.println(day.ordinal());
        }

    }
}
