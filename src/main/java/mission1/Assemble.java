package mission1;

import java.util.Scanner;

public class Assemble {
    public static final String QUAL_RESULT_PASS = "자동차 부품 조합 테스트 결과 : PASS";
    private final String CLEAR_SCREEN = "\033[H\033[2J";

    private final int STATE_CAR_TYPE_SELECT      = 0;
    private final int STATE_ENGINE_TYPE_SELECT      = 1;
    private final int STATE_BREAK_TYPE_SELECT      = 2;
    private final int STATE_STEERING_TYPE_SELECT      = 3;
    private final int STATE_RUN_OR_TEST      = 4;

    //private final int Run_Test       = 4;
    private final int Exit_Program       = 5;
    private final int GoBack       = 6;
    private final int Input_Error       = -1;

    private CarType curCarType;
    private EngineType curEngineType;
    private BreakSystem curBreakSystem;
    private SteeringSystem curSteeringSystem;

    Scanner sc = new Scanner(System.in);

    public void run(){

        int currentStep = STATE_CAR_TYPE_SELECT;

        while (true) {
            clearScreen();

            printWaitState(currentStep);

            int inputResult = getUserInput(currentStep);
            if(inputResult == Exit_Program) break;
            if(inputResult == Input_Error) continue;
            if (inputResult == GoBack) {
                currentStep--;
                continue;
            }


            switch (currentStep) {
                case STATE_CAR_TYPE_SELECT:
                    selectCarType(inputResult);
                    delay(800);
                    currentStep = STATE_ENGINE_TYPE_SELECT;
                    break;
                case STATE_ENGINE_TYPE_SELECT:
                    selectEngine(inputResult);
                    delay(800);
                    currentStep = STATE_BREAK_TYPE_SELECT;
                    break;
                case STATE_BREAK_TYPE_SELECT:
                    selectBrakeSystem(inputResult);
                    delay(800);
                    currentStep = STATE_STEERING_TYPE_SELECT;
                    break;
                case STATE_STEERING_TYPE_SELECT:
                    selectSteeringSystem(inputResult);
                    delay(800);
                    currentStep = STATE_RUN_OR_TEST;
                    break;
                case STATE_RUN_OR_TEST:
                    if (inputResult == 1) {
                        runProducedCar();
                        delay(2000);
                    } else if (inputResult == 2) {
                        testProducedCar();
                        delay(2000);
                    }
                    currentStep = STATE_CAR_TYPE_SELECT;
                    break;
            }
        }
        sc.close();
    }

    private int getUserInput(int currentStep){
        System.out.print("INPUT > ");

        String buf = sc.nextLine().trim();

        if (buf.equalsIgnoreCase("exit")) {
            System.out.println("바이바이");

            return Exit_Program;
        }

        int answer;
        try {
            answer = Integer.parseInt(buf);
        } catch (NumberFormatException e) {
            System.out.println("ERROR :: 숫자만 입력 가능");
            delay(800);
            return Input_Error;
        }

        if (!checkUserInputValidRange(currentStep, answer)) {
            delay(800);
            return Input_Error;
        }

        if (answer == 0) {
            if (currentStep > STATE_CAR_TYPE_SELECT) {
                return GoBack;
            }
        }

        return answer;
    }

    private void printWaitState(int step) {
        switch (step) {
            case STATE_CAR_TYPE_SELECT:
                showCarTypeMenu(); break;
            case STATE_ENGINE_TYPE_SELECT:
                showEngineMenu(); break;
            case STATE_BREAK_TYPE_SELECT:
                showBrakeMenu(); break;
            case STATE_STEERING_TYPE_SELECT:
                showSteeringMenu(); break;
            case STATE_RUN_OR_TEST:
                showRunTestMenu(); break;
        }
    }

    private void clearScreen() {
        System.out.print(CLEAR_SCREEN);
        System.out.flush();
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
    private static void showEngineMenu() {
        System.out.println("어떤 엔진을 탑재할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. GM");
        System.out.println("2. TOYOTA");
        System.out.println("3. WIA");
        System.out.println("4. 고장난 엔진");
        System.out.println("===============================");
    }
    private static void showBrakeMenu() {
        System.out.println("어떤 제동장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. MANDO");
        System.out.println("2. CONTINENTAL");
        System.out.println("3. BOSCH");
        System.out.println("===============================");
    }
    private static void showSteeringMenu() {
        System.out.println("어떤 조향장치를 선택할까요?");
        System.out.println("0. 뒤로가기");
        System.out.println("1. BOSCH");
        System.out.println("2. MOBIS");
        System.out.println("===============================");
    }
    private static void showRunTestMenu() {
        System.out.println("멋진 차량이 완성되었습니다.");
        System.out.println("어떤 동작을 할까요?");
        System.out.println("0. 처음 화면으로 돌아가기");
        System.out.println("1. RUN");
        System.out.println("2. Test");
        System.out.println("===============================");
    }

    private boolean checkUserInputValidRange(int step, int ans) {
        switch (step) {
            case STATE_CAR_TYPE_SELECT:
                if (ans < 1 || ans > 3) {
                    System.out.println("ERROR :: 차량 타입은 1 ~ 3 범위만 선택 가능");
                    return false;
                }
                break;
            case STATE_ENGINE_TYPE_SELECT:
                if (ans < 0 || ans > 4) {
                    System.out.println("ERROR :: 엔진은 1 ~ 4 범위만 선택 가능");
                    return false;
                }
                break;
            case STATE_BREAK_TYPE_SELECT:
                if (ans < 0 || ans > 3) {
                    System.out.println("ERROR :: 제동장치는 1 ~ 3 범위만 선택 가능");
                    return false;
                }
                break;
            case STATE_STEERING_TYPE_SELECT:
                if (ans < 0 || ans > 2) {
                    System.out.println("ERROR :: 조향장치는 1 ~ 2 범위만 선택 가능");
                    return false;
                }
                break;
            case STATE_RUN_OR_TEST:
                if (ans < 0 || ans > 2) {
                    System.out.println("ERROR :: Run 또는 Test 중 하나를 선택 필요");
                    return false;
                }
                break;
        }
        return true;
    }

    private void selectCarType(int selection) {
        curCarType = selection == 1? CarType.Sedan :
                     selection == 2 ? CarType.SUV :
                                      CarType.Truck;
        System.out.printf("차량 타입으로 %s을 선택하셨습니다.\n", curCarType.label());
    }
    private void selectEngine(int selection) {
        curEngineType = selection == 1 ? EngineType.GM :
                        selection == 2 ? EngineType.TOYOTA :
                        selection == 3 ? EngineType.WIA :
                                         EngineType.NotWork;
        System.out.printf("%s 엔진을 선택하셨습니다.\n", curEngineType.label());
    }
    private void selectBrakeSystem(int selection) {
        curBreakSystem = selection == 1 ? BreakSystem.Mando :
                         selection == 2 ? BreakSystem.Continental :
                                          BreakSystem.Bosch;

        System.out.printf("%s 제동장치를 선택하셨습니다.\n", curBreakSystem.label());
    }
    private void selectSteeringSystem(int selection) {
        curSteeringSystem = selection == 1 ? SteeringSystem.Bosch :
                                             SteeringSystem.Mobis;

        System.out.printf("%s 조향장치를 선택하셨습니다.\n", curSteeringSystem.label());
    }




    private void runProducedCar() {
        if (!isValidCheck()) {
            System.out.println("자동차가 동작되지 않습니다");
            return;
        }
        if ( curEngineType == EngineType.NotWork) {
            System.out.println("엔진이 고장나있습니다.");
            System.out.println("자동차가 움직이지 않습니다.");
            return;
        }

        System.out.printf("Car Type : %s\n", curCarType.label());
        System.out.printf("Engine   : %s\n", curEngineType.label());
        System.out.printf("Brake    : %s\n", curBreakSystem.label());
        System.out.printf("Steering : %s\n", curBreakSystem.label());
        System.out.println("자동차가 동작됩니다.");
    }

    private String qualifyCar(){
        String result;
        if ( curCarType == CarType.Sedan && curBreakSystem == BreakSystem.Continental) {
            result = "Sedan에는 Continental제동장치 사용 불가";
        } else if (curCarType == CarType.SUV && curEngineType == EngineType.TOYOTA) {
            result = "SUV에는 TOYOTA엔진 사용 불가";
        } else if (curCarType == CarType.Truck && curEngineType == EngineType.WIA) {
            result = "Truck에는 WIA엔진 사용 불가";
        } else if (curCarType == CarType.Truck && curBreakSystem == BreakSystem.Mando) {
            result = "Truck에는 Mando제동장치 사용 불가";
        } else if ( curBreakSystem == BreakSystem.Bosch && curSteeringSystem == SteeringSystem.Bosch) {
            result = "Bosch제동장치에는 Bosch조향장치 이외 사용 불가";
        } else {
            result = QUAL_RESULT_PASS;
        }
        return result;
    }

    private boolean isValidCheck() {
        return qualifyCar().equals(QUAL_RESULT_PASS);
    }

    private void testProducedCar() {
        System.out.println("Test...");
        delay(1500);

        String qualResult = qualifyCar();
        if(qualResult.equals(QUAL_RESULT_PASS))
            System.out.println(qualResult);
        else
            fail(qualResult);
    }

    private void fail(String msg) {
        System.out.println("자동차 부품 조합 테스트 결과 : FAIL");
        System.out.println(msg);
    }

    private void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }
}