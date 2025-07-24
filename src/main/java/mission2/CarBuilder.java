package mission2;

import mission2.enums.BreakSystem;
import mission2.enums.CarType;
import mission2.enums.EngineType;
import mission2.enums.SteeringSystem;

public class CarBuilder {
    CarType type;
    EngineType engine;
    BreakSystem breakSystem;
    SteeringSystem steering;

    public CarBuilder type(CarType type){
        this.type = type;
        return this;
    }

    public CarBuilder engine(EngineType engine){
        this.engine = engine;
        return this;
    }

    public CarBuilder breakSystem(BreakSystem breakSystem){
        this.breakSystem = breakSystem;
        return this;
    }

    public CarBuilder steering(SteeringSystem steering){
        this.steering = steering;
        return this;
    }

    public Car build() {
        return new Car(type, engine, breakSystem, steering);
    }
}
