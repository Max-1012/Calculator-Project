package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
     static void main() {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        boolean exit = false;
        while(!exit){
            int num1,num2;
            try{
                System.out.print("첫 번째 숫자를 입력하세요 : ");
                num1 = scanner.nextInt();
                System.out.print("두 번째 숫자를 입력하세요 : ");
                num2 = scanner.nextInt();
            }catch (Exception e){
                System.out.println("정수형 값을 입력하세요");
                scanner.nextLine();
                continue;
            }

            System.out.print("사칙 연산 기호를 입력하세요 : ");
            char operator = scanner.next().charAt(0);
            Object result;
            try{
                result = calculator.calculate(num1,num2,operator);

            }catch(ArithmeticException e){
                System.out.println(e.getMessage());
                continue;
            }catch(Exception e){
                System.out.println("계산 도중 문제가 발생했습니다.");
                continue;
            }
            // 계산 결과 타입 확인
            if(result instanceof Integer){
                int intResult = (int)result;
                System.out.println("결과 : "+intResult);
            }else if(result instanceof Double){
                double doubleResult = (double)result;
                System.out.println("결과 : "+doubleResult);
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) :");
            String str = scanner.next();
            if(str.equals("exit")){
                exit = true;
                System.out.println("계산기 프로그램을 종료합니다.");
            }
        }

        // Getter 확인
        List<Object> resultList = calculator.getResultList();
        System.out.println("resultList = "+ resultList);

        // removeResult 함수 확인
         System.out.println("removedList = "+ calculator.removeResult());

        // Setter 확인
        List<Object> newList = new ArrayList<>();
         for (int i = 0; i < 5; i++) {
             newList.add(i);
         }
         System.out.println("newList = "+ newList);
         calculator.setResultList(newList);
         System.out.println("calculator.getResultList = "+ calculator.getResultList());


    }
}
