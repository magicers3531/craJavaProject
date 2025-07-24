package mission2;

import mission2.buildstate.BuildState;
import mission2.validator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Context {
    public static final int EXIT_PROGRAM = -1;
    public static final int ERROR = -2;

    private BuildState state;
    public CarBuilder builder = new CarBuilder();
    private Scanner sc;

    private String errorMessage = "";
    Car car;

    public Context(Scanner sc){
        this.sc = sc;
    }

    public void setState(BuildState state){
        this.state = state;
    }

    public void run(){
        while(this.state != null){
            this.state.handle(this);
        }
    }

    public void closeScanner(){
        sc.close();
    }

    public int getNextInput(){
        System.out.print("INPUT > ");

        String buf = sc.nextLine().trim();
        if (buf.equalsIgnoreCase("exit"))
            return EXIT_PROGRAM;

        int answer;
        try {
            answer = Integer.parseInt(buf);
        } catch (NumberFormatException e) {
            System.out.println("ERROR :: 숫자만 입력 가능");
            delay(800);
            return ERROR;
        }

        return answer;
    }

    public void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public void setCar(Car car){
        this.car = car;
    }

    public Car getCar(){
        return this.car;
    }

    public boolean validCheck(){
        List<Validator> validCheckers = new ArrayList<Validator>();
        validCheckers.add(new SedanBreakValidator());
        validCheckers.add(new SuvEngineValidator());
        validCheckers.add(new TruckEngineValidator());
        validCheckers.add(new TruckBreakValidator());
        validCheckers.add(new BoschBreakValidator());
        for(Validator v : validCheckers){
            if(!v.check(car)){
                errorMessage = v.getErrorMessage();
                return false;
            }
        }
        return true;
    }
}
