package Enum;

public enum DAYS {
    MONDAY, TUESDAY, WEDNESDAY;

    void getNames(String name){
        System.out.println(DAYS.valueOf(name));
    }
}
