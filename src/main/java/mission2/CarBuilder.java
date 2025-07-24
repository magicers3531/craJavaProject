package mission2;

public class CarBuilder {
    String type;
    String engine;
    String breakSystem;
    String steering;

    public CarBuilder type(String type){
        this.type = type;
        return this;
    }

    public CarBuilder engine(String engine){
        this.engine = engine;
        return this;
    }

    public CarBuilder breakSystem(String breakSystem){
        this.breakSystem = breakSystem;
        return this;
    }

    public CarBuilder steering(String steering){
        this.steering = steering;
        return this;
    }

    public Car build() {
        return new Car(type, engine, breakSystem, steering);
    }
}
