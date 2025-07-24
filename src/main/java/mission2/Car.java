package mission2;

public class Car {
    String type;
    String engine;
    String breakSystem;
    String steering;
    boolean workEngine;

    public Car(String type, String engine, String breakSystem, String steering) {
        this.type = type;
        this.engine = engine;
        workEngine = !this.engine.equals("고장난 엔진");
        this.breakSystem = breakSystem;
        this.steering = steering;
    }

    public String getType() {
        return type;
    }

    public String getEngine() {
        return engine;
    }

    public String getBreakSystem() {
        return breakSystem;
    }

    public String getSteering() {
        return steering;
    }

    public boolean isWorkEngine(){
        return workEngine;
    }

    @Override
    public String toString(){
        return "Car Type : " + type + "\n" +
               "Engine   : " + engine + "\n" +
               "Brake    : " + breakSystem + "\n" +
               "Steering : " + steering;
    }
}
