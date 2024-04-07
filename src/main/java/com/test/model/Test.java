package com.test.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) {
        try {
//            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "ping stackjava.com -n 5");
            ProcessBuilder builder = new ProcessBuilder("C:\\Windows\\System32\\cmd.exe", "/c", "python D:\\0000.CODE\\00. ProPTIT\\ProZodiac1\\src\\main\\java\\com\\test\\model\\chiemtinhlaso.py");

            Process p = builder.start();

            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("Lỗi khi thực hiện lệnh: " + ex.toString());
        }
    }
}
