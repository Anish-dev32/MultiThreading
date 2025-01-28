import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList<T> {

    private T[] arr;
    private static int DEFAULT_SIZE = 5;
    private int size = 0;

    CustomArrayList(int size){
        arr = (T[]) new Object[size];
    }

    CustomArrayList(){
        arr = (T[]) new Object[DEFAULT_SIZE];
    }

    public void add(T num) {
        if(isfull()){
            resize();
        }
        arr[size++]  = num;
    }

    private void resize() {
        T[] temp = (T[]) new Object[arr.length*2];
        for(int i=0; i<arr.length; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    private boolean isfull() {
        return size == arr.length;
    }

    public void remove(){
        size = size-1;
    }

    public void print(){
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void set(int index, T num){
        arr[index] = num;
    }

    public T get(int index){
        return arr[index];
    }

    public int size(){
        return size;
    }

    public int length(){
        return arr.length;
    }

    public boolean contains(T num){
        for(int i=0; i<size; i++){
            if(arr[i] == num){return true;}
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        CustomArrayList<String> arr = new CustomArrayList<>(7);
        arr.add("Anish");
        arr.add("Amrit");
        arr.add("Ankit");
        arr.print();
        arr.remove();
        if(arr.contains("Amrit")) {
            System.out.println("Amrit is present");
        }
        arr.print();
    }
}
