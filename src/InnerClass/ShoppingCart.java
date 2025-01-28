package InnerClass;

public class ShoppingCart {

    int totalAmount;

    ShoppingCart(int amt){
        this.totalAmount = amt;
    }

    void payment(Payment payment){
        payment.pay(totalAmount);
    }
}
