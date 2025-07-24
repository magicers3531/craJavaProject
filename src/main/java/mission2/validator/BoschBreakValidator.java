package mission2.validator;

import mission2.Car;

public class BoschBreakValidator extends Validator{
    @Override
    public boolean check(Car car) {
        if(car.getBreakSystem().equals("Bosch") && !car.getSteering().equals("Bosch")){
            errorMessage = "Bosch제동장치에는 Bosch조향장치 이외 사용 불가";
            return false;
        }
        return true;
    }
}
