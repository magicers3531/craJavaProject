package mission2.buildstate;

import mission2.Context;

public class RunSelectionModeBuildState implements BuildState{
    @Override
    public void handle(Context context) {
        context.clearScreen();
        showRunTestMenu();
        int userInput = context.getNextInput();

        if(userInput == Context.EXIT_PROGRAM){
            System.out.println("바이바이");
            context.setState(null);
        }
        else if(userInput == Context.ERROR)
            context.setState(new RunSelectionModeBuildState());
        else if(userInput == 0)
            context.setState(new CarTypeBuildState());
        else if(userInput == 1)
            context.setState(new RunBuildState());
        else if(userInput == 2)
            context.setState(new TestBuildState());
        else  {
            System.out.println("ERROR :: Run 또는 Test 중 하나를 선택 필요");
            context.setState(new RunSelectionModeBuildState());
        }
    }

    private static void showRunTestMenu() {
        System.out.println("멋진 차량이 완성되었습니다.");
        System.out.println("어떤 동작을 할까요?");
        System.out.println("0. 처음 화면으로 돌아가기");
        System.out.println("1. RUN");
        System.out.println("2. Test");
        System.out.println("===============================");
    }
}
