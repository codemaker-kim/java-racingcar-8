package racingcar.global;

public enum Separator {
    COMMA(","),
    COLON(":"),
    SPACE(" ");

    private final String sign;

    Separator(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
