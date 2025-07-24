import mission2.Car;
import mission2.CarBuilder;
import mission2.Context;
import mission2.buildstate.CarTypeBuildState;
import mission2.validator.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CarBuilderTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStream(){
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams(){
        System.setOut(originalOut);
    }

    @Test
    void Builder_기본_테스트() {
        Car car = new CarBuilder()
                .type("Sedan")
                .engine("TOYOTA")
                .breakSystem("Mando")
                .steering("Bosch")
                .build();

        assertNotNull(car);
    }

    @Test
    void CarType_Error생성() {
        // 가짜 Scanner 객체 생성
        Scanner scanner = Mockito.mock(Scanner.class);

        when(scanner.nextLine())
                .thenReturn("dfasdff")
                .thenReturn("12132312")
                .thenReturn("exit");

        Context context = new Context(scanner);
        context.setState(new CarTypeBuildState());
        context.run();
        context.closeScanner();;

        System.out.println(outContent.toString());


        assertTrue(outContent.toString().contains("ERROR :: 숫자만 입력 가능"));
        assertTrue(outContent.toString().contains("ERROR :: 차량 타입은 1 ~ 3 범위만 선택 가능"));
    }

    @Test
    void Sedan생성기본() {
        // 가짜 Scanner 객체 생성
        Scanner scanner = Mockito.mock(Scanner.class);

        when(scanner.nextLine())
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("exit");

        Context context = new Context(scanner);
        context.setState(new CarTypeBuildState());
        context.run();
        context.closeScanner();;

        assertEquals("Sedan", context.getCar().getType());
        assertEquals("Bosch", context.getCar().getSteering());

    }

    @Test
    void SUV생성기본() {
        // 가짜 Scanner 객체 생성
        Scanner scanner = Mockito.mock(Scanner.class);

        when(scanner.nextLine())
                .thenReturn("2")
                .thenReturn("2")
                .thenReturn("2")
                .thenReturn("2")
                .thenReturn("1")
                .thenReturn("exit");

        Context context = new Context(scanner);
        context.setState(new CarTypeBuildState());
        context.run();
        context.closeScanner();;

        assertEquals("SUV", context.getCar().getType());
    }

    @Test
    void Engine_Error생성() {
        // 가짜 Scanner 객체 생성
        Scanner scanner = Mockito.mock(Scanner.class);

        when(scanner.nextLine())
                .thenReturn("3")
                .thenReturn("dfasdff")
                .thenReturn("1231231231")
                .thenReturn("exit");

        Context context = new Context(scanner);
        context.setState(new CarTypeBuildState());
        context.run();
        context.closeScanner();;

        System.out.println(outContent.toString());


        assertTrue(outContent.toString().contains("ERROR :: 숫자만 입력 가능"));
        assertTrue(outContent.toString().contains("ERROR :: 엔진은 1 ~ 4 범위만 선택 가능"));
    }

    @Test
    void Engine_이전Step() {
        // 가짜 Scanner 객체 생성
        Scanner scanner = Mockito.mock(Scanner.class);

        when(scanner.nextLine())
                .thenReturn("2")
                .thenReturn("0")
                .thenReturn("3")
                .thenReturn("2")
                .thenReturn("2")
                .thenReturn("2")
                .thenReturn("1")
                .thenReturn("exit");

        Context context = new Context(scanner);
        context.setState(new CarTypeBuildState());
        context.run();
        context.closeScanner();;

        assertEquals("Truck", context.getCar().getType());
    }

    @Test
    void break_Error생성() {
        // 가짜 Scanner 객체 생성
        Scanner scanner = Mockito.mock(Scanner.class);

        when(scanner.nextLine())
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("sdfasfsfd")
                .thenReturn("1231231231")
                .thenReturn("exit");

        Context context = new Context(scanner);
        context.setState(new CarTypeBuildState());
        context.run();
        context.closeScanner();;

        System.out.println(outContent.toString());


        assertTrue(outContent.toString().contains("ERROR :: 숫자만 입력 가능"));
        assertTrue(outContent.toString().contains("ERROR :: 제동장치는 1 ~ 3 범위만 선택 가능"));
    }

    @Test
    void break_이전step() {
        // 가짜 Scanner 객체 생성
        Scanner scanner = Mockito.mock(Scanner.class);

        when(scanner.nextLine())
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("0")
                .thenReturn("2")
                .thenReturn("2")
                .thenReturn("2")
                .thenReturn("1")
                .thenReturn("exit");

        Context context = new Context(scanner);
        context.setState(new CarTypeBuildState());
        context.run();
        context.closeScanner();;

        System.out.println(outContent.toString());

        assertEquals("TOYOTA", context.getCar().getEngine());
    }

    @Test
    void steering_Error생성() {
        // 가짜 Scanner 객체 생성
        Scanner scanner = Mockito.mock(Scanner.class);

        when(scanner.nextLine())
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("sdfasfsfd")
                .thenReturn("1231231231")
                .thenReturn("exit");

        Context context = new Context(scanner);
        context.setState(new CarTypeBuildState());
        context.run();
        context.closeScanner();;

        System.out.println(outContent.toString());


        assertTrue(outContent.toString().contains("ERROR :: 숫자만 입력 가능"));
        assertTrue(outContent.toString().contains("ERROR :: 조향장치는 1 ~ 2 범위만 선택 가능"));
    }

    @Test
    void steering_이전step() {
        // 가짜 Scanner 객체 생성
        Scanner scanner = Mockito.mock(Scanner.class);

        when(scanner.nextLine())
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("0")
                .thenReturn("2")
                .thenReturn("2")
                .thenReturn("1")
                .thenReturn("exit");

        Context context = new Context(scanner);
        context.setState(new CarTypeBuildState());
        context.run();
        context.closeScanner();;

        System.out.println(outContent.toString());

        assertEquals("Continental", context.getCar().getBreakSystem());
    }

    @Test
    void 고장난Engine() {
        // 가짜 Scanner 객체 생성
        Scanner scanner = Mockito.mock(Scanner.class);

        when(scanner.nextLine())
                .thenReturn("1")
                .thenReturn("4")
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("exit");

        Context context = new Context(scanner);
        context.setState(new CarTypeBuildState());
        context.run();
        context.closeScanner();;

        System.out.println(outContent.toString());

        assertTrue(outContent.toString().contains("엔진이 고장나있습니다."));

    }

    @Test
    void Run선택Mode_Error생성() {
        // 가짜 Scanner 객체 생성
        Scanner scanner = Mockito.mock(Scanner.class);

        when(scanner.nextLine())
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("sdfasfsfd")
                .thenReturn("1231231231")
                .thenReturn("exit");

        Context context = new Context(scanner);
        context.setState(new CarTypeBuildState());
        context.run();
        context.closeScanner();;

        System.out.println(outContent.toString());

        assertTrue(outContent.toString().contains("ERROR :: 숫자만 입력 가능"));
        assertTrue(outContent.toString().contains("ERROR :: Run 또는 Test 중 하나를 선택 필요"));

    }

    @Test
    void Run선택Mode_처음으로() {
        // 가짜 Scanner 객체 생성
        Scanner scanner = Mockito.mock(Scanner.class);

        when(scanner.nextLine())
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("1")
                .thenReturn("0")
                .thenReturn("2")
                .thenReturn("2")
                .thenReturn("2")
                .thenReturn("2")
                .thenReturn("2")
                .thenReturn("exit");

        Context context = new Context(scanner);
        context.setState(new CarTypeBuildState());
        context.run();
        context.closeScanner();;

        System.out.println(outContent.toString());

        assertEquals("SUV", context.getCar().getType());

    }

    @Test
    void sedan_validatorTest() {
        Car car = new CarBuilder()
                .type("Sedan")
                .engine("TOYOTA")
                .breakSystem("Continental")
                .steering("Bosch")
                .build();

        Validator v = new SedanBreakValidator();

        assertFalse(v.check(car));
    }

    @Test
    void SUV_validatorTest() {
        Car car = new CarBuilder()
                .type("SUV")
                .engine("TOYOTA")
                .breakSystem("Continental")
                .steering("Bosch")
                .build();

        Validator v = new SuvEngineValidator();

        assertFalse(v.check(car));
    }

    @Test
    void truck_break_validatorTest() {
        Car car = new CarBuilder()
                .type("Truck")
                .engine("TOYOTA")
                .breakSystem("MANDO")
                .steering("Bosch")
                .build();

        Validator v = new TruckBreakValidator();

        assertFalse(v.check(car));
    }

    @Test
    void truck_engine_validatorTest() {
        Car car = new CarBuilder()
                .type("Truck")
                .engine("WIA")
                .breakSystem("MANDO")
                .steering("Bosch")
                .build();

        Validator v = new TruckEngineValidator();

        assertFalse(v.check(car));
    }

    @Test
    void bosch_validatorTest() {
        Car car = new CarBuilder()
                .type("Truck")
                .engine("WIA")
                .breakSystem("Bosch")
                .steering("Mobis")
                .build();

        Validator v = new BoschBreakValidator();

        assertFalse(v.check(car));
    }
}