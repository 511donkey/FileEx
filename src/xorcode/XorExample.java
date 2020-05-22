package xorcode;

import java.io.*;

public class XorExample {
    public static void main(String[] args) {

        try(FileInputStream fi = new FileInputStream("/Users/inna/java files/xor/зашифровать.txt");
            FileOutputStream fo = new FileOutputStream("/Users/inna/java files/xor/расшифровать.txt")) {

            byte[] buffer = new byte[fi.available()];
            fi.read(buffer);

            byte key = '3';

            for (int i = 0; i < buffer.length ; i++) {
              buffer[i] = (byte) (buffer[i] ^ key);
            }

            for (int i = 0; i < buffer.length ; i++) {
              buffer[i] = (byte) (buffer[i] ^ key);
            }

            fo.write(buffer, 0, buffer.length);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
