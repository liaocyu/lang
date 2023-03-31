package 工厂模式.抽象工厂模式.Factory;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class test {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("文件名");
            String toByWrote = "你要输出的文字";
            fileOutputStream.write(toByWrote.getBytes(StandardCharsets.UTF_8));
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
