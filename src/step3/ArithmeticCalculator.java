package step3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T> {

    private List<Object> resultList = new ArrayList<Object>();

    public List<Object> getResultList() {
        return resultList;
    }

    public void setResultList(List<Object> resultList) {
        this.resultList = resultList;
    }

    public <T extends Number> T calculate(T num1, T num2, char operator) {
        OperatorType opType = OperatorType.from(operator);
        BigDecimal n1 = new BigDecimal(num1.toString());
        BigDecimal n2 = new BigDecimal(num1.toString());
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

    public List<Object> removeResult(){
        resultList.remove(0);
        return resultList;
    }

}
