package Inheritance;

public class Main {
    public static void main(String[] args) {
        child obj = new child(3,10, 7);
        System.out.println(obj.a);

        Grandparent pobj = new Parent(4,6);
        System.out.println(pobj.a);
        pobj.grandparentfun();

        Grandparent gobj = new Grandparent(5);
        System.out.println(gobj.a);
    }
}
