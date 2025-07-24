package mission2.validator;

import mission2.Car;

public class SuvEngineValidator extends Validator{
    @Override
    public boolean check(Car car) {
        if(car.getType().equals("SUV") && car.getEngine().equals("TOYOTA")){
            errorMessage = "SUV에는 TOYOTA엔진 사용 불가";
            return false;
        }
        return true;
    }
}
