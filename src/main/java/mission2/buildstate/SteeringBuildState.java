package mission2.buildstate;

import mission2.Context;
import mission2.enums.SteeringSystem;

public class SteeringBuildState implements BuildState {
    @Override
    public void handle(Context context) {
        context.clearScreen();
        showSteeringMenu();
        int userInput = context.getNextInput();

        if(userInput == Context.EXIT_PROGRAM){
            System.out.println("바이바이");
            context.setState(null);
        }
        else if(userInput == Context.ERROR)
            context.setState(new SteeringBuildState());
        else if(userInput == 0)
            context.setState(new BreakBuildState());
        else if (userInput < 1 || userInput > 2) {
            System.out.println("ERROR :: 조향장치는 1 ~ 2 범위만 선택 가능");
            context.setState(new SteeringBuildState());
        }
        else{
            SteeringSystem steering = userInput == 1 ?  SteeringSystem.Bosch : SteeringSystem.Mobis;
            System.out.printf("%s 조향장치를 선택하셨습니다.\n", steering);
            context.builder.steering(steering);
            context.delay(800);

            context.setState(new RunSelectionModeBuildState());
        }
    }

    private static void showSteeringMenu() {
        System.out.println("어떤 조향장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. BOSCH");
        System.out.println("2. MOBIS");
        System.out.println("===============================");
    }
}
