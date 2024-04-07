package com.test.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void writeNewAccount(String account) {
        String pathFileAccount="data\\User\\listAccount.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileAccount, true))) {
            writer.write(account);
            writer.newLine();
            System.out.println("Thêm tài khoản thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeProfile(String pathFileProfile, String profile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileProfile, true))) {
            writer.write(profile);
            writer.newLine();
            System.out.println("Thêm hồ sơ mới thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void uodateProfile(String pathFileProfile, String profile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileProfile, false))) {
            writer.write(profile);
            writer.newLine();
            System.out.println("Thêm hồ sơ mới thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
