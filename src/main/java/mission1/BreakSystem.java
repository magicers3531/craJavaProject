package mission1;

public enum BreakSystem{

    Mando("Mando"),
    Continental("Continental"),
    Bosch("Bosch")
    ;

    private final String type;

    BreakSystem(String type) {
        this.type = type;
    }

    public String label() {
        return type;
    }
}