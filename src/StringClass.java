public class StringClass {

    /*
    * String is immutable and final, stored in pool and variables point to it .
    * to make operations on string like concat, append, have to create another string with required modification
    * causing creating of many temporary strings.
    *
    * to fix this, StringBuilder came, which is mutable, can do operations on same string along with method
    * chaining functionality.
    *
    * since, StringBuilder is mutable, so it's not thread safe, to fix this, StringBuffer came which is thread safe
    * along with same methods and usage as StringBuilder.
    *
    */

    public static void main(String[] args) {
        String s1 = "Anish";
        String name = s1.concat(" Kumar");
        System.out.println(name);

        StringBuilder sb = new StringBuilder("hello");
        sb.append(" World!").reverse();
        System.out.println(sb.toString());
        String s = sb.toString(); // immutable

        StringBuffer sf = new StringBuffer("Thread");
        sf.append(" safe");
        System.out.println(sf.toString());
    }

}
