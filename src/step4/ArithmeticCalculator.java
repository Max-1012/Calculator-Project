//package step4;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ArithmeticCalculator<T> {
//
//    private List<Object> resultList = new ArrayList<Object>();
//
//    public List<Object> getResultList() {
//        return resultList;
//    }
//
//    public void setResultList(List<Object> resultList) {
//        this.resultList = resultList;
//    }
//
//    public Object calculate(T num1, T num2, char operator) {
//        Double n1,n2;
//        try{
//            if(num1 instanceof Double){
//                n1 = (Double)num1;
//            }else{
//                throw new Exception();
//            }
//            if(num2 instanceof Double){
//                n2 = (Double)num2;
//            }else{
//                throw new Exception();
//            }
//        }catch(Exception e){
//            System.out.println("double 형으로 변환 불가능");
//            return null;
//        }
//
//        try{
//            double result = OperatorType.calculate(operator,n1,n2);
//            return result;
//        }catch(IllegalArgumentException e ){
//            System.out.println(e.getMessage());
//        }
//
////        Double result;
////        switch (operator){
////            case DIVIDE:
////                if(num2.equals(0)){
////                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
////                }else{
////                    double res = OperatorType.calculate(,n1,n2);
////                }
////                break;
////            case PLUS : result = num1 + num2; break;
////            case '-' : result = num1 - num2; break;
////            case '*' : result = num1 * num2; break;
////            default :
////                throw new ArithmeticException("올바른 사칙연산 기호를 입력하세요");
////        }
////        resultList.add(result);
//
//    }
//
//    public List<Object> removeResult(){
//        resultList.remove(0);
//        return resultList;
//    }
//
//}
