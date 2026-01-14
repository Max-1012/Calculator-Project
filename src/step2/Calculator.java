package step2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> resultList = new ArrayList<Integer>();

    public List<Integer> getResultList() {
        return resultList;
    }

    public void setResultList(List<Integer> resultList) {
        this.resultList = resultList;
    }

    public Integer calculate(int num1, int num2, char operator) {
       int result;
       switch (operator){
           case '/' :
               if(num2==0){
                   throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
               }else{
                   result = num1/num2;               }
               break;
           case '+' : result = num1 + num2; break;
           case '-' : result = num1 - num2; break;
           case '*' : result = num1 * num2; break;
           default :
               throw new ArithmeticException("올바른 사칙연산 기호를 입력하세요");
       }
       resultList.add(result);
       return result;
   }

   public List<Integer> removeResult(){
        resultList.remove(0);
        return resultList;
   }

}


