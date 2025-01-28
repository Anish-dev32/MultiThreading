package InnerClass;

public class Engine {

    Car car;

    Engine(Car car){
        this.car = car;
    }

    public void start(){
        System.out.println(car.model +" engine got start!");
    }

    public void stop(){
        System.out.println(car.model +" engine got off!");
    }
}
