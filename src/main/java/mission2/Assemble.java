package mission2;

import mission2.buildstate.CarTypeBuildState;

import java.util.Scanner;

public class Assemble {

    public void run(){
        Scanner sc = new Scanner(System.in);
        Context context = new Context(sc);
        context.setState(new CarTypeBuildState());
        context.run();
        context.closeScanner();
    }
}