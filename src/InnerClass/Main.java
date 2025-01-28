package InnerClass;

public class Main {
    public static void main(String[] args) {
        /*ShoppingCart cart = new ShoppingCart(2500);
        cart.payment(new Payment() {
            @Override
            public void pay(int amount) {
                System.out.println(cart.totalAmount+" got paid !!");
            }
        });*/

        HotelBooking hotel = new HotelBooking("Lila",25,15);
        hotel.reserveRoom("Anish",5);
        hotel.reserveRoom("Amrit",7);
    }
}
