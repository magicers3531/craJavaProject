package mission2.buildstate;

import mission2.Car;
import mission2.Context;
import mission2.validator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunBuildState implements BuildState{
    @Override
    public void handle(Context context) {
        context.clearScreen();
        context.setCar(context.builder.build());

        if(!context.validCheck()){
            System.out.println("자동차가 동작되지 않습니다");
            context.setState(new CarTypeBuildState());
        }else if (!context.getCar().isWorkEngine()) {
            System.out.println("엔진이 고장나있습니다.");
            System.out.println("자동차가 움직이지 않습니다.");
            context.setState(new CarTypeBuildState());
        }else {
            System.out.println(context.getCar().toString());
            System.out.println("자동차가 동작됩니다.");
            context.delay(2000);
            context.setState(new CarTypeBuildState());
        }


    }
}
