package step3;

import step2.Calculator;

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
                if(num1< 0 || num2 <0){
                    throw new Exception();
                }
            }catch (Exception e){
                System.out.println("양의 정수 값을 입력하세요");
                scanner.nextLine();
                continue;
            }

            System.out.print("사칙 연산 기호를 입력하세요 : ");
            char operator = scanner.next().charAt(0);
            int result;
            try{
                result = calculator.calculate(num1,num2,operator);

            }catch(ArithmeticException e){
                System.out.println(e.getMessage());
                continue;
            }catch(Exception e){
                System.out.println("계산 도중 문제가 발생했습니다.");
                continue;
            }
            System.out.println("결과 : " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) :");
            String str = scanner.next();
            if(str.equals("exit")){
                exit = true;
                System.out.println("계산기 프로그램을 종료합니다.");
            }
        }

        // Getter 확인
        List<Integer> resultList = calculator.getResultList();
        System.out.println("resultList = "+ resultList);

        // removeResult 함수 확인
        System.out.println("removedList = "+ calculator.removeResult());

        // Setter 확인
        List<Integer> newList = new ArrayList<>(List.of(1,2,3,4,5));
        System.out.println("newList = "+ newList);
        calculator.setResultList(newList);
        System.out.println("calculator.getResultList = "+ calculator.getResultList());

    }
}
