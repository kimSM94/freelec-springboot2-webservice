package javajungsuk.Chapter8;

public class ExceptionEx7 {
    public static void main(String[] args) {

        try{
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);
        }catch (ArithmeticException ae){
            if(ae instanceof ArithmeticException)
                System.out.println("true");
            System.out.println("ArithmeticException");
        }catch (Exception e){
            System.out.println("Exception");
        }
        System.out.println("종료");
    }
}
