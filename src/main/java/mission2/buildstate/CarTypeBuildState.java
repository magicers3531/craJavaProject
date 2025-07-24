package mission2.buildstate;

import mission2.Context;
import mission2.enums.CarType;

public class CarTypeBuildState implements BuildState {

    @Override
    public void handle(Context context) {
        context.clearScreen();
        showCarTypeMenu();
        int userInput = context.getNextInput();

        if(userInput == Context.EXIT_PROGRAM){
            System.out.println("바이바이");
            context.setState(null);
        }
        else if(userInput == Context.ERROR)
            context.setState(new CarTypeBuildState());
        else if (userInput < 1 || userInput > 3) {
            System.out.println("ERROR :: 차량 타입은 1 ~ 3 범위만 선택 가능");
            context.setState(new CarTypeBuildState());
        }
        else{
            CarType carType = userInput == 1 ? CarType.Sedan:
                             userInput == 2 ?  CarType.SUV : CarType.Truck;
            System.out.printf("차량 타입으로 %s을 선택하셨습니다.\n", carType);
            context.builder.type(carType);
            context.delay(800);

            context.setState(new EngineBuildState());

        }
    }

    private static void showCarTypeMenu() {
        System.out.println("        ______________");
        System.out.println("       /|            |");
        System.out.println("  ____/_|_____________|____");
        System.out.println(" |                      O  |");
        System.out.println(" '-(@)----------------(@)--'");
        System.out.println("===============================");
        System.out.println("어떤 차량 타입을 선택할까요?");
        System.out.println("1. Sedan");
        System.out.println("2. SUV");
        System.out.println("3. Truck");
        System.out.println("===============================");
    }
}
