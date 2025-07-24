package mission2.validator;

import mission2.Car;

public class SedanBreakValidator extends Validator{
    @Override
    public boolean check(Car car) {
        if(car.getType().equals("Sedan") && car.getBreakSystem().equals("Continental")){
            errorMessage = "Sedan에는 Continental제동장치 사용 불가";
            return false;
        }
        return true;
    }
}
