package step3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T> {

    private List<Number> resultList = new ArrayList<Number>();

    public List<Number> getResultList() {
        return resultList;
    }

    public void setResultList(List<Number> resultList) {
        this.resultList = resultList;
    }

    public <T extends Number> T calculate(T num1, T num2, char operator) {
        OperatorType opType;
        try{
            opType = OperatorType.from(operator);
        }catch (IllegalArgumentException e){
            throw e;
        }
        BigDecimal n1 = new BigDecimal(num1.toString());
        BigDecimal n2 = new BigDecimal(num2.toString());
        BigDecimal result;

        switch (opType){
            case DIVIDE:
                if(n2.equals(BigDecimal.ZERO)){
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }else{
                    result = n1.divide(n2,5, RoundingMode.HALF_UP);
                }
                break;
            case PLUS: result = n1.add(n2); break;
            case MINUS: result = n1.subtract(n2); break;
            case MULTIPLY: result = n1.multiply(n2); break;
            default :
                throw new ArithmeticException("올바른 사칙연산 기호를 입력하세요");
        }
        resultList.add(result);
        return (T)result;
    }

    public List<Number> removeResult(){
        resultList.remove(0);
        return resultList;
    }

    public <T extends Number> List<Number> findBigger(T t){
        BigDecimal target;
        try{
            target = new BigDecimal(t.toString());
        }catch(Exception e){
            throw e;
        }
        return resultList.stream().
                filter(n -> new BigDecimal(n.toString()).compareTo(target) > 0 ).collect(Collectors.toList());
    }
}
