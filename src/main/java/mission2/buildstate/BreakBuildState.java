package mission2.buildstate;

import mission2.Context;
import mission2.enums.BreakSystem;

public class BreakBuildState implements BuildState {
    @Override
    public void handle(Context context) {
        context.clearScreen();

        showBrakeMenu();
        int userInput = context.getNextInput();

        if(userInput == Context.EXIT_PROGRAM){
            System.out.println("바이바이");
            context.setState(null);
        }
        else if(userInput == Context.ERROR)
            context.setState(new BreakBuildState());
        else if(userInput == 0)
            context.setState(new EngineBuildState());
        else if (userInput < 1 || userInput > 3) {
            System.out.println("ERROR :: 제동장치는 1 ~ 3 범위만 선택 가능");
            context.setState(new BreakBuildState());
        }
        else{
            BreakSystem breakSystem = userInput == 1 ? BreakSystem.Mando:
                               userInput == 2 ? BreakSystem.Continental : BreakSystem.Bosch;
            System.out.printf("%s 제동장치를 선택하셨습니다.\n", breakSystem);
            context.builder.breakSystem(breakSystem);
            context.delay(800);

            context.setState(new SteeringBuildState());
        }
    }

    private static void showBrakeMenu() {
        System.out.println("어떤 제동장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. MANDO");
        System.out.println("2. CONTINENTAL");
        System.out.println("3. BOSCH");
        System.out.println("===============================");
    }
}
