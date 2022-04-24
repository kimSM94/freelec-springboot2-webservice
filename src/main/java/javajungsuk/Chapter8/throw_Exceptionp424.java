package javajungsuk.Chapter8;

public class throw_Exceptionp424 {

    final static Exception e = new Exception("고의로 발생");

    public static void main(String[] args) {
        try{
            throw e;
        }catch(Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램이 정상적으로 종료");
    }

}
