package javajungsuk.Chapter8;

public class P427 {
    public static void main(String[] args) throws Exception{
        try {
             method1() ;
        }catch(Exception e){
            System.out.println("main메서드에서 예외가 처리되었습니다.");
            e.printStackTrace();
        }
    }

//     static void method1() throws Exception{
//         method2();
//    }

    static void method1()  throws Exception{
//        try{
            throw new Exception();
//        }catch(Exception e){
//            System.out.println("예외");
//            e.printStackTrace();
//        }

    }
    /*
    * Exception in thread "main" java.lang.Exception
	at javajungsuk.Chapter8.P427.method2(P427.java:13)
	at javajungsuk.Chapter8.P427.method1(P427.java:9)
	at javajungsuk.Chapter8.P427.main(P427.java:5)
    *  예외가 발생했을 떄, 모두 3개의 메서드가 호출스택에 있었음
    *
    * */
}
