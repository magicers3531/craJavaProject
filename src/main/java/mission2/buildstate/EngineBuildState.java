package mission2.buildstate;

import mission2.Context;

public class EngineBuildState implements BuildState {
    @Override
    public void handle(Context context) {
        context.clearScreen();
        showEngineMenu();
        int userInput = context.getNextInput();

        if(userInput == Context.EXIT_PROGRAM){
            System.out.println("바이바이");
            context.setState(null);
        }
        else if(userInput == Context.ERROR)
            context.setState(new EngineBuildState());
        else if(userInput == 0)
            context.setState(new CarTypeBuildState());
        else if (userInput < 1 || userInput > 4) {
            System.out.println("ERROR :: 엔진은 1 ~ 4 범위만 선택 가능");
            context.setState(new EngineBuildState());
        }
        else{
            String engine = userInput == 1 ? "GM" : userInput == 2 ? "TOYOTA" : userInput == 3 ? "WIA" : "고장난 엔진";
            System.out.printf("%s 엔진을 선택하셨습니다.\n", engine);
            context.builder.engine(engine);
            context.delay(800);

            context.setState(new BreakBuildState());
        }
    }

    private static void showEngineMenu() {
        System.out.println("어떤 엔진을 탑재할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. GM");
        System.out.println("2. TOYOTA");
        System.out.println("3. WIA");
        System.out.println("4. 고장난 엔진");
        System.out.println("===============================");
    }
}
