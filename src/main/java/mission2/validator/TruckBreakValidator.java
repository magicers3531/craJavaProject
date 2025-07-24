package mission2.validator;

import mission2.Car;

public class TruckBreakValidator extends Validator {
    @Override
    public boolean check(Car car) {
        if(car.getType().equals("Truck") && car.getBreakSystem().equals("Mando")){
            errorMessage = "Truck에는 Mando제동장치 사용 불가";
            return false;
        }
        return true;
    }
}
