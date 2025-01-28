public interface Demon {
    static void dummy(){
        System.out.println("static");
    }
    boolean isDummy(int s);

    /*default void isCalledDummy(){
        System.out.println("Dummy is dummy");
    }*/

}
