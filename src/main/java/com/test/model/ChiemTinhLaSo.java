package com.test.model;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class ChiemTinhLaSo {
    public static void main(String[] args) {
        int[] id = {11085654, 11098237, 11098259, 11098283, 11098291, 11098305};
        String url = "https://chiemtinhlaso.com/online_calcs/scripts/natal.php?id1=" + id[0];

        try {
            String data = get_data_from_url(url);
            System.out.println(data);

            FileWriter fileWriter = new FileWriter("chiemtinhlaso.txt");
            fileWriter.write(data);
            fileWriter.close();

            System.out.println(data);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String get_data_from_url(String urlStr) throws IOException {
        StringBuilder responseBuilder = new StringBuilder();

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() == 200) {
            Scanner scanner = new Scanner(conn.getInputStream());
            while (scanner.hasNextLine()) {
                responseBuilder.append(scanner.nextLine());
            }
            scanner.close();
        } else {
            System.out.println("Error: " + conn.getResponseCode());
        }

        conn.disconnect();

        String response = responseBuilder.toString();
        String moctrangtroi = response.split("Mặt Trời Bạch Dương<br />")[1].split("</b>")[1].split("<br />")[0];

        return moctrangtroi;
    }
}
