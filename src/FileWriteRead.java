import java.io.*;

public class FileWriteRead {
    public static void main(String[] args) {
        File file = new File("/Users/inna/java files/doc1.txt");

        // прочитали с 1 файла и записали половину во второй файл
        try(FileInputStream fin = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("/Users/inna/java files/doc2.txt")){
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            fos.write(buffer, 0, buffer.length/2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // прочитали с 1 файла и записали вторую половину в третий
        try(FileInputStream fin = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream("/Users/inna/java files/doc3.txt")){
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            fos.write(buffer, buffer.length/2, buffer.length/2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
