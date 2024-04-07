package com.test.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<String> getListString(String pathFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            System.out.println("Đọc dữ liệu " + pathFile + " thành công.");
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readFileToString(String filePath) throws IOException {
        Path path = Paths.get(filePath); // Tạo đối tượng Path từ đường dẫn

        // Đọc tất cả byte từ file thành một mảng byte
        byte[] fileBytes = Files.readAllBytes(path);

        // Chuyển đổi mảng byte thành chuỗi sử dụng UTF-8 encoding
        String fileContent = new String(fileBytes, "UTF-8");

        return fileContent;
    }

    public static void main(String[] args) {
        ReadFile.getListString("data\\listAccount.txt");
    }
}
