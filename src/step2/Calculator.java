package step2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Object> resultList = new ArrayList<Object>();

    public List<Object> getResultList() {
        return resultList;
    }

    public void setResultList(List<Object> resultList) {
        this.resultList = resultList;
    }

    public Object calculate(int num1, int num2, char operator) {
       int intResult;
       switch (operator){
           case '/' :
               if(num2==0){
                   throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
               }else{
                   if(num1%num2==0){
                       intResult = num1/num2;
                   }else{
                       double doubleResult = (double)num1 / num2;
                       resultList.add(doubleResult);
                       return doubleResult;
                   }
               }
               break;
           case '+' : intResult = num1 + num2; break;
           case '-' : intResult = num1 - num2; break;
           case '*' : intResult = num1 * num2; break;
           default :
               throw new ArithmeticException("올바른 사칙연산 기호를 입력하세요");
       }
       resultList.add(intResult);
       return intResult;
   }

   public List<Object> removeResult(){
        resultList.remove(0);
        return resultList;
   }

}


