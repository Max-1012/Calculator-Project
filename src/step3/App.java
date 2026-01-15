package step3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator<>();
        boolean exit = false;
        while(!exit){
            Number num1,num2;
            try{
                System.out.print("첫 번째 숫자를 입력하세요 : ");
                num1 = scanner.nextBigDecimal();
                System.out.print("두 번째 숫자를 입력하세요 : ");
                num2 = scanner.nextBigDecimal();
            }catch (Exception e){
                System.out.println("숫자 값을 입력하세요");
                scanner.nextLine();
                continue;
            }

            System.out.print("사칙 연산 기호를 입력하세요 : ");
            char operator = scanner.next().charAt(0);

            Number result;
            try{
                result = calculator.calculate(num1,num2,operator);

            }catch(ArithmeticException e){
                System.out.println(e.getMessage());
                continue;
            }catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("결과 : " + result.toString());

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) :");
            String str = scanner.next();
            if(str.equals("exit")){
                exit = true;
                System.out.println("계산기 프로그램을 종료합니다.");
            }
        }


        // Getter 확인
        List<Number> resultList = calculator.getResultList();
        System.out.println("resultList = "+ resultList);

        // findBigger 확인
        while(true){
            List<Number> biggerList;
            try{
                System.out.print("비교 기준 값을 입력하세요 : ");
                BigDecimal target = scanner.nextBigDecimal();
                biggerList = calculator.findBigger(target);
            }catch (Exception e){
                System.out.println("비교 가능한 숫자 값을 입력하세요");
                scanner.nextLine();
                continue;
            }
            System.out.println("biggerList = "+ biggerList);
            break;
        }

        // removeResult 함수 확인
        System.out.println("removedList = "+ calculator.removeResult());

        // Setter 확인
        List<Number> newList = new ArrayList<>(List.of(1,2,3,4,5));
        System.out.println("newList = "+ newList);
        calculator.setResultList(newList);
        System.out.println("calculator.getResultList = "+ calculator.getResultList());


    }
}
