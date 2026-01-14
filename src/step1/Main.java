package step1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
     static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산기 프로그램을 수행합니다.");

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
            switch (operator){
                case '/' :
                    if(num2==0){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        continue;
                    }
                    result = num1/num2; break;
                case '+' : result = num1 + num2;  break;
                case '-' : result = num1 - num2;  break;
                case '*' : result = num1 * num2;  break;
                default :
                    System.out.println("올바른 사칙연산 기호를 입력하세요"); continue;
            }
            System.out.println("결과: " + result);
            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) :");
            String str = scanner.next();
            if(str.equals("exit")){
                exit = true;
                System.out.println("계산기 프로그램을 종료합니다.");

            }

        }


    }
}
