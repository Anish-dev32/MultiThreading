package Inheritance;

public class Parent extends Grandparent{
    int b;
    Parent(int a, int b){
        super(a);
        this.b = b;
        System.out.println("Parents constructor");
    }

    public int myAge() {
        return a+b;
    }
}
