package mission2.enums;

public enum SteeringSystem {
    Bosch("Bosch"),
    Mobis("Mobis");

    private final String type;

    SteeringSystem(String type) {
        this.type = type;
    }

    public String label() {
        return type;
    }
}