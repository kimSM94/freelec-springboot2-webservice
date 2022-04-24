package javajungsuk.Chapter8;

import java.io.*;

public class P431 {
    public static void main(String[] args) {
//        File f = File.createTempFile(args[0]);
//        System.out.println(f.getName() +" 파일이 생성");
    }
    
    static File createFile(String fileName){
        try{
            if(fileName.equals(""))
                throw new Exception();
        }catch (Exception e){
            fileName = "제목없음.txt";
        }finally{
            File f = new File(fileName);
            createTempFile(f);
            return f;
        }
    }
    static void createTempFile(File f){
        try{
            f.createNewFile();
        }catch(Exception e){
            
        }
    }
    
}
