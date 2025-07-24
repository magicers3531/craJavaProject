package mission2.buildstate;

import mission2.Car;
import mission2.Context;

public class TestBuildState implements BuildState{
    @Override
    public void handle(Context context) {
        context.clearScreen();
        System.out.println("Test...");
        context.delay(1500);
        context.setCar(context.builder.build());

        if(!context.validCheck()){
            System.out.println("자동차 부품 조합 테스트 결과 : FAIL");
            System.out.println(context.getErrorMessage());
            context.setState(new CarTypeBuildState());
        }

        context.delay(2000);
        context.setState(new CarTypeBuildState());


    }
}
