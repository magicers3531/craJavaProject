package mission2.enums;

public enum EngineType {
    GM("GM"),
    TOYOTA("TOYOTA"),
    WIA("WIA"),
    NotWork("고장난 엔진");

    private final String type;

    EngineType(String type) {
        this.type = type;
    }

    public String label() {
        return type;
    }
}