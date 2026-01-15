package step4;


import java.util.Arrays;

public enum OperatorType implements Operation {
    PLUS('+',(first, second) -> first + second),
    MINUS('-',(first, second) -> first - second),
    MULTIPLY('*',(first, second) -> first * second),
    DIVIDE('/',(first, second) -> first / second);

//    private final Operation operation;
    private final char operator;
    private  final Operation operation;

    OperatorType(char operator, Operation operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public double apply(double first, double second) {
        return operation.apply(first, second);
    }

    //스트림 부분
    public static double calculate(char operation, double first, double second) {
        return Arrays.stream(OperatorType.values())
                .filter(op -> op.operator == operation)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Unsupported operator: " + operation)
                )
                .apply(first, second);
    }

}


