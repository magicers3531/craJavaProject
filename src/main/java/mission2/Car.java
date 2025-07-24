package mission2;

import mission2.enums.BreakSystem;
import mission2.enums.CarType;
import mission2.enums.EngineType;
import mission2.enums.SteeringSystem;

public class Car {
    CarType type;
    EngineType engine;
    BreakSystem breakSystem;
    SteeringSystem steering;
    boolean workEngine;

    public Car(CarType type, EngineType engine, BreakSystem breakSystem, SteeringSystem steering) {
        this.type = type;
        this.engine = engine;
        workEngine = !this.engine.label().equals("고장난 엔진");
        this.breakSystem = breakSystem;
        this.steering = steering;
    }

    public String getType() {
        return type.label();
    }

    public String getEngine() {
        return engine.label();
    }

    public String getBreakSystem() {
        return breakSystem.label();
    }

    public String getSteering() {
        return steering.label();
    }

    public boolean isWorkEngine(){
        return workEngine;
    }

    @Override
    public String toString(){
        return "Car Type : " + type.label() + "\n" +
               "Engine   : " + engine.label() + "\n" +
               "Brake    : " + breakSystem.label() + "\n" +
               "Steering : " + steering.label();
    }
}
