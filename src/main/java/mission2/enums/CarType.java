package mission2.enums;

public enum CarType {

    Sedan("Sedan"),
    SUV("SUV"),
    Truck("Truck")
            ;

    private final String type;

    CarType(String type) {
        this.type = type;
    }

    public String label() {
        return type;
    }
}