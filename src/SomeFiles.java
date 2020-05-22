import java.io.*;
import java.util.Arrays;

public class SomeFiles {
    public static void main(String[] args) throws IOException {
        String str;

        // записываем из файлов в строку
        try (FileInputStream f1 = new FileInputStream("/Users/inna/java files/собрать файлы/doc1.txt");
             FileInputStream f2 = new FileInputStream("/Users/inna/java files/собрать файлы/doc2.txt");
             ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            SequenceInputStream stream = new SequenceInputStream(f1, f2);

            byte[] bytes = new byte[stream.available()];
            int data;
            while ((data = stream.read(bytes)) > 0) {
                bout.write(bytes, 0, data);
            }
            str = bout.toString();
        }
        System.out.println(str);

        // строку записываем в файл
        try (FileOutputStream fout = new FileOutputStream("/Users/inna/java files/собрать файлы/doc3.txt", false)) {
            byte[] bytes = str.getBytes();
            fout.write(bytes);
        }
    }

}
