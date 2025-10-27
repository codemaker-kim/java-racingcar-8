package racingcar.global;

public enum Seperator {
    COMMA(","),
    COLON(":"),
    SPACE(" ");

    private final String sign;

    Seperator(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
