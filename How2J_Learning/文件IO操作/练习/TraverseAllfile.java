import java.io.File;

public class TraverseAllfile {
    static long min=Integer.MAX_VALUE;
    static long max=0;
    static File maxFile=null;
    static File minFile=null;
    
    public static void main(String[]args){
        String targetPath="D:/SocketPro";
        File p=new File(targetPath);
        File[]files=p.listFiles();
        Get_All_Files_Name(files);
        Get_MAX_MIN_File(files);
        try {
            System.out.println("The min file name is "+minFile.getName()+" it's size is "+minFile.length());
            System.out.println("The max file name is "+maxFile.getName()+" it's size is "+maxFile.length());
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    private static void Get_All_Files_Name(File[]files){
        for(File tmp:files){
            if(tmp.isDirectory()){
                File[] curfiles=tmp.listFiles();
                Get_All_Files_Name(curfiles);
            }else{
                System.out.println(tmp.getName());
            }
        }
    }

    private static void Get_MAX_MIN_File(File[] files){
        for(File tmp:files){
            if(tmp.isDirectory()){
                File[] curfiles=tmp.listFiles();
                Get_MAX_MIN_File(curfiles);
            }else{
                if(tmp.length()<min){
                    min=tmp.length();
                    minFile=tmp;
                }
                if(tmp.length()>max){
                    max=tmp.length();
                    maxFile=tmp;
                }
            }
        }
    }
}
