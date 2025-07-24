package mission2.validator;

import mission2.Car;

public abstract class Validator {
    protected String errorMessage = "자동차 부품 조합 테스트 결과 : PASS";

    public abstract boolean check(Car car);

    public String getErrorMessage(){
        return errorMessage;
    }
}
