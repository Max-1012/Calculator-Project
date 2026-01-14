package step3;


import java.util.Arrays;

public enum OperatorType {
    PLUS("+"),

    MINUS("-"),

    MULTIPLY("*"),

    DIVIDE("/");
    private final String operator;

    OperatorType(String operator){
        this.operator = operator;
    }

    public static OperatorType from(char operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(String.valueOf(operator)))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("올바른 연산자가 아닙니다: " + operator));
    }
}





