package mission2.validator;

import mission2.Car;

public class TruckEngineValidator extends Validator{
    @Override
    public boolean check(Car car) {
        if(car.getType().equals("Truck") && car.getEngine().equals("WIA")){
            errorMessage = "Truck에는 WIA엔진 사용 불가";
            return false;
        }
        return true;
    }
}
